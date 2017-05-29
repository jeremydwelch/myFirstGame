package com.mygdx.game.sprites;

import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.config.Configuration;
import com.mygdx.game.config.Difficulty;
import com.mygdx.game.config.Score;
import com.mygdx.game.states.GameStateManager;

/**
 * Created by Jeremy on 5/27/2017.
 */

public class VerticalAsteroid extends Asteroid {

   public VerticalAsteroid(int x, GameStateManager gameStateManager)
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
      position.add(0, velocity.y, 0);
      this.updateBounds();

      velocity.scl(1/deltaTime);
   }


   @Override
   public void startOver(int x)
   {
      position = new Vector3(random.nextInt(Configuration.WIDTH), x, 0);
      int startingSpeed = -random.nextInt(gameStateManager.getDifficulty().getAsteroidFluctuation())
              + gameStateManager.getDifficulty().getMinimumAsteroidVelocity();
      velocity = new Vector3(0, startingSpeed, 0);
   }

}
