package com.atlwj;

import DemoService;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Java SPI机制
 *
 *
 */
public class Java_Spi_App {
    public static void main(String[] args) {
        ServiceLoader<DemoService> loadedDrivers = ServiceLoader.load(DemoService.class);
        Iterator<DemoService> driversIterator = loadedDrivers.iterator();
        while (driversIterator.hasNext()) {
            final DemoService next = driversIterator.next();
            next.sayHi("lengwj");
        }
    }
}
