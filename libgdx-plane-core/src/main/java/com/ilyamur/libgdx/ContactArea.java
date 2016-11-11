package com.ilyamur.libgdx;

import com.badlogic.gdx.Gdx;
import com.google.common.eventbus.Subscribe;
import com.ilyamur.libgdx.entity.impl.RedDot;
import com.ilyamur.libgdx.entity.factory.RedDotFactory;
import com.ilyamur.libgdx.entity.registry.EntityRegistry;
import com.ilyamur.libgdx.event.AppEvent;
import com.ilyamur.libgdx.event.impl.TouchDown;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ContactArea {

    private static final int HALF_SIZE = 4;

    @Autowired
    private EntityRegistry entityRegistry;

    @Autowired
    private InputEventBus inputEventBus;

    @Autowired
    private RedDotFactory redDotFactory;

    @PostConstruct
    public void postConstruct() {
        inputEventBus.register(this);
    }

    @Subscribe
    public void subscribe(AppEvent appEvent) {
        if (appEvent instanceof TouchDown) {
            TouchDown touchDown = (TouchDown) appEvent;

            RedDot redDot = redDotFactory.create(touchDown.screenX - HALF_SIZE,
                    Gdx.graphics.getHeight() - touchDown.screenY - HALF_SIZE);
            entityRegistry.add(redDot);

        }
    }
}
