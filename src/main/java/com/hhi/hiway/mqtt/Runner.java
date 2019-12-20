package com.hhi.hiway.mqtt;

import com.hhi.hiway.mqtt.binding.HelloBinding;
import com.hhi.hiway.mqtt.influxdb.InfluxBinding;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.influxdb.InfluxDB;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

//@Component
//@EnableBinding(HelloBinding.class)
//@RequiredArgsConstructor
public class Runner implements ApplicationRunner {

    private InfluxDB influxDB;

    private MessageChannel influxChannel;

    public Runner (HelloBinding influxBinding, InfluxDB influxDB){
        this.influxChannel = influxBinding.greeting();
        this.influxDB = influxDB;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        String query = "SELECT * FROM h2o_feet LIMIT 5";
//        Query query1 = new Query(query,"NOAA_water_database");
//        QueryResult result = influxDB.query(query1);
//        result.getResults().get(0).getSeries();

        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                for(int i = 0 ; i <10 ; i ++) {
                    System.out.println("start runner");
                    String greeting = "Hello~!!";
                    Message<String> msg = MessageBuilder.withPayload(greeting).build();
//                    influxChannel.send(msg);
                    Thread.sleep(1000);
                    System.out.println("end runner");
                }
            }
        }).start();
    }
}
