package com.ilyamur.libgdx.reaction;

import com.google.common.eventbus.Subscribe;
import com.ilyamur.libgdx.input.event.InputEventBus;
import com.ilyamur.libgdx.input.event.impl.KeyTyped;
import com.ilyamur.libgdx.stage.hud.HudEntitySelector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class SwitchActiveEntityReaction {

    @Autowired
    private InputEventBus inputEventBus;

    @Autowired
    private HudEntitySelector hudEntitySelector;

    @PostConstruct
    public void postConstruct() {
        inputEventBus.register(this);
    }

    @Subscribe
    public void subscribe(KeyTyped keyTyped) {
        if (keyTyped.character == 'c') {
            hudEntitySelector.next();
        }
    }
}
