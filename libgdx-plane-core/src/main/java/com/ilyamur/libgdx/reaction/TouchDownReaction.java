package com.ilyamur.libgdx.reaction;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ai.steer.behaviors.Arrive;
import com.badlogic.gdx.math.Vector2;
import com.google.common.eventbus.Subscribe;
import com.ilyamur.libgdx.entity.factory.RedDotFactory;
import com.ilyamur.libgdx.entity.impl.Dot;
import com.ilyamur.libgdx.entity.impl.RedDot;
import com.ilyamur.libgdx.entity.registry.EntityRegistry;
import com.ilyamur.libgdx.input.event.AppEvent;
import com.ilyamur.libgdx.input.event.InputEventBus;
import com.ilyamur.libgdx.input.event.impl.TouchDown;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class TouchDownReaction {

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

    @Autowired
    private Dot dot;

    private RedDot currentRedDot;

    @Subscribe
    public void subscribe(AppEvent appEvent) {
        if (appEvent instanceof TouchDown) {
            TouchDown touchDown = (TouchDown) appEvent;

            if (currentRedDot != null) {
                dot.steeringActor.setSteeringBehavior(null);
                entityRegistry.remove(currentRedDot);
            }

            currentRedDot = redDotFactory.create(touchDown.screenX - HALF_SIZE,
                    Gdx.graphics.getHeight() - touchDown.screenY - HALF_SIZE);
            entityRegistry.add(currentRedDot);


            final Arrive<Vector2> arrive = new Arrive<>(dot.steeringActor, currentRedDot.steeringActor)
                    .setTimeToTarget(0.1f)
                    .setArrivalTolerance(0.001f)
                    .setDecelerationRadius(80);
            dot.steeringActor.setSteeringBehavior(arrive);
        }
    }
}
