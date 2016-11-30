package com.ilyamur.libgdx.entity;

public enum EntityType {

    DOT(false),
    RED_DOT(true),
    WHITE_BOX(true);

    private final boolean playgroundAvailable;

    EntityType(boolean playgroundAvailable) {
        this.playgroundAvailable = playgroundAvailable;
    }

    public boolean isPlaygroundAvailable() {
        return playgroundAvailable;
    }
}
