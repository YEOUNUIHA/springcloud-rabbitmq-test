package com.hhi.hiway.mqtt.influxdb;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class influxVO {
    private String name;
    private String state;
    private String street;
    private int number;
    private int value;
}
