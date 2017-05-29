package com.mygdx.game.states;

import com.mygdx.game.config.Configuration;
import com.mygdx.game.sprites.DiagonalAsteroid;
import com.mygdx.game.sprites.StandardJellyfish;

/**
 * Created by Jeremy on 5/27/2017.
 */

public class HardPlayState extends PlayState {

   public HardPlayState(GameStateManager gameStateManager)
   {
      super(gameStateManager);
      jellyfish = new StandardJellyfish(Configuration.WIDTH/2, 200);
      sprites.add(jellyfish);

      int offscreen = 100;
      for (int i = 0; i < gameStateManager.getDifficulty().getNumAsteroids(); i++)
      {
         this.addAsteroid(Configuration.HEIGHT + offscreen);
         offscreen += 200;
      }

   }

   @Override
   public void handleInput() {

   }

   @Override
   public void addAsteroid(int x) {
      DiagonalAsteroid asteroid = new DiagonalAsteroid(x, gameStateManager);
      sprites.add(asteroid);
      asteroids.add(asteroid);
   }

   @Override
   public void postUpdate()
   {
      if (gameStateManager.getScore().nextDifficulty())
      {
         this.addAsteroid(Configuration.HEIGHT + 100);
      }
   }
}
