package com.javaacademy;

import lombok.Value;

import java.util.Objects;

@Value
public class Garbage {
    GarbageType garbageType;
    double weight;
    String cityFrom;
}
