package com.ilyamur.libgdx.input.event.impl;

import com.ilyamur.libgdx.input.event.AppEvent;

public class KeyTyped implements AppEvent {

    public final char character;

    public KeyTyped(char character) {
        this.character = character;
    }
}
