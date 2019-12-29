package com.xiahe.input;

import java.awt.image.BufferedImage;

public class Support {

    // 二值化
    public static BufferedImage binarization(BufferedImage bufferedImage) {
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                bufferedImage.setRGB(j, i, bufferedImage.getRGB(j, i) > 0xFFDDDDDD ? 0xFFFFFFFF : 0xFF000000);
            }
        }
        return bufferedImage;
    }

}
