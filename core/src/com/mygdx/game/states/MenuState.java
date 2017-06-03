package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.config.Configuration;

/**
 * Created by Jeremy on 5/21/2017.
 */

public class MenuState extends State {

    private Texture playButton;
    private BitmapFont font;

    public MenuState(GameStateManager gameStateManager) {
        super(gameStateManager);
        playButton = new Texture(Configuration.playButton);
        font = gameStateManager.createFont(38);
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched())
        {
            gameStateManager.set(new SelectDifficultyState(gameStateManager));
            this.dispose();
        }
    }

    @Override
    public void update(float deltaTime) {
        this.handleInput();
    }

    @Override
    public void render(SpriteBatch spriteBatch)
    {
        // Always have to begin before rendering
        float middleWidth = (Configuration.WIDTH / 2) - (playButton.getWidth() / 2);
        float middleHeight = Configuration.HEIGHT / 4;

        spriteBatch.draw(playButton, middleWidth, middleHeight);

        float x = (Configuration.WIDTH - gameStateManager.getTextWidth(font, Configuration.title))/ 2;
        font.draw(spriteBatch, Configuration.title, x, Configuration.HEIGHT * 0.65f);
    }

    @Override
    public void dispose() {
        playButton.dispose();
    }
}
