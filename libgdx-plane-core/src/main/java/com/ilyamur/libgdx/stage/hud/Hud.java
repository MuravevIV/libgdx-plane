package com.ilyamur.libgdx.stage.hud;

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
import com.ilyamur.libgdx.Constants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class Hud implements Disposable {

    @Autowired
    private SpriteBatch spriteBatch;

    private Stage stage;
    private Label.LabelStyle labelStyle = new Label.LabelStyle(new BitmapFont(), Color.WHITE);

    @PostConstruct
    public void postConstruct() {
        Viewport viewport = new FitViewport(Constants.World.WORLD_WIDTH, Constants.World.WORLD_HEIGHT,
                new OrthographicCamera());

        stage = new Stage(viewport, spriteBatch);
        update(StringUtils.EMPTY);
    }

    public void update(String s) {
        stage.clear();
        Table table = createTable(s);
        stage.addActor(table);
    }

    private Table createTable(String entityName) {
        Table table = new Table();
        table.top();
        table.setFillParent(true);
        Label entityTitleLabel = new Label("ENTITY:", labelStyle);
        table.add(entityTitleLabel).expandX().padTop(10);
        table.row();
        Label entityNameLabel = new Label(entityName, labelStyle);
        table.add(entityNameLabel).expandX();
        return table;
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
