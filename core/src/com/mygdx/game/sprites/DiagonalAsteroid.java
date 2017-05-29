package com.mygdx.game.sprites;

import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.config.Configuration;
import com.mygdx.game.states.GameStateManager;

/**
 * Created by Jeremy on 5/27/2017.
 */

public class DiagonalAsteroid extends Asteroid {

   public DiagonalAsteroid(int x, GameStateManager gameStateManager)
   {
      super(x, gameStateManager);
   }

   @Override
   public void update(float deltaTime)
   {
      if (position.y < -100)
      {
         gameStateManager.getScore().clearedAsteroid();
         this.startOver(Configuration.HEIGHT + 100);
      }
      velocity.scl(deltaTime);
      position.add(velocity.x, velocity.y, 0);
      this.updateBounds();

      velocity.scl(1/deltaTime);
   }

   @Override
   public void startOver(int x) {
      int randomX = random.nextInt(Configuration.WIDTH);
      position = new Vector3(randomX, x, 0);

      int fluctuation = gameStateManager.getDifficulty().getAsteroidFluctuation();
      int minVelocity = gameStateManager.getDifficulty().getMinimumAsteroidVelocity();
      int startingSpeed = -random.nextInt(fluctuation) + minVelocity;

      int velocityX = random.nextInt(fluctuation) + (minVelocity /4);

      if (randomX > (Configuration.WIDTH/2))
      {
         velocityX *= -1;
      }
      velocity = new Vector3(velocityX, startingSpeed, 0);
   }
}
