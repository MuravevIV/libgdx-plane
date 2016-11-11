package com.ilyamur.libgdx.event.impl;

import com.ilyamur.libgdx.event.AppEvent;

public class TouchDown implements AppEvent {

    public final int screenX;
    public final int screenY;
    public final int pointer;
    public final int button;

    public TouchDown(int screenX, int screenY, int pointer, int button) {
        this.screenX = screenX;
        this.screenY = screenY;
        this.pointer = pointer;
        this.button = button;
    }
}
