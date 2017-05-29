package com.mygdx.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.mygdx.game.config.Configuration;

/**
 * Created by Jeremy on 5/27/2017.
 */

public class StandardJellyfish extends Jellyfish  {

   public static final int SPEED = 4;
   public static final float FRICTION = 0.1f;

   public StandardJellyfish(int startPosX, int startPosY)
   {
      super(startPosX, startPosY);
      velocity.set(0, 0, 0);
   }

   @Override
   public void update(float deltaTime)
   {
      velocity.scl(deltaTime);

      if (Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT) ||
          Gdx.input.isKeyPressed(Input.Keys.A))
      {
         if ( position.x > (jellyFishWidth))
         {
            velocity.set(-SPEED, velocity.y, 0);
         }
      }
      if (Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT) ||
              Gdx.input.isKeyPressed(Input.Keys.D))
      {
         if ( position.x < (Configuration.WIDTH - (jellyFishWidth*2)))
         {
            velocity.set(SPEED, velocity.y, 0);
         }
      }
      if (Gdx.input.isKeyPressed(Input.Keys.DPAD_UP) ||
              Gdx.input.isKeyPressed(Input.Keys.W))
      {
         if ( position.y < (Configuration.HEIGHT - (jellyFishHeight*4)))
         {
            velocity.set(velocity.x, SPEED, 0);
         }
      }
      if (Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN) ||
              Gdx.input.isKeyPressed(Input.Keys.S))
      {
         if ( position.y > (jellyFishHeight*2) )
         {
            velocity.set(velocity.x, -SPEED, 0);
         }
      }
      if ( velocity.x != 0)
      {
         if (velocity.x < 0)
         {
            velocity.add(FRICTION, 0, 0);
            if (velocity.x > 0)
            {
               velocity.x = 0;
            }
         }
         else
         {
            velocity.add(-FRICTION, 0, 0);
            if (velocity.x < 0)
            {
               velocity.x = 0;
            }
         }
      }

      if ( velocity.y != 0 )
      {
         if (velocity.y < 0)
         {
            velocity.add(0, FRICTION, 0);
            if (velocity.y > 0)
            {
               velocity.y = 0;
            }
         }
         else
         {
            velocity.add(0, -FRICTION, 0);
            if (velocity.y < 0)
            {
               velocity.y = 0;
            }
         }
      }
      position.add(velocity.x, 0, 0);
      position.add(0, velocity.y, 0);

      bounds.setPosition(position.x, position.y);
      velocity.scl(1/deltaTime);

   }

   @Override
   public boolean collides(Sprite object)
   {
      Asteroid asteroid = (Asteroid) object;
      return Intersector.overlaps((Circle) asteroid.getBounds(), this.bounds);
   }


   @Override
   public void jump() {

   }
}
