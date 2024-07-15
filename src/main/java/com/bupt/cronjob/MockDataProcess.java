package com.bupt.cronjob;


import cn.hutool.json.JSONUtil;
import com.bupt.constant.ApplicationConstant;
import com.bupt.mapper.MetricMassageMapper;
import com.bupt.model.MetricMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Component
public class MockDataProcess {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private MetricMassageMapper metricMassageMapper;

    @Scheduled(cron = "*/5 * * * * *")
    public void pushMetric() {
        // 温度mock
        buildMessageAndPush(
                ApplicationConstant.METRIC_TEMPERATURE,
                ApplicationConstant.TEMPERATURE_THRESHOLD_UP,
                ApplicationConstant.TEMPERATURE_THRESHOLD_DOWN,
                20.1);
        // 湿度mock
        buildMessageAndPush(
                ApplicationConstant.METRIC_HUMIDITY,
                ApplicationConstant.HUMIDITY_THRESHOLD_UP,
                ApplicationConstant.HUMIDITY_THRESHOLD_DOWN,
                68.2);
        // 压强mock
        buildMessageAndPush(
                ApplicationConstant.METRIC_PRESSURE_LEVEL,
                ApplicationConstant.PRESSURE_LEVEL_THRESHOLD_UP,
                ApplicationConstant.PRESSURE_LEVEL_THRESHOLD_DOWN,
                1.1);
        // 光照mock
        buildMessageAndPush(
                ApplicationConstant.METRIC_ILLUMINATION,
                ApplicationConstant.ILLUMINATION_THRESHOLD_UP,
                ApplicationConstant.ILLUMINATION_THRESHOLD_DOWN,
                10.2);
        // 电力-车床mock
        buildMessageAndPush(
                ApplicationConstant.METRIC_ElEC_LATHE,
                ApplicationConstant.ElEC_LATH_THRESHOLD_UP,
                ApplicationConstant.ElEC_LATH_THRESHOLD_DOWN,
                68.9);
        // 电力-铣床mock
        buildMessageAndPush(
                ApplicationConstant.METRIC_ElEC_MILLING,
                ApplicationConstant.ElEC_MILLING_THRESHOLD_UP,
                ApplicationConstant.ElEC_MILLING_THRESHOLD_DOWN,
                77.1);
        // 电力-市电mock
        buildMessageAndPush(
                ApplicationConstant.METRIC_ElEC_POWER,
                ApplicationConstant.ElEC_POWER_THRESHOLD_UP,
                ApplicationConstant.ElEC_POWER_THRESHOLD_DOWN,
                60.1);
        // 电力-变压器mock
        buildMessageAndPush(
                ApplicationConstant.METRIC_ElEC_TRANSFORMER,
                ApplicationConstant.ElEC_TRANSFORMER_THRESHOLD_UP,
                ApplicationConstant.ElEC_TRANSFORMER_THRESHOLD_DOWN,
                100.1);
        // 电力-UPSmock
        buildMessageAndPush(
                ApplicationConstant.METRIC_ElEC_UPS,
                ApplicationConstant.ElEC_UPS_THRESHOLD_UP,
                ApplicationConstant.ElEC_UPS_THRESHOLD_DOWN,
                20.1);
        // 水箱水位高度mock
        buildMessageAndPush(
                ApplicationConstant.METRIC_TANK_WATER_LEVEl,
                ApplicationConstant.TANK_WATER_LEVEl_THRESHOLD_UP,
                ApplicationConstant.TANK_WATER_LEVEl_THRESHOLD_DOWN,
                0.6);
        // 暖通系统入水口温度mock
        buildMessageAndPush(
                ApplicationConstant.METRIC_IN_WATER_TEMP,
                ApplicationConstant.IN_WATER_TEMP_THRESHOLD_UP,
                ApplicationConstant.IN_WATER_TEMP_THRESHOLD_DOWN,
                10.7);
        // 暖通系统出水口温度mock
        buildMessageAndPush(
                ApplicationConstant.METRIC_OUT_WATER_TEMP,
                ApplicationConstant.OUT_WATER_TEMP_THRESHOLD_UP,
                ApplicationConstant.OUT_WATER_TEMP_THRESHOLD_DOWN,
                40.7);
    }

    public void buildMessageAndPush(String metric, Double thresholdUp, Double thresholdDown, Double value) {
        // 时间
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
        String formattedTime = now.format(formatter);

        MetricMessage tempData = MetricMessage.builder()
                .metric(metric)
                .thresholdUp(thresholdUp)
                .thresholdDown(thresholdDown)
                .timestamp(formattedTime)
                // TODO mock metric value
                //.value(10.0 + (Math.random() * 10.0))
                .value(value)
                .timestampUnix(System.currentTimeMillis())
                .build();
        String dataStr = JSONUtil.toJsonStr(tempData);
        // TODO 写CK
        metricMassageMapper.InsertMetricMassage(tempData);
        // 推送Kafka
        kafkaTemplate.send(ApplicationConstant.KAFKA_METRIC_TOPIC, "metric",dataStr);
        log.info("send data to kafka...");
    }
}
