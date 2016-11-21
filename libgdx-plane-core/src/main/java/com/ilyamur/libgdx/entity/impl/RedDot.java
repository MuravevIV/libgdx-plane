package com.ilyamur.libgdx.entity.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ai.steer.behaviors.Wander;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Align;
import com.ilyamur.libgdx.entity.Entity;
import com.ilyamur.libgdx.steering.SteeringActor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import javax.annotation.PostConstruct;

@Configurable
public class RedDot implements Entity {

    private Texture texture;
    private int x;
    private int y;

    @Autowired
    private SpriteBatch spriteBatch;

    public SteeringActor steeringActor;

    public RedDot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @PostConstruct
    public void postConstruct() {
        this.texture = new Texture(Gdx.files.internal("red-dot.png"));
        setSteeringActor();
    }

    private void setSteeringActor() {
        steeringActor = new SteeringActor(new TextureRegion(texture), false);
        steeringActor.setPosition(x, y, Align.center);
    }

    @Override
    public void update(float delta) {
        steeringActor.act(delta);
        Vector2 pos = steeringActor.getPosition();
        spriteBatch.draw(texture, pos.x, pos.y);
    }
}
