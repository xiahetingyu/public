package com.xiahe.core;

import java.util.Set;

//坐标
public class Index {
    public int x, y;//真实坐标
    public Character value;//真实值
    public Set<Character> values;//可能值

    public Index(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Index(Set<Character> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
//        return value + "(" + x + "," + y + ")";
//        return values.toString();
    }
}
