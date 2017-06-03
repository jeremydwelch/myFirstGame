package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.config.Configuration;
import com.mygdx.game.sprites.HorizontalAsteroid;
import com.mygdx.game.sprites.SimpleJellyfish;

/**
 * Created by Jeremy on 5/21/2017.
 */

public class EasyPlayState extends PlayState {

   public EasyPlayState(GameStateManager gameStateManager) {
      super(gameStateManager);

      jellyfish = new SimpleJellyfish(60, 500);
      sprites.add(jellyfish);

      int offScreen = 100;
      for (int i = 0; i < gameStateManager.getDifficulty().getNumAsteroids(); i++)
      {
         this.addAsteroid(Configuration.WIDTH + offScreen);
         offScreen += 200;
      }
   }

   @Override
   public void addAsteroid(int x)
   {
      HorizontalAsteroid horizontalAsteroid = new HorizontalAsteroid(x, gameStateManager);
      sprites.add(horizontalAsteroid);
      asteroids.add(horizontalAsteroid);
   }

   @Override
   public void handleInput() {
      if (Gdx.input.justTouched())
      {
         this.jellyfish.jump();
      }
   }

   @Override
   public void postUpdate()
   {
      if (gameStateManager.getScore().nextDifficulty())
      {
         this.addAsteroid(Configuration.WIDTH + 100);
      }
   }



}
