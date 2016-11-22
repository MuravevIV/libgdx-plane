package com.ilyamur.libgdx;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ApplicationHud implements Disposable {

    @Autowired
    private SpriteBatch spriteBatch;

    private Stage stage;

    @PostConstruct
    public void postConstruct() {
        Viewport viewport = new FitViewport(1280, 720, new OrthographicCamera());
        stage = new Stage(viewport, spriteBatch);
        Table table = new Table();
        table.top();
        table.setFillParent(true);
        Label worldLabel = new Label("ENTITY:", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        table.add(worldLabel).expandX().padTop(10);
        table.row();
        Label levelLabel = new Label("red_dot", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        table.add(levelLabel).expandX();
        stage.addActor(table);

    }

    public Stage getStage() {
        return stage;
    }

    public void update(float dt) {
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
