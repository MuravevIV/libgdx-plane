package com.ilyamur.libgdx.entity;

import org.springframework.stereotype.Service;

@Service
public class RedDotFactory {
    
    public RedDot create(int x, int y) {
        return new RedDot(x, y);
    }
}
