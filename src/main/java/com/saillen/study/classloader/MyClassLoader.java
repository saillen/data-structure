package com.saillen.study.classloader;

import java.io.File;

/**
 * @author : saillen
 * @date: 2020/4/21
 **/
public class MyClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file = new File("");

        return super.findClass(name);

    }
}
