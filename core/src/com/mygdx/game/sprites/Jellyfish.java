package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Shape2D;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.config.Configuration;

/**
 * Created by Jeremy on 5/27/2017.
 */

public abstract class Jellyfish implements Sprite {

   protected Vector3 position;
   protected Vector3 velocity;
   protected Texture jellyfish;
   protected static int jellyFishWidth = 50;
   protected static int jellyFishHeight = 50;
   protected static int jellyFishRenderWidth = 100;
   protected static int jellyFishRenderHeight = 100;
   protected Rectangle bounds;

   public Jellyfish(int startPosX, int startPosY)
   {
      position = new Vector3(startPosX, startPosY, 0);
      velocity = new Vector3(0 , 0, 0);
      jellyfish = new Texture(Configuration.jellyfish);
      bounds = new Rectangle(position.x, position.y, jellyFishWidth, jellyFishHeight);
   }


   @Override
   public void dispose() {
      jellyfish.dispose();
   }

   @Override
   public void render(SpriteBatch spriteBatch) {
      spriteBatch.draw(jellyfish, position.x - 25, position.y -25, jellyFishRenderWidth, jellyFishRenderHeight);
   }

   @Override
   public Vector3 getPosition() {
      return position;
   }

   @Override
   public Shape2D getBounds() {
      return bounds;
   }

   abstract public void jump();
   abstract public boolean collides(Sprite object);
}
