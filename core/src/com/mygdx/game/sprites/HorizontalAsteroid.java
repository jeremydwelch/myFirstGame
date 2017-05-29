package com.mygdx.game.sprites;

import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.config.Configuration;
import com.mygdx.game.states.GameStateManager;

/**
 * Created by Jeremy on 5/26/2017.
 */

public class HorizontalAsteroid extends Asteroid {

   public HorizontalAsteroid(int x, GameStateManager gameStateManager)
   {
      super(x, gameStateManager);
   }

   @Override
   public void update(float deltaTime)
   {
      if (position.x < -100)
      {
         gameStateManager.getScore().clearedAsteroid();
         this.startOver(Configuration.WIDTH + 100);
      }
      velocity.scl(deltaTime);
      position.add(velocity.x, 0, 0);
      this.updateBounds();

      velocity.scl(1/deltaTime);
   }

   @Override
   public void startOver(int x)
   {
      position = new Vector3(x, random.nextInt(Configuration.HEIGHT), 0);
      int startingSpeed = -random.nextInt(gameStateManager.getDifficulty().getAsteroidFluctuation())
              + gameStateManager.getDifficulty().getMinimumAsteroidVelocity();
      velocity = new Vector3(startingSpeed, 0, 0);
   }
}
