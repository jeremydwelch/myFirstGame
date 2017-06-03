package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Shape2D;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.config.Configuration;
import com.mygdx.game.states.GameStateManager;

import java.util.Random;

/**
 * Created by Jeremy on 5/27/2017.
 */

public abstract class Asteroid implements Sprite {

   protected Vector3 position;
   protected Vector3 velocity;
   protected Random random;
   protected Texture asteroid;
   protected static int asteroidWidth = 100;
   protected static int asteroidHeight = 100;
   protected static int asteroidRadius = 30;
   protected static int asteroidOffsetX = 50;
   protected static int asteroidOffsetY = 50;
   protected Circle bounds;
   protected com.badlogic.gdx.graphics.g2d.Sprite sprite;
   protected float currentAngle;
   protected GameStateManager gameStateManager;

   public Asteroid(int x, GameStateManager gameStateManager)
   {
      random = new Random();
      asteroid = new Texture(Configuration.asteroid);
      sprite = new com.badlogic.gdx.graphics.g2d.Sprite(asteroid);
      sprite.setSize(asteroidWidth, asteroidHeight);
      this.gameStateManager = gameStateManager;
      this.startOver(x);
      bounds = new Circle(position.x, position.y, asteroidRadius);

      float minX = -3.0f;
      float maxX = 3.0f;
      currentAngle = random.nextFloat() * (maxX - minX) + minX;
   }

   @Override
   public void update(float deltaTime) {

   }

   protected void updateBounds()
   {
      bounds.setPosition(position.x+asteroidOffsetX, position.y+asteroidOffsetY);
   }

   @Override
   public void dispose() {
      asteroid.dispose();
   }

   @Override
   public void render(SpriteBatch spriteBatch) {
      sprite.setPosition(position.x, position.y);
      sprite.setCenter(position.x+ asteroidOffsetX, position.y + asteroidOffsetY);
      sprite.setOriginCenter();
      sprite.rotate(currentAngle);
      sprite.draw(spriteBatch);

   }

   @Override
   public Vector3 getPosition() {
      return position;
   }

   @Override
   public Shape2D getBounds() {
      return bounds;
   }

   abstract public void startOver(int x);
}
