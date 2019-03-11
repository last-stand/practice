package com.company;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

class Bike{
     void run() {
        System.out.println("Running...");
    }
}

class Pulsar extends Bike {
    @Override
    void run() {
        System.out.println("Running fast with 100");
    }
}

public class RuntimePolymorphism {
    public static void main(String[] args) {
        Bike myBike = new Pulsar();
        myBike.run();
    }
}
