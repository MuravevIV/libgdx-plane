package com.ilyamur.libgdx;

import com.google.common.eventbus.EventBus;
import com.ilyamur.libgdx.event.TouchDown;

public class AppInputProcessor implements InputProcessorAdapter {

    private EventBus eventBus;

    public AppInputProcessor(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        eventBus.post(new TouchDown(screenX, screenY, pointer, button));
        return true;
    }
}
