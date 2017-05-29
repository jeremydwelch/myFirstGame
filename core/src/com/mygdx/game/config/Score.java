package com.mygdx.game.config;

/**
 * Created by Jeremy on 5/26/2017.
 */

public class Score {

   public int numAsteroidsCleared;
   public int nextDifficulty;
   public Integer score;

   public Score(int numAsteroidsCleared, int nextDifficulty, Integer score) {
      this.numAsteroidsCleared = numAsteroidsCleared;
      this.nextDifficulty = nextDifficulty;
      this.score = score;
   }

   public void clearedAsteroid()
   {
      numAsteroidsCleared++;
      score++;
   }

   public boolean nextDifficulty()
   {
      if ( nextDifficulty < numAsteroidsCleared)
      {
         nextDifficulty += Configuration.NEXT_DIFFICULTY;
         return true;
      }
      return false;
   }

   public void reset()
   {
      score = 0;
      numAsteroidsCleared = 0;
   }

   public int getNumAsteroidsCleared() {
      return numAsteroidsCleared;
   }

   public int getNextDifficulty() {
      return nextDifficulty;
   }

   public Integer getScore() {
      return score;
   }
}
