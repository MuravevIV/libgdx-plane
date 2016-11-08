package com.ilyamur.libgdx.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ilyamur.libgdx.LibgdxPlane;

public class DesktopLauncher {

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.useGL30 = true;
        config.width = 1280;
        config.height = 720;
        new LwjglApplication(new LibgdxPlane(), config);
    }
}
