package com.ilyamur.libgdx;

import com.badlogic.gdx.Game;
import com.ilyamur.libgdx.screens.LibgdxPlaneScreen;

public class LibgdxPlane extends Game {

    @Override
    public void create() {
        this.setScreen(new LibgdxPlaneScreen());
    }
}
