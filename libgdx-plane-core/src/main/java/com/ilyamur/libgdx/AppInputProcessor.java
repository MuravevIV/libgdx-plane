package com.ilyamur.libgdx;

import com.badlogic.gdx.Gdx;
import com.ilyamur.libgdx.event.TouchDown;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class AppInputProcessor implements InputProcessorAdapter {

    @Autowired
    private InputEventBus inputEventBus;

    @PostConstruct
    public void postConstruct() {
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        inputEventBus.post(new TouchDown(screenX, screenY, pointer, button));
        return true;
    }
}
