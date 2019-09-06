package com.extadaptpr.service.impl;

import com.extadaptpr.domain.Wheel;
import com.extadaptpr.service.WheelMaker;
import org.apache.dubbo.common.URL;

/**
 * 造轮子
 */
public class WheelMakerImpl implements WheelMaker {

    public Wheel makeWheel(URL url) {
        return new Wheel();
    }
}
