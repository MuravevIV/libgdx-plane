package com.ilyamur.libgdx.input;

import com.badlogic.gdx.Gdx;
import com.ilyamur.libgdx.input.event.InputEventBus;
import com.ilyamur.libgdx.input.event.impl.KeyTyped;
import com.ilyamur.libgdx.input.event.impl.TouchDown;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ApplicationInputProcessor implements InputProcessorAdapter {

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

    @Override
    public boolean keyTyped(char character) {
        inputEventBus.post(new KeyTyped(character));
        return true;
    }
}
