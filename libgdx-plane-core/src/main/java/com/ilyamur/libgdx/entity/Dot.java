package com.ilyamur.libgdx.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.ilyamur.libgdx.screens.ApplicationSpriteBatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Dot implements Entity {

    public static final int VERT_SPEED_IN_SEC = 200;
    private Texture texture;
    private float x;
    private float y;

    @Autowired
    private ApplicationSpriteBatch applicationSpriteBatch;

    @PostConstruct
    public void postConstruct() {
        texture = new Texture(Gdx.files.internal("dot.png"));
        x = Gdx.graphics.getWidth() / 2;
        y = Gdx.graphics.getHeight() / 2;
    }

    @Override
    public void update(float delta) {
        applicationSpriteBatch.draw(texture, x, y);
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

    public void up(float delta) {
        y += VERT_SPEED_IN_SEC * delta;
    }

    public void right(float delta) {
        x += VERT_SPEED_IN_SEC * delta;
    }

    public void down(float delta) {
        y -= VERT_SPEED_IN_SEC * delta;
    }

    public void left(float delta) {
        x -= VERT_SPEED_IN_SEC * delta;
    }
}
