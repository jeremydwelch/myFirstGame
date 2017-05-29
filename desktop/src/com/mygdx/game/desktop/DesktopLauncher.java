package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyFirstGame;
import com.mygdx.game.config.Configuration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Configuration.WIDTH;
		config.height = Configuration.HEIGHT;
		config.title = Configuration.title;
		new LwjglApplication(new MyFirstGame(), config);
	}
}
