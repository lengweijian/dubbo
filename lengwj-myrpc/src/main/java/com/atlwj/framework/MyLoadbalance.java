package com.atlwj.framework;

import java.util.List;
import java.util.Random;

public class MyLoadbalance {

    public static Url random (List<Url> urls){
        return urls != null ? urls.get(new Random().nextInt(urls.size())) : null;
    }
}
