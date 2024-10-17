package com.javaacademy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Бутылка
 */

@ToString
public class Bottle {
    @Getter
    private final double volume;
    @Setter
    private double nestedVolume;
    private final String cityProducer;

    public Bottle(double volume, String cityProducer) {
        this.volume = volume;
        this.cityProducer = cityProducer;
    }

    public void addLiquid(double liquidVolume) {
        if (liquidVolume > nestedVolume) {
            throw  new RuntimeException("Объем добавляемой жидкости больше чем объем бутылки");
        }
        double newNestedVolume = nestedVolume + liquidVolume;
        if (newNestedVolume > volume) {
            throw  new RuntimeException("Нет места в бутылки, все выливается!");
        }
        setNestedVolume(newNestedVolume);
    }
}
