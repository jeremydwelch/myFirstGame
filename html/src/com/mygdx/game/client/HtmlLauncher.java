package com.mygdx.game.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.mygdx.game.MyFirstGame;
import com.mygdx.game.config.Configuration;

public class HtmlLauncher extends GwtApplication {

        @Override
        public GwtApplicationConfiguration getConfig () {
                return new GwtApplicationConfiguration(Configuration.WIDTH, Configuration.HEIGHT);
        }

        @Override
        public ApplicationListener createApplicationListener () {
                return new MyFirstGame();
        }
}