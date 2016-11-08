package com.ilyamur.libgdx.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Dot {

    private Texture texture;
    private int x;
    private int y;

    private SpriteBatch spriteBatch;

    public Dot(SpriteBatch spriteBatch) {
        this.spriteBatch = spriteBatch;
        texture = new Texture(Gdx.files.internal("dot.png"));
        x = Gdx.graphics.getWidth() / 2;
        y = Gdx.graphics.getHeight() / 2;
    }

    public void render() {
        spriteBatch.draw(texture, x, y);
    }

    public void up() {
        y += 2;
    }

    public void right() {
        x += 2;
    }

    public void down() {
        y -= 2;
    }

    public void left() {
        x -= 2;
    }
}
