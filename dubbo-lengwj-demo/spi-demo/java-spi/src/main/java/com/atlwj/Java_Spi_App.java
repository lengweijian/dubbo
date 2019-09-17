package com.atlwj;

import com.atlwj.service.HelloService;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Java SPI机制
 *
 *
 */
public class Java_Spi_App {
    public static void main(String[] args) {
        ServiceLoader<HelloService> loadedDrivers = ServiceLoader.load(HelloService.class);
        Iterator<HelloService> driversIterator = loadedDrivers.iterator();
        while (driversIterator.hasNext()) {
            final HelloService next = driversIterator.next();
            next.say("lengwj");
        }
    }
}
