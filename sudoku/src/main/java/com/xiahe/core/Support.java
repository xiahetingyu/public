package com.xiahe.core;

import java.util.HashSet;
import java.util.Set;

public class Support {

    //----------------------------扫描和坍缩----------------------------------

    //扫描
    public static Set<Character> scanner(int x, int y, Index[][] map) {
        Set<Character> scanner = new HashSet<>();
        return rank(x, y, block(x, y, scanner, map), map);
    }

    //块扫描
    private static Set<Character> block(int x, int y, Set<Character> block, Index[][] map) {
        if (block == null) block = new HashSet<>();
        int sqrt = (int) Math.sqrt(map.length);
        x = x / sqrt * sqrt + sqrt;
        y = y / sqrt * sqrt + sqrt;
        for (int i = x - sqrt; i < x; i++) {
            for (int j = y - sqrt; j < y; j++) {
                if (map[i][j].value != '0') block.add(map[i][j].value);
            }
        }
        return block;
    }

    //行列扫描
    private static Set<Character> rank(int x, int y, Set<Character> rank, Index[][] map) {
        if (rank == null) rank = new HashSet<>();

        for (int j = 0; j < map[x].length; j++) {//行
            if (map[x][j].value != '0') rank.add(map[x][j].value);
        }

        for (int i = 0; i < map.length; i++) {//列
            if (map[i][y].value != '0') rank.add(map[i][y].value);
        }
        return rank;
    }

    //坍缩
    public static void collapse(int x, int y, Set<Character> temp, Index[][] map) {
        if (map[x][y].value != '0') {
            map[x][y].values.clear();
            map[x][y].values.add(map[x][y].value);
        }
        if (map[x][y].value == '0') map[x][y].values.removeAll(temp);
    }

    //深度复制
    public static Index[][] deepCopyMap(Index[][] map) {
        Index[][] result = new Index[map.length][map.length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                result[i][j] = new Index(new HashSet<>(map[i][j].values));
                result[i][j].value = map[i][j].value;
                result[i][j].x = map[i][j].x;
                result[i][j].y = map[i][j].y;
            }
        }
        return result;
    }

}
