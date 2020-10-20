package com.company;

import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
        MyClassLoader loader = new MyClassLoader("Hello.xlass");
        Class<?> aClass = null;
        try {
            aClass = loader.findClass("Hello");
            Object obj = aClass.newInstance();
            Method method = aClass.getMethod("hello");
            method.invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
