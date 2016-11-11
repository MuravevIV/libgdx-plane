package com.ilyamur.libgdx.entity.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ilyamur.libgdx.entity.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class RedDot implements Entity {

    private Texture texture;
    private int x;
    private int y;

    @Autowired
    private SpriteBatch spriteBatch;

    public RedDot(int x, int y) {
        this.texture = new Texture(Gdx.files.internal("red-dot.png"));
        this.x = x;
        this.y = y;
    }

    @Override
    public void update(float delta) {
        spriteBatch.draw(texture, x, y);
    }
}
