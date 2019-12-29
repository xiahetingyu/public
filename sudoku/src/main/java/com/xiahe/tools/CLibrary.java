package com.xiahe.tools;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.win32.StdCallLibrary;

public interface CLibrary extends StdCallLibrary {

    CLibrary instance = Native.load(CLibrary.class);

    WinDef.HWND FindWindowA(String clazz, String caption);//查找窗口

    void ShowWindow(WinDef.HWND hwnd, int message);//显示窗口

    void SetForegroundWindow(WinDef.HWND hwnd);//获取焦点

    void MoveWindow(WinDef.HWND hwnd, int x, int y, int Width, int Height);//改变窗口位置和大小

    void GetWindowRect(WinDef.HWND hwnd, WinDef.RECT rect);//获取窗口大小

}