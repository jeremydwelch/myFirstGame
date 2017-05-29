package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.config.Configuration;

/**
 * Created by Jeremy on 5/27/2017.
 */

public class PauseState extends State {

   private State previousState;
   private BitmapFont font;

   public PauseState(GameStateManager gameStateManager, State previousState) {
      super(gameStateManager);
      this.previousState = previousState;
      font = gameStateManager.createFont();
   }

   @Override
   public void handleInput() {
      if (Gdx.input.justTouched())
      {
         gameStateManager.pop();
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
      this.previousState.render(spriteBatch);
      String text = "Paused";
      float x = (Configuration.WIDTH - gameStateManager.getTextWidth(font, text))/ 2;
      font.draw(spriteBatch, text, x, 600);
   }

   @Override
   public void dispose() {
      font.dispose();
   }
}
