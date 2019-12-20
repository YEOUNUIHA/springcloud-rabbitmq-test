package com.hhi.hiway.mqtt.listener;

import com.hhi.hiway.mqtt.binding.HelloBinding;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.scheduling.annotation.Async;

@Slf4j
@EnableBinding(HelloBinding.class)
public class HelloListener {

    @Async
    @StreamListener(target = HelloBinding.GRETTING)
    public void processHelloChannelGreeting(String msg) throws InterruptedException {
        log.info("listener start");
        Thread.sleep(5000);
        System.out.println(msg);
    }
}
