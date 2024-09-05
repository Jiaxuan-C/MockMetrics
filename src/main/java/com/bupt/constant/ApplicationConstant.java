package com.bupt.constant;


public class ApplicationConstant {
    // 指标类型
    public static final String  METRIC_TEMPERATURE = "temperature";
    public static final String  METRIC_HUMIDITY = "humidity";
    public static final String  METRIC_PRESSURE_LEVEL = "pressure_level";
    public static final String  METRIC_ILLUMINATION = "illumination";
    public static final String  METRIC_ElEC_LATHE = "lathe";
    public static final String  METRIC_ElEC_MILLING = "milling";
    public static final String  METRIC_ElEC_POWER = "power";
    public static final String  METRIC_ElEC_TRANSFORMER = "transformer";
    public static final String  METRIC_ElEC_UPS = "ups";
    public static final String  METRIC_TANK_WATER_LEVEl = "tank_water_level";
    public static final String  METRIC_IN_WATER_TEMP = "in_water_temp";
    public static final String  METRIC_OUT_WATER_TEMP = "out_water_temp";



    // 指标阈值
    public static final Double  TEMPERATURE_THRESHOLD_UP = 40.0;
    public static final Double  TEMPERATURE_THRESHOLD_DOWN = 10.0;

    public static final Double  HUMIDITY_THRESHOLD_UP = 70.0;
    public static final Double  HUMIDITY_THRESHOLD_DOWN = 30.0;

    public static final Double  PRESSURE_LEVEL_THRESHOLD_UP = 10.0;
    public static final Double  PRESSURE_LEVEL_THRESHOLD_DOWN = 0.8;

    public static final Double  ILLUMINATION_THRESHOLD_UP = 1500.0;
    public static final Double  ILLUMINATION_THRESHOLD_DOWN = 500.0;
    public static final Double  ElEC_LATH_THRESHOLD_UP = 100.0;
    public static final Double  ElEC_LATH_THRESHOLD_DOWN = 0.0;
    public static final Double  ElEC_MILLING_THRESHOLD_UP = 100.0;
    public static final Double  ElEC_MILLING_THRESHOLD_DOWN = 00.0;

    public static final Double  ElEC_POWER_THRESHOLD_UP = 100.0;
    public static final Double  ElEC_POWER_THRESHOLD_DOWN = 00.0;

    public static final Double  ElEC_TRANSFORMER_THRESHOLD_UP = 100.0;
    public static final Double  ElEC_TRANSFORMER_THRESHOLD_DOWN = 00.0;

    public static final Double  ElEC_UPS_THRESHOLD_UP = 100.0;
    public static final Double  ElEC_UPS_THRESHOLD_DOWN = 00.0;
    public static final Double  TANK_WATER_LEVEl_THRESHOLD_UP = 1.0;
    public static final Double  TANK_WATER_LEVEl_THRESHOLD_DOWN = 0.2;
    public static final Double  IN_WATER_TEMP_THRESHOLD_UP = 35.0;
    public static final Double  IN_WATER_TEMP_THRESHOLD_DOWN = 0.0;
    public static final Double  OUT_WATER_TEMP_THRESHOLD_UP = 60.0;
    public static final Double  OUT_WATER_TEMP_THRESHOLD_DOWN = 0.0;
    // Kafka topic
    public static final String  KAFKA_METRIC_TOPIC = "metric_yzs";
}
