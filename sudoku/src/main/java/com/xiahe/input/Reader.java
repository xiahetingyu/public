package com.xiahe.input;

import com.xiahe.core.Index;
import com.xiahe.tools.WindowsTools;

import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.Map;

public class Reader {
    private static Index[][] indices;

    //读取一个棋盘
    public Index[][] read() throws Exception {
        BufferedImage bufferedImage = getBufferedImage();
        indices = build(bufferedImage);
        indices = discern(bufferedImage, indices);
        indices = check(indices);
        return indices;
    }

    //获取图像
    private BufferedImage getBufferedImage() throws Exception {
        WindowsTools.find();
        WindowsTools.show();
        WindowsTools.reSize();
        return Support.binarization(WindowsTools.screenCapture());
    }

    //构建坐标
    private Index[][] build(BufferedImage bufferedImage) {
        if (!(bufferedImage.getWidth() == 677 || bufferedImage.getWidth() == 679)) throw new RuntimeException("棋盘读取错误");
        indices = bufferedImage.getWidth() == 677 ? new Index[9][9] : new Index[16][16];
        for (int j = 0; j < indices.length; j++) {
            for (int i = 0; i < indices.length; i++) {
                indices[j][i] = indices.length == 9 ? new Index(74 + 66 * i, 116 + 66 * j) : new Index(46 + 39 * i, 88 + 39 * j);
            }
        }
        return indices;
    }

    //识别棋盘
    private Index[][] discern(BufferedImage bufferedImage, Index[][] indices) {
        Map<Character, BufferedImage> samples = Sample.samples.get(String.valueOf(indices.length * indices.length));
        for (int j = 0; j < indices.length; j++) {
            for (int i = 0; i < indices.length; i++) {
                Index index = indices[j][i];
                int off = indices.length == 9 ? 20 : 10, size = indices.length == 9 ? 40 : 20;
                compared(samples, bufferedImage.getSubimage(index.x - off, index.y - off, size, size), index);
            }
        }
        return indices;
    }

    //识别棋子
    private void compared(Map<Character, BufferedImage> samples, BufferedImage bufferedImage, Index index) {
        index.values = new HashSet<>(samples.keySet());
        index.value = '0';
        compared1:
        for (int i = 0; i < bufferedImage.getWidth(); i++) {
            for (int j = 0; j < bufferedImage.getHeight(); j++) {
                if (bufferedImage.getRGB(i, j) == 0xFF000000) {
                    index.value = null;
                    break compared1;
                }
            }
        }
        if (index.value != null) return;//空图像

        compared2:
        for (Map.Entry<Character, BufferedImage> characterBufferedImageEntry : samples.entrySet()) {
            BufferedImage value = characterBufferedImageEntry.getValue();
            for (int i = 0; i < value.getWidth(); i++) {
                for (int j = 0; j < value.getHeight(); j++) {
                    if (bufferedImage.getRGB(i, j) != value.getRGB(i, j)) continue compared2;
                }
            }
            index.value = characterBufferedImageEntry.getKey();
            if (index.value != null) return;
        }
    }

    //验证
    private Index[][] check(Index[][] indices) {
        for (int j = 0; j < indices.length; j++) {
            for (int i = 0; i < indices.length; i++) {
                if (indices[j][i].value == null) throw new RuntimeException("棋盘读取错误");
            }
        }
        return indices;
    }

}
