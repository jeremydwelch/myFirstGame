package com.mygdx.game.states;

import com.mygdx.game.config.Configuration;
import com.mygdx.game.sprites.StandardJellyfish;
import com.mygdx.game.sprites.VerticalAsteroid;

/**
 * Created by Jeremy on 5/27/2017.
 */

public class MediumPlayState extends PlayState {

   public MediumPlayState(GameStateManager gameStateManager)
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
      VerticalAsteroid verticalAsteroid = new VerticalAsteroid(x, gameStateManager);
      sprites.add(verticalAsteroid);
      asteroids.add(verticalAsteroid);
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
