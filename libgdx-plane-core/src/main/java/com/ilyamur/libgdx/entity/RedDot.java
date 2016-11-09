package com.ilyamur.libgdx.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class RedDot implements Entity {

    private Texture texture;
    private int x;
    private int y;

    private SpriteBatch spriteBatch;

    public RedDot(SpriteBatch spriteBatch, int x, int y) {
        this.spriteBatch = spriteBatch;
        this.texture = new Texture(Gdx.files.internal("red-dot.png"));
        this.x = x;
        this.y = y;
    }

    @Override
    public void update(float delta) {
        spriteBatch.draw(texture, x, y);
    }
}
