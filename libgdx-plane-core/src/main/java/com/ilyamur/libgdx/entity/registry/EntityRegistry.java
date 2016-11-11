package com.ilyamur.libgdx.entity.registry;

import com.google.common.collect.Lists;
import com.ilyamur.libgdx.entity.Entity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntityRegistry {

    private final List<Entity> entities = Lists.newArrayList();

    public void add(Entity entity) {
        entities.add(entity);
    }

    public void update(float delta) {
        for (Entity entity : entities) {
            entity.update(delta);
        }
    }
}
