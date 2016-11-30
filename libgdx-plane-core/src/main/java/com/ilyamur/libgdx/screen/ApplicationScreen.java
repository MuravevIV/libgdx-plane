package com.ilyamur.libgdx.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ilyamur.libgdx.entity.registry.EntityRegistry;
import com.ilyamur.libgdx.stage.hud.Hud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ApplicationScreen extends ScreenAdapter {

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    private Game game;

    @Autowired
    private SpriteBatch spriteBatch;

    @Autowired
    private EntityRegistry entityRegistry;

    @Autowired
    private Hud hud;

    @PostConstruct
    public void postConstruct() {
        game.setScreen(this);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        spriteBatch.begin();
        hud.update(delta);
        entityRegistry.update(delta);
        spriteBatch.end();

        spriteBatch.setProjectionMatrix(hud.getStage().getCamera().combined);
        hud.getStage().draw();
    }
}
