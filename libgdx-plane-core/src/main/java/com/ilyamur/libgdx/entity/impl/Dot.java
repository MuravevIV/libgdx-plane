package com.ilyamur.libgdx.entity.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Align;
import com.ilyamur.libgdx.entity.Entity;
import com.ilyamur.libgdx.entity.registry.EntityRegistry;
import com.ilyamur.libgdx.steering.SteeringActor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Dot implements Entity {

    private Texture texture;
    private float x;
    private float y;

    @Autowired
    private SpriteBatch spriteBatch;

    @Autowired
    private EntityRegistry entityRegistry;

    public SteeringActor steeringActor;

    @PostConstruct
    public void postConstruct() {
        texture = new Texture(Gdx.files.internal("dot.png"));
        x = Gdx.graphics.getWidth() / 2;
        y = Gdx.graphics.getHeight() / 2;
        setSteeringActor();
        entityRegistry.add(this);
    }

    private void setSteeringActor() {
        steeringActor = new SteeringActor(new TextureRegion(texture), false);
        steeringActor.setPosition(x, y, Align.center);
        steeringActor.setMaxLinearSpeed(200);
        steeringActor.setMaxLinearAcceleration(2000);
    }

    @Override
    public void update(float delta) {
        steeringActor.act(delta);
        Vector2 pos = steeringActor.getPosition();
        x = pos.x;
        y = pos.y;
        spriteBatch.draw(texture, x, y);
    }
}
