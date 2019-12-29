package com.xiahe.output;

import com.xiahe.core.Index;

public class Writer {

    //写出一个棋盘
    public void write(Index[][] input) throws Exception {
        print(input);
        input(input);
    }

    public void print(Index[][] input) {
        for (int j = 0; j < input.length; j++) {
            for (int i = 0; i < input.length; i++) {
                System.out.print(input[j][i] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void input(Index[][] input) {
        for (int j = 0; j < input.length; j++) {
            for (int i = 0; i < input.length; i++) {
                Support.input(input[j][i]);
            }
        }
    }

}
