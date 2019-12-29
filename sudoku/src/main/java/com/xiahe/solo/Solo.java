package com.xiahe.solo;

import com.xiahe.core.Index;

public class Solo {

    public static void main(String[] args) {
        try {
            execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void execute() throws Exception {
        Index[][] input = Complex.reader.read();
        Complex.writer.print(input);
        input = Complex.core.core(input);
        Complex.writer.write(input);
    }

}
