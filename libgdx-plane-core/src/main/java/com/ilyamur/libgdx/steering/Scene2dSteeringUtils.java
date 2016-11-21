package com.ilyamur.libgdx.steering;

import com.badlogic.gdx.math.Vector2;

final class Scene2dSteeringUtils {

    private Scene2dSteeringUtils() {
    }

    static float vectorToAngle(Vector2 vector) {
        return (float) Math.atan2(-vector.x, vector.y);
    }

    static Vector2 angleToVector(Vector2 outVector, float angle) {
        outVector.x = -(float) Math.sin(angle);
        outVector.y = (float) Math.cos(angle);
        return outVector;
    }
}
