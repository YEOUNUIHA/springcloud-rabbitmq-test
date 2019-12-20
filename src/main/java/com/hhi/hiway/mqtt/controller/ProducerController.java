package com.hhi.hiway.mqtt.controller;

import com.hhi.hiway.mqtt.binding.HelloBinding;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.*;

@Slf4j
@EnableBinding({HelloBinding.class})
@RestController
public class ProducerController {
    private MessageChannel greet;

    public ProducerController(HelloBinding binding) {
        greet = binding.greeting();
    }

    @GetMapping("/greet/{name}")
    public void publish(@PathVariable String name){
        String greeting = "Hello, "+ name + "~!!";
        Message<String> msg  = MessageBuilder.withPayload(greeting).build();
        greet.send(msg);
        log.info("end");
    }


}
