package com.bupt.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import com.bupt.model.MetricMessage;

@Mapper
public interface MetricMassageMapper {
    @Insert("insert into metric_messages (metric, value, timestamp, timestamp_unix, threshold_up, threshold_down) " +
            "values (#{metric}, #{value}, #{timestamp}, #{timestampUnix}, #{thresholdUp}, #{thresholdDown})")
    public void InsertMetricMassage(MetricMessage massage);

}
