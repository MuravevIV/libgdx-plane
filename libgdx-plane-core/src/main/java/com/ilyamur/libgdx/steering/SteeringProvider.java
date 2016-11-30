package com.ilyamur.libgdx.steering;

import com.badlogic.gdx.ai.steer.behaviors.Arrive;
import com.badlogic.gdx.math.Vector2;
import org.springframework.stereotype.Service;

@Service
public class SteeringProvider {

    public Arrive<Vector2> createSoftArrive(SteeringActor a, SteeringActor b) {
        return new Arrive<>(a, b)
                .setTimeToTarget(0.1f)
                .setArrivalTolerance(0.001f)
                .setDecelerationRadius(80);
    }
}
