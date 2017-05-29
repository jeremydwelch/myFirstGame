package com.mygdx.game.sprites;


import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.mygdx.game.config.Configuration;

/**
 * Created by Jeremy on 5/26/2017.
 */

public class SimpleJellyfish extends Jellyfish {

    public static final int GRAVITY = -15;

    public SimpleJellyfish (int startPosX, int startPosY)
    {
       super(startPosX, startPosY);
    }

    @Override
    public void update(float deltaTime)
    {
        if ( (position.y > 0) ) {
            velocity.add(0, GRAVITY, 0);
        }

        velocity.scl(deltaTime);
        position.add(0, velocity.y, 0);
        bounds.setPosition(position.x, position.y);
        velocity.scl(1 / deltaTime);

        if (position.y < 0)
        {
            this.jump();
        }

    }

    public void jump()
    {
        if (position.y < (Configuration.HEIGHT - 70 )) {
            velocity.y = 325;
        }
    }

    @Override
    public boolean collides(Sprite object)
    {
      HorizontalAsteroid horizontalAsteroid = (HorizontalAsteroid) object;
      if (horizontalAsteroid.getPosition().x < 20 || horizontalAsteroid.getPosition().x > 150 )
      {
         return false;
      }
      return Intersector.overlaps((Circle) horizontalAsteroid.getBounds(), this.bounds);
    }

}
