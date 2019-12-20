package com.hhi.hiway.mqtt.influxdb;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface InfluxBinding {

    String CHANNEL_NAME = "influxdb";

    @Output(CHANNEL_NAME)
    MessageChannel outFluxDb();

    @Input(CHANNEL_NAME)
    SubscribableChannel inFluxDb();
}
