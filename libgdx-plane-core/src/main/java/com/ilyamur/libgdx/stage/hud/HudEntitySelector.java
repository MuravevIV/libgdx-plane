package com.ilyamur.libgdx.stage.hud;

import com.ilyamur.libgdx.entity.EntityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HudEntitySelector {

    @Autowired
    private Hud hud;

    private List<EntityType> playgroundEntityTypes;
    private int index;

    @PostConstruct
    public void postConstruct() {
        playgroundEntityTypes = Arrays.stream(EntityType.values())
                .filter(EntityType::isPlaygroundAvailable)
                .collect(Collectors.toList());
        index = 0;

        updateName();
    }

    public void next() {
        inc();
        updateName();
    }

    public EntityType getCurrent() {
        return playgroundEntityTypes.get(index);
    }

    private void inc() {
        if (index == playgroundEntityTypes.size() - 1) {
            index = 0;
        } else {
            index++;
        }
    }

    private void updateName() {
        String name = getCurrent().name();
        hud.update(name);
    }
}
