package com.hhi.hiway.mqtt.influxdb;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

//@EnableBinding(InfluxBinding.class)
public class InfluxListener {
    @StreamListener(target = InfluxBinding.CHANNEL_NAME)
    public void processInflux(String msg){


        System.out.println(msg);
    }


}
