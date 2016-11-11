package com.ilyamur.libgdx.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.google.common.collect.Lists;
import com.ilyamur.libgdx.entity.Dot;
import com.ilyamur.libgdx.entity.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class ApplicationScreen extends ScreenAdapter {

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    private Game game;

    @Autowired
    private SpriteBatch spriteBatch;

    @Autowired
    private Dot dot;

    private final List<Entity> entities = Lists.newArrayList();

    @PostConstruct
    public void postConstruct() {
        entities.add(dot);
        game.setScreen(this);
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
