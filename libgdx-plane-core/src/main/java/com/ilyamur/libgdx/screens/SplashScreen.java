package com.ilyamur.libgdx.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ilyamur.libgdx.entity.Dot;

public class SplashScreen extends ScreenAdapter {

    private SpriteBatch spriteBatch;

    private Dot dot;

    @Override
    public void show() {
        spriteBatch = new SpriteBatch();
        dot = new Dot(spriteBatch);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        spriteBatch.begin();
        update(delta);
        spriteBatch.end();
    }

    private void update(float delta) {
        handleInput(delta);
        dot.render();
    }

    private void handleInput(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            dot.up();
        }
    }
}
