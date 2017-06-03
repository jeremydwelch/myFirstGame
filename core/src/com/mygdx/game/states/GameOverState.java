package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.config.Configuration;

/**
 * Created by Jeremy on 5/27/2017.
 */

public class GameOverState extends State {

//   private Texture background;
   private Texture gameover;
   private BitmapFont font;

   public GameOverState(GameStateManager gameStateManager) {
      super(gameStateManager);
//      background = new Texture(Configuration.background);
      gameover = new Texture(Configuration.gameOverButton);
      font = gameStateManager.createFont();
   }

   @Override
   public void handleInput() {

      if (Gdx.input.justTouched() )
      {
         gameStateManager.getScore().reset();
         gameStateManager.getDifficulty().reset();
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
//      spriteBatch.draw(background, 0,0, Configuration.WIDTH, Configuration.HEIGHT);
      spriteBatch.draw(gameover, 200, Configuration.HEIGHT/2, 100, 100);

      String text = "High Score: " + gameStateManager.getScore().getScore().toString();
      float x = ((Configuration.WIDTH) - gameStateManager.getTextWidth(font, text) )/ 2;

      font.draw(spriteBatch, text, x, 600);

   }

   @Override
   public void dispose() {

//      background.dispose();
      gameover.dispose();
      font.dispose();
   }
}
