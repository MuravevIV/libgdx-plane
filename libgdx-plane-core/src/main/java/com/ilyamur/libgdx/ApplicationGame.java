package com.ilyamur.libgdx;

import com.badlogic.gdx.Game;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationGame extends Game {

    @Override
    public void create() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerSingleton(ApplicationGame.class.getCanonicalName(), this);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(beanFactory);
        context.register(ApplicationConfiguration.class);
        context.refresh();
        context.start();
    }
}
