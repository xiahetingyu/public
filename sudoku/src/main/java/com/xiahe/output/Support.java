package com.xiahe.output;

import com.xiahe.core.Index;
import com.xiahe.tools.WindowsTools;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class Support {
    public static Robot robot;

    //选中
    public static void select(Index index) {
        WindowsTools.show();
        robot.mouseMove(index.x, index.y);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    //输入
    public static void input(Index index, Character input) {
        robot.delay(50);
        select(index);
        robot.keyPress(code.containsKey(input) ? code.get(input) : input);
        robot.keyRelease(code.containsKey(input) ? code.get(input) : input);
    }

    public static void input(Index index) {
        input(index, index.value == '0' ? '\b' : index.value);
    }

    private static Map<Character, Integer> code = new HashMap<>();

    static {
        char[] keys = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        int[] values = {KeyEvent.VK_A, KeyEvent.VK_B, KeyEvent.VK_C, KeyEvent.VK_D, KeyEvent.VK_E, KeyEvent.VK_F, KeyEvent.VK_G,};

        for (int i = 0; i < keys.length; i++) {
            code.put(keys[i], values[i]);
        }

        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

}
