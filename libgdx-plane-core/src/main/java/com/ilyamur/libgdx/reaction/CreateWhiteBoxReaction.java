package com.ilyamur.libgdx.reaction;

import com.badlogic.gdx.Gdx;
import com.google.common.eventbus.Subscribe;
import com.ilyamur.libgdx.entity.impl.WhiteBox;
import com.ilyamur.libgdx.entity.registry.EntityRegistry;
import com.ilyamur.libgdx.input.event.AppEvent;
import com.ilyamur.libgdx.input.event.InputEventBus;
import com.ilyamur.libgdx.input.event.impl.TouchDown;
import com.ilyamur.libgdx.stage.hud.HudEntitySelector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class CreateWhiteBoxReaction {

    @Autowired
    private EntityRegistry entityRegistry;

    @Autowired
    private InputEventBus inputEventBus;

    @Autowired
    private HudEntitySelector hudEntitySelector;

    @PostConstruct
    public void postConstruct() {
        inputEventBus.register(this);
    }

    @Subscribe
    public void subscribe(AppEvent appEvent) {
        if (appEvent instanceof TouchDown) {
            TouchDown touchDown = (TouchDown) appEvent;
            switch (hudEntitySelector.getCurrent()) {
                case WHITE_BOX:
                    WhiteBox whiteBox = new WhiteBox(touchDown.screenX - 32,
                            Gdx.graphics.getHeight() - touchDown.screenY - 32);
                    entityRegistry.add(whiteBox);
                    break;
            }
        }
    }
}
