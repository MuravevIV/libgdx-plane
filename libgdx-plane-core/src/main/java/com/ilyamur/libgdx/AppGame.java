package com.ilyamur.libgdx;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.google.common.eventbus.EventBus;
import com.ilyamur.libgdx.screens.AppScreen;

public class AppGame extends Game {

    @Override
    public void create() {
        EventBus eventBus = new EventBus();
        AppInputProcessor inputProcessor = new AppInputProcessor(eventBus);
        Gdx.input.setInputProcessor(inputProcessor);
        this.setScreen(new AppScreen(eventBus));
    }
}
