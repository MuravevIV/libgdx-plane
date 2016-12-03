package com.ilyamur.libgdx.entity.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ilyamur.libgdx.entity.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import javax.annotation.PostConstruct;

@Configurable
public class WhiteBox implements Entity {

    private Texture texture;
    private int x;
    private int y;

    @Autowired
    private SpriteBatch spriteBatch;

    public WhiteBox(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @PostConstruct
    public void postConstruct() {
        this.texture = new Texture(Gdx.files.internal("white-box.png"));
    }

    @Override
    public void update(float delta) {
        spriteBatch.draw(texture, x, y);
    }
}
