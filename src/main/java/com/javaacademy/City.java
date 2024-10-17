package com.javaacademy;

import lombok.Getter;
import lombok.NonNull;

/**
 * Город
 */
//@ToString(exclude = {"peopleCount"})
public class City {
    @NonNull
    @Getter
    public final String name;
    public int peopleCount;

    public City(String name, Integer peopleCount) {
        this.name = name;
        this.peopleCount = peopleCount;
    }

    public Garbage[] createGarbage() {
        return new Garbage[] {
            new Garbage(GarbageType.GLASS, 1000, this.name),
            new Garbage(GarbageType.PAPER, 15000, this.name),
            new Garbage(GarbageType.MIXED, 200000, this.name),
        };
    }

    public Integer getPeopleCount() {
        return (Integer) peopleCount;
    }

    public void setPeopleCount(Integer peopleCount) {
        this.peopleCount = peopleCount;
    }

    //Внимание, только город выводится на экран
    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                '}';
    }
}
