package com.atlwj.provider.register;

import com.atlwj.framework.Url;
import lombok.extern.log4j.Log4j2;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoteMapRegister {

    private static Map<String, List<Url>> REGISTER = new HashMap<>();


    public static void regist(String interfaceName, Url url){

        List<Url> list = REGISTER.get(interfaceName);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(url);
        REGISTER.put(interfaceName, list);
        saveFile();
    }

    public static List<Url> get(String interfaceName) {
        REGISTER = getFile();
        return REGISTER.get(interfaceName);
    }

    private static void saveFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("/Users/lengweijian/workspace/myworkspace/LengWJ-dubbo/dubbo/lengwj-myrpc/src/main/resources/temp.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(REGISTER);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, List<Url>> getFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream("/Users/lengweijian/workspace/myworkspace/LengWJ-dubbo/dubbo/lengwj-myrpc/src/main/resources/temp.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (Map<String, List<Url>>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
