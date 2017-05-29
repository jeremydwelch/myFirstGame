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
      int randomX = random.nextInt(Configuration.WIDTH + 200) - 100;
      int bottomX = random.nextInt(Configuration.WIDTH + 200) - 100;
      // Starting position off screen
      position = new Vector3(randomX, x, 0);

      // Calculate the starting absolute speed
      int fluctuation = gameStateManager.getDifficulty().getAsteroidFluctuation();
      int minVelocity = gameStateManager.getDifficulty().getMinimumAsteroidVelocity();
      int startingSpeed = -random.nextInt(fluctuation) + minVelocity;

      // Calculate the x and y velocities based on random starting positions;
      double tan = Math.atan2(Math.abs(randomX - bottomX), x);
      if (randomX < bottomX )
      {
         tan *= -1;
      }

      double velX = startingSpeed * Math.sin(tan);
      double velY = startingSpeed * Math.cos(tan);

//      System.out.println("Starting speed: " + startingSpeed + " x: " + x);
//      System.out.println("RandomX: " + randomX + ", BottomX: " + bottomX);
//      System.out.println("Tan: " + tan + ", Vel(x,y)= (" + velX + ", " + velY + ")");

      velocity = new Vector3((float)velX, (float)velY, 0);
   }
}
