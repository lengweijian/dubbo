package com.extadaptpr.service;

import com.extadaptpr.domain.Car;
import org.apache.dubbo.common.URL;

public interface CarMaker {
    Car makeCar(URL url);
}
