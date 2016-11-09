package com.ilyamur.libgdx.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.google.common.eventbus.Subscribe;
import com.ilyamur.libgdx.event.AppEvent;
import com.ilyamur.libgdx.event.TouchDown;
import com.ilyamur.libgdx.screens.AppScreen;

public class ContactArea {

    private static final int HALF_SIZE = 4;

    private final AppScreen appScreen;
    private final SpriteBatch spriteBatch;

    public ContactArea(AppScreen appScreen, SpriteBatch spriteBatch) {
        this.appScreen = appScreen;
        this.spriteBatch = spriteBatch;
    }

    @Subscribe
    public void subscribe(AppEvent appEvent) {
        if (appEvent instanceof TouchDown) {
            TouchDown touchDown = (TouchDown) appEvent;
            RedDot redDot = new RedDot(spriteBatch, touchDown.screenX - HALF_SIZE,
                    Gdx.graphics.getHeight() - touchDown.screenY - HALF_SIZE);

            appScreen.addEntity(redDot);
        }
    }
}
