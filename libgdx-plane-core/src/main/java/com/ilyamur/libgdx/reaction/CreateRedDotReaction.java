package com.ilyamur.libgdx.reaction;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ai.steer.behaviors.Arrive;
import com.badlogic.gdx.math.Vector2;
import com.google.common.eventbus.Subscribe;
import com.ilyamur.libgdx.entity.impl.Dot;
import com.ilyamur.libgdx.entity.impl.RedDot;
import com.ilyamur.libgdx.entity.registry.EntityRegistry;
import com.ilyamur.libgdx.input.event.InputEventBus;
import com.ilyamur.libgdx.input.event.impl.TouchDown;
import com.ilyamur.libgdx.stage.hud.HudEntitySelector;
import com.ilyamur.libgdx.steering.SteeringProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class CreateRedDotReaction {

    @Autowired
    private EntityRegistry entityRegistry;

    @Autowired
    private InputEventBus inputEventBus;

    @Autowired
    private HudEntitySelector hudEntitySelector;

    @Autowired
    private SteeringProvider steeringProvider;

    @Autowired
    private Dot dot;

    private RedDot currentRedDot;

    @PostConstruct
    public void postConstruct() {
        inputEventBus.register(this);
    }

    @Subscribe
    public void subscribe(TouchDown touchDown) {
        switch (hudEntitySelector.getCurrent()) {
            case RED_DOT:
                if (currentRedDot != null) {
                    dot.steeringActor.setSteeringBehavior(null);
                    entityRegistry.remove(currentRedDot);
                }
                currentRedDot = new RedDot(touchDown.screenX - 4, Gdx.graphics.getHeight() - touchDown.screenY - 4);
                entityRegistry.add(currentRedDot);
                Arrive<Vector2> arrive = steeringProvider.createSoftArrive(dot.steeringActor,
                        currentRedDot.steeringActor);
                dot.steeringActor.setSteeringBehavior(arrive);
                break;
        }
    }
}
