package com.company;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author xiaohaitao
 * @date 2020/10/20 20:16
 */
public class MyClassLoader extends ClassLoader {

    private final String classPath;

    public MyClassLoader(String classPath) {
        this.classPath = classPath;
    }

    private byte[] loadBytes(String filePath) throws Exception {
        Path path = Paths.get(filePath);
        byte[] bytes = Files.readAllBytes(path);

        byte byte_255 = (byte) 255;
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (byte_255 - bytes[i]);
        }
        return bytes;
    }


    @Override
    protected Class<?> findClass(String name) {
        byte[] data = new byte[0];
        try {
            data = loadBytes(classPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Class clazz = defineClass(name, data, 0, data.length);
        return clazz;
    }
}
