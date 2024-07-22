package me.kub0vv_.bindsystem.bind;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;

public abstract class Bind {
    private int keyCode = -1;

    public int getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(int keyCode) {
        this.keyCode = keyCode;
    }

    public void resetKey() {
        this.keyCode = -1;
    }

    public String getKeyText() {
        return keyCode == -1 ? "?" : NativeKeyEvent.getKeyText(keyCode);
    }

    public abstract void performAction();
}