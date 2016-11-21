package com.ilyamur.libgdx.steering;

import com.badlogic.gdx.ai.steer.Steerable;
import com.badlogic.gdx.ai.steer.SteeringAcceleration;
import com.badlogic.gdx.ai.steer.SteeringBehavior;
import com.badlogic.gdx.ai.utils.Location;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Align;

public class SteeringActor extends Actor implements Steerable<Vector2> {

    private static final SteeringAcceleration<Vector2> steeringOutput = new SteeringAcceleration<>(new Vector2());

    private TextureRegion region;

    private Vector2 position;
    private Vector2 linearVelocity;
    private float angularVelocity;
    private float boundingRadius;
    private boolean tagged;

    private float maxLinearSpeed = 100;
    private float maxLinearAcceleration = 200;
    private float maxAngularSpeed = 5;
    private float maxAngularAcceleration = 10;

    private boolean independentFacing;

    private SteeringBehavior<Vector2> steeringBehavior;

    public SteeringActor(TextureRegion region, boolean independentFacing) {
        this.independentFacing = independentFacing;
        this.region = region;
        this.position = new Vector2();
        this.linearVelocity = new Vector2();
        this.setBounds(0, 0, region.getRegionWidth(), region.getRegionHeight());
        this.boundingRadius = (region.getRegionWidth() + region.getRegionHeight()) / 4f;
        this.setOrigin(region.getRegionWidth() * .5f, region.getRegionHeight() * .5f);
    }

    @Override
    public Vector2 getPosition() {
        return position;
    }

    @Override
    public float getOrientation() {
        return getRotation() * MathUtils.degreesToRadians;
    }

    @Override
    public void setOrientation(float orientation) {
        setRotation(orientation * MathUtils.radiansToDegrees);
    }

    @Override
    public Vector2 getLinearVelocity() {
        return linearVelocity;
    }

    @Override
    public float getAngularVelocity() {
        return angularVelocity;
    }

    @Override
    public float getBoundingRadius() {
        return boundingRadius;
    }

    @Override
    public boolean isTagged() {
        return tagged;
    }

    @Override
    public void setTagged(boolean tagged) {
        this.tagged = tagged;
    }

    @Override
    public Location<Vector2> newLocation() {
        return new Scene2dLocation();
    }

    @Override
    public float vectorToAngle(Vector2 vector) {
        return Scene2dSteeringUtils.vectorToAngle(vector);
    }

    @Override
    public Vector2 angleToVector(Vector2 outVector, float angle) {
        return Scene2dSteeringUtils.angleToVector(outVector, angle);
    }

    @Override
    public float getMaxLinearSpeed() {
        return maxLinearSpeed;
    }

    @Override
    public void setMaxLinearSpeed(float maxLinearSpeed) {
        this.maxLinearSpeed = maxLinearSpeed;
    }

    @Override
    public float getMaxLinearAcceleration() {
        return maxLinearAcceleration;
    }

    @Override
    public void setMaxLinearAcceleration(float maxLinearAcceleration) {
        this.maxLinearAcceleration = maxLinearAcceleration;
    }

    @Override
    public float getMaxAngularSpeed() {
        return maxAngularSpeed;
    }

    @Override
    public void setMaxAngularSpeed(float maxAngularSpeed) {
        this.maxAngularSpeed = maxAngularSpeed;
    }

    @Override
    public float getMaxAngularAcceleration() {
        return maxAngularAcceleration;
    }

    @Override
    public void setMaxAngularAcceleration(float maxAngularAcceleration) {
        this.maxAngularAcceleration = maxAngularAcceleration;
    }

    @Override
    public float getZeroLinearSpeedThreshold() {
        return 0.001f;
    }

    @Override
    public void setZeroLinearSpeedThreshold(float value) {
        throw new UnsupportedOperationException();
    }

    public void setSteeringBehavior(SteeringBehavior<Vector2> steeringBehavior) {
        this.steeringBehavior = steeringBehavior;
    }

    @Override
    public void act(float delta) {
        position.set(getX(Align.center), getY(Align.center));
        if (steeringBehavior != null) {
            steeringBehavior.calculateSteering(steeringOutput);
            applySteering(steeringOutput, delta);
            setPosition(position.x, position.y, Align.center);
        }
        super.act(delta);
    }

    private void applySteering(SteeringAcceleration<Vector2> steering, float time) {
        position.mulAdd(linearVelocity, time);
        linearVelocity.mulAdd(steering.linear, time).limit(getMaxLinearSpeed());
        if (independentFacing) {
            setRotation(getRotation() + (angularVelocity * time) * MathUtils.radiansToDegrees);
            angularVelocity += steering.angular * time;
        } else if (!linearVelocity.isZero(getZeroLinearSpeedThreshold())) {
            float newOrientation = vectorToAngle(linearVelocity);
            angularVelocity = (newOrientation - getRotation() * MathUtils.degreesToRadians) * time;
            setRotation(newOrientation * MathUtils.radiansToDegrees);
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Color color = getColor();
        batch.setColor(color.r, color.g, color.b, parentAlpha);
        batch.draw(region, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(),
                getRotation());
    }

}
