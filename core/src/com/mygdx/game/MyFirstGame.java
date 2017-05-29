package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.states.GameStateManager;
import com.mygdx.game.states.MenuState;
import com.mygdx.game.states.State;

import java.util.Stack;

public class MyFirstGame extends ApplicationAdapter {

	public static final String TITLE = "MyFirstGame";

	private GameStateManager gameStateManager;
	private SpriteBatch spriteBatch;

	@Override
	public void create () {
		spriteBatch = new SpriteBatch();
		gameStateManager = new GameStateManager(new Stack<State>(), new OrthographicCamera(), new Vector3());
		Gdx.gl.glClearColor(1, 0, 0, 1);
		gameStateManager.push(new MenuState(gameStateManager));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		gameStateManager.update(Gdx.graphics.getDeltaTime());
		gameStateManager.render(spriteBatch);

//		spriteBatch.begin();
//		spriteBatch.draw(img, 0, 0);
//		spriteBatch.end();
	}
	
	@Override
	public void dispose () {
		spriteBatch.dispose();
	}
}
