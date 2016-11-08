package com.ilyamur.libgdx;

import com.badlogic.gdx.Game;
import com.ilyamur.libgdx.screens.SplashScreen;

public class LibgdxPlane extends Game {

    @Override
    public void create() {
        this.setScreen(new SplashScreen());
    }
}
