package com.ilyamur.libgdx.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.google.common.collect.Lists;
import com.google.common.eventbus.EventBus;
import com.ilyamur.libgdx.entity.ContactArea;
import com.ilyamur.libgdx.entity.Dot;
import com.ilyamur.libgdx.entity.Entity;

import java.util.List;

public class AppScreen extends ScreenAdapter {

    private SpriteBatch spriteBatch;

    private Dot dot;
    private ContactArea contactArea;

    private final List<Entity> entities = Lists.newArrayList();

    public AppScreen(EventBus eventBus) {
        spriteBatch = new SpriteBatch();
        dot = new Dot(spriteBatch);
        entities.add(dot);
        contactArea = new ContactArea(this, spriteBatch);
        eventBus.register(contactArea);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        spriteBatch.begin();
        updateEntities(delta);
        spriteBatch.end();
    }

    private void updateEntities(float delta) {
        for (Entity entity : entities) {
            entity.update(delta);
        }
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }
}
