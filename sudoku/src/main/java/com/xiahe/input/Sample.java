package com.xiahe.input;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Sample {
    public static Map<String, Map<Character, BufferedImage>> samples;
    private static String files[] = {"81", "256"};

    // 初始化
    static {
        try {
            samples = new HashMap<>();
            for (String file : files) load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 加载
    private static void load(String name) throws Exception {
        Map<Character, BufferedImage> sample = new HashMap<>();
        // 加载基本信息
        InputStream inputStream = Sample.class.getResourceAsStream("/sample/" + name + ".txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = bufferedReader.readLine();
        String[] bufferedImages = line.split(" ");
        // 加载位图信息
        for (int i = 0; i < bufferedImages.length; i++) {
            line = bufferedReader.readLine();
            BufferedImage bufferedImage = new BufferedImage((int) Math.sqrt(line.length()), (int) Math.sqrt(line.length()), BufferedImage.TYPE_3BYTE_BGR);
            for (int x = 0; x < bufferedImage.getHeight(); x++) {
                for (int y = 0; y < bufferedImage.getWidth(); y++) {
                    bufferedImage.setRGB(x, y, line.charAt(x * bufferedImage.getHeight() + y) == '1' ? 0xFF000000 : 0xFFFFFFFF);
                }
            }
            sample.put(bufferedImages[i].charAt(0), bufferedImage);
        }
        // 释放资源
        bufferedReader.close();
        inputStream.close();
        samples.put(name, sample);
    }

}
