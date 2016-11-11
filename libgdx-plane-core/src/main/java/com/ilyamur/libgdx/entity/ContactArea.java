package com.ilyamur.libgdx.entity;

import com.badlogic.gdx.Gdx;
import com.google.common.eventbus.Subscribe;
import com.ilyamur.libgdx.InputEventBus;
import com.ilyamur.libgdx.event.AppEvent;
import com.ilyamur.libgdx.event.TouchDown;
import com.ilyamur.libgdx.screens.ApplicationScreen;
import com.ilyamur.libgdx.screens.ApplicationSpriteBatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ContactArea {

    private static final int HALF_SIZE = 4;

    @Autowired
    private ApplicationScreen screen;

    @Autowired
    private ApplicationSpriteBatch spriteBatch;

    @Autowired
    private InputEventBus inputEventBus;

    @PostConstruct
    public void postConstruct() {
        inputEventBus.register(this);
    }

    @Subscribe
    public void subscribe(AppEvent appEvent) {
        if (appEvent instanceof TouchDown) {
            TouchDown touchDown = (TouchDown) appEvent;
            RedDot redDot = new RedDot(touchDown.screenX - HALF_SIZE,
                    Gdx.graphics.getHeight() - touchDown.screenY - HALF_SIZE);

            screen.addEntity(redDot);
        }
    }
}
