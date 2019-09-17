package com.atlwj.di.service;

import com.atlwj.di.entity.Wheel;
import org.apache.dubbo.common.URL;

public interface WheelMaker {
    Wheel makeWheel(URL url);
}
