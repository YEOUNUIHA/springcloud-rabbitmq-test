package com.hhi.hiway.mqtt.influxdb;

import lombok.RequiredArgsConstructor;
import org.influxdb.InfluxDB;
import org.influxdb.dto.BatchPoints;
import org.influxdb.dto.Point;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class InfluxService {
    private final InfluxDB influxDB;


    private void inputData(List<influxVO> list){
        influxDB.enableGzip();
        influxDB.setRetentionPolicy("autogen");

        BatchPoints batchPoints = BatchPoints.database("test_db")
                .retentionPolicy("autogen").build();

        long currentTime = System.currentTimeMillis();

        for(influxVO item : list){
            batchPoints.point(Point.measurement("test_db")
                    .time(currentTime, TimeUnit.MILLISECONDS)
                    .tag("state",item.getState())
                    .tag("number",item.getNumber()+"")
                    .addField(item.getName(),item.getValue())
                    .build());
        }

        influxDB.write(batchPoints);
        influxDB.close();

    }
}
