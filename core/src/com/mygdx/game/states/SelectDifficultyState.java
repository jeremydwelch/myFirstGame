package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.config.Configuration;

/**
 * Created by Jeremy on 5/27/2017.
 */

public class SelectDifficultyState extends State {

   private Texture background;
   private BitmapFont easy;
   private BitmapFont medium;
   private BitmapFont hard;
   private float easyX;
   private float mediumX;
   private float hardX;
   private String easyText;
   private String mediumText;
   private String hardText;

   public SelectDifficultyState(GameStateManager gameStateManager)
   {
      super(gameStateManager);
      background = new Texture(Configuration.background);
      easy = gameStateManager.createFont(35);
      medium = gameStateManager.createFont(35);
      hard = gameStateManager.createFont(35);

      easyText = "Easy";
      mediumText = "Medium";
      hardText = "Hard";
      easyX = (Configuration.WIDTH - gameStateManager.getTextWidth(easy, easyText))/ 2;
      mediumX = (Configuration.WIDTH - gameStateManager.getTextWidth(medium, mediumText))/ 2;
      hardX = (Configuration.WIDTH - gameStateManager.getTextWidth(hard, hardText))/ 2;

   }

   @Override
   public void handleInput()
   {
      if ( Gdx.input.justTouched() )
      {
         if (Gdx.input.getY() > (Configuration.HEIGHT *0.6f))
         {
//               System.out.println("HARD");
            gameStateManager.set(new HardPlayState(gameStateManager));
         }
         else if (Gdx.input.getY() > (Configuration.HEIGHT *0.4f))
         {
//               System.out.println("MEDIUM");
            gameStateManager.set(new MediumPlayState(gameStateManager));
         }
         else
         {
//               System.out.println("EASY");
            gameStateManager.set(new EasyPlayState(gameStateManager));
         }
         this.dispose();
      }
   }

   @Override
   public void update(float deltaTime) {
      this.handleInput();
   }

   @Override
   public void render(SpriteBatch spriteBatch) {
      spriteBatch.draw(background, 0,0, Configuration.WIDTH, Configuration.HEIGHT);

      easy.draw(spriteBatch, easyText, easyX, Configuration.HEIGHT *0.7f);
      medium.draw(spriteBatch, mediumText, mediumX, Configuration.HEIGHT *0.5f);
      hard.draw(spriteBatch, hardText, hardX, Configuration.HEIGHT *0.3f);

   }

   @Override
   public void dispose() {
      background.dispose();
      easy.dispose();
      medium.dispose();
   }
}
