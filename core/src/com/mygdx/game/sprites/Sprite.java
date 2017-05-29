package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Shape2D;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Jeremy on 5/26/2017.
 */

public interface Sprite {

   public void update(float deltaTime);
   public void dispose();
   public void render(SpriteBatch spriteBatch);
   public Vector3 getPosition();
   public Shape2D getBounds();
}
