package com.extadaptpr.service;

import com.extadaptpr.domain.Wheel;
import org.apache.dubbo.common.URL;

public interface WheelMaker {
    Wheel makeWheel(URL url);
}
