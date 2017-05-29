package com.mygdx.game.config;

/**
 * Created by Jeremy on 5/26/2017.
 */

public class Difficulty {

   public int numAsteroids;
   public int minimumAsteroidVelocity;
   public int asteroidFluctuation;

   public Difficulty(int numAsteroids, int minimumAsteroidVelocity, int asteroidFluctuation) {
      this.numAsteroids = numAsteroids;
      this.minimumAsteroidVelocity = minimumAsteroidVelocity;
      this.asteroidFluctuation = asteroidFluctuation;
   }

   public void increaseDifficulty()
   {
      numAsteroids++;
      minimumAsteroidVelocity -= 20;
      asteroidFluctuation += 20;
   }

   public void reset()
   {
      numAsteroids = Configuration.NUM_ASTEROIDS;
      minimumAsteroidVelocity = Configuration.MINIMUM_ASTEROID_VELOCITY;
      asteroidFluctuation = Configuration.ASTEROID_FLUCTUATION;
   }

   public int getNumAsteroids() {
      return numAsteroids;
   }

   public int getMinimumAsteroidVelocity() {
      return minimumAsteroidVelocity;
   }

   public int getAsteroidFluctuation() {
      return asteroidFluctuation;
   }
}
