package com.extadaptpr.service.impl;

import com.extadaptpr.domain.Car;
import com.extadaptpr.domain.Wheel;
import com.extadaptpr.service.CarMaker;
import com.extadaptpr.service.WheelMaker;
import org.apache.dubbo.common.URL;

/**
 * 一个扩展点可以依赖其它扩展点  setter
 */
public class RaceCarMaker implements CarMaker {

    WheelMaker wheelMaker;

    public void setWheelMaker(WheelMaker wheelMaker) {
        this.wheelMaker = wheelMaker;
    }

    public Car makeCar(URL url) {

        // 1.先造轮子
        final Wheel wheel = wheelMaker.makeWheel(url);

        // 2.再造车并把车返回
        return new Car(wheel);
    }
}
