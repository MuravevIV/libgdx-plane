package com.ilyamur.libgdx.reaction;

import com.google.common.eventbus.Subscribe;
import com.ilyamur.libgdx.input.event.AppEvent;
import com.ilyamur.libgdx.input.event.InputEventBus;
import com.ilyamur.libgdx.input.event.impl.KeyTyped;
import com.ilyamur.libgdx.stage.hud.HudEntitySelector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class CKeyTypedReaction {

    @Autowired
    private InputEventBus inputEventBus;

    @Autowired
    private HudEntitySelector hudEntitySelector;

    @PostConstruct
    public void postConstruct() {
        inputEventBus.register(this);
    }

    @Subscribe
    public void subscribe(AppEvent appEvent) {
        if (appEvent instanceof KeyTyped) {
            KeyTyped keyTyped = (KeyTyped) appEvent;

            if (keyTyped.character == 'c') {
                hudEntitySelector.next();
            }
        }
    }
}
