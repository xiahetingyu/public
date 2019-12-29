package com.xiahe.tools;

import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinUser;
import com.xiahe.output.Support;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;

public class WindowsTools {
    public static WinDef.HWND solo;

    //锁定窗口
    public static WinDef.HWND find() {
        solo = CLibrary.instance.FindWindowA("Puzzles", "Solo");
        if (solo == null) throw new RuntimeException("没有找到数独程序");
        return solo;
    }

    //展示窗口到前台
    public static void show() {
        CLibrary.instance.ShowWindow(solo, WinUser.SW_RESTORE);
        CLibrary.instance.SetForegroundWindow(solo);
    }

    //重设大小
    public static void reSize() throws Exception {
        CLibrary.instance.MoveWindow(solo, 0, 0, 685, 727);
        Robot robot = new Robot();

        robot.mouseMove(680, 722);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    //截取窗口
    public static BufferedImage screenCapture() throws Exception {
        WinDef.RECT rect = new WinDef.RECT();
        CLibrary.instance.GetWindowRect(solo, rect);
        Rectangle rectangle = new Rectangle(rect.right, rect.bottom);
        return Support.robot.createScreenCapture(rectangle);
    }

    static {
        System.setProperty("jna.protected", "true");
        System.setProperty("jna.encoding", "GBK");
    }

}
