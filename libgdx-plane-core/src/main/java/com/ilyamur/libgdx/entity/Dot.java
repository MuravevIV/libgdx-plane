package com.ilyamur.libgdx.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ilyamur.libgdx.screens.ApplicationScreen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Dot implements Entity {

    private static final int VERT_SPEED_IN_SEC = 200;

    private Texture texture;
    private float x;
    private float y;

    @Autowired
    private SpriteBatch spriteBatch;

    @Autowired
    private ApplicationScreen screen;

    @PostConstruct
    public void postConstruct() {
        texture = new Texture(Gdx.files.internal("dot.png"));
        x = Gdx.graphics.getWidth() / 2;
        y = Gdx.graphics.getHeight() / 2;
        screen.addEntity(this);
    }

    @Override
    public void update(float delta) {
        spriteBatch.draw(texture, x, y);
        handleInput(delta);
    }

    private void handleInput(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            up(delta);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            right(delta);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            down(delta);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            left(delta);
        }
    }

    private void up(float delta) {
        y += VERT_SPEED_IN_SEC * delta;
    }

    private void right(float delta) {
        x += VERT_SPEED_IN_SEC * delta;
    }

    private void down(float delta) {
        y -= VERT_SPEED_IN_SEC * delta;
    }

    private void left(float delta) {
        x -= VERT_SPEED_IN_SEC * delta;
    }
}
