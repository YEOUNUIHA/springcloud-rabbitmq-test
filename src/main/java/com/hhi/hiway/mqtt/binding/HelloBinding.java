package com.hhi.hiway.mqtt.binding;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface HelloBinding {

    String GRETTING = "greetingChannel";
    @Output(GRETTING)
    MessageChannel greeting();


}
