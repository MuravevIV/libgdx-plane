package com.ilyamur.libgdx;

import com.badlogic.gdx.Gdx;
import com.ilyamur.libgdx.event.impl.TouchDown;
import com.ilyamur.libgdx.stage.hud.HudEntityCarouselSelector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class AppInputProcessor implements InputProcessorAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(AppInputProcessor.class);

    @Autowired
    private InputEventBus inputEventBus;

    @Autowired
    private HudEntityCarouselSelector hudEntityCarouselSelector;

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
        if (character == 'c') {
            hudEntityCarouselSelector.next();
        }
        return true;
    }
}
