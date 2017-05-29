package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.config.Configuration;
import com.mygdx.game.sprites.Asteroid;
import com.mygdx.game.sprites.Jellyfish;
import com.mygdx.game.sprites.Sprite;

import java.util.ArrayList;

/**
 * Created by Jeremy on 5/27/2017.
 */

public abstract class PlayState extends State {

   protected Jellyfish jellyfish;
   protected Texture background;
   protected Texture pause;
   protected ArrayList<Sprite> sprites;
   protected ArrayList<Asteroid> asteroids;
   protected BitmapFont font;

//   protected ShapeRenderer shapeRenderer;

   public PlayState(GameStateManager gameStateManager)
   {
      super(gameStateManager);
      background = new Texture(Configuration.background);
      pause = new Texture(Configuration.pauseButton);

      sprites = new ArrayList<Sprite>();
      asteroids = new ArrayList<Asteroid>();

      font = gameStateManager.createFont();

//      shapeRenderer = new ShapeRenderer();
   }

   abstract public void addAsteroid(int x);
   abstract public void postUpdate();

   @Override
   public void update(float deltaTime)
   {
      this.handleInput();
      if ( Gdx.input.justTouched() && (Gdx.input.getX() < 40) && (Gdx.input.getY() < 40))
      {
         gameStateManager.push(new PauseState(gameStateManager, this));
      }

      for (Sprite sprite:sprites)
      {
         sprite.update(deltaTime);
      }

      for (Asteroid asteroid : asteroids)
      {
         if (jellyfish.collides(asteroid))
         {
            gameStateManager.set(new GameOverState(gameStateManager));
            this.dispose();
         }
      }
      this.postUpdate();
   }

   @Override
   public void render(SpriteBatch spriteBatch)
   {
      spriteBatch.draw(background, 0,0, Configuration.WIDTH, Configuration.HEIGHT);
      spriteBatch.draw(pause, 0, Configuration.HEIGHT -50, 50, 50);

      for (Sprite sprite:sprites)
      {
         sprite.render(spriteBatch);
      }

      String text = gameStateManager.getScore().getScore().toString();
      float x = Configuration.WIDTH - gameStateManager.getTextWidth(font, text) - 10;

      font.draw(spriteBatch, text, x, Configuration.HEIGHT -15);


/*
      shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
      Gdx.gl20.glLineWidth(5);
      shapeRenderer.setColor(Color.WHITE);

      for (Asteroid asteroid : asteroids)
      {
         Circle circle = (Circle)asteroid.getBounds();
         shapeRenderer.circle(circle.x, circle.y, circle.radius);
      }
      Rectangle rect = (Rectangle)jellyfish.getBounds();
      shapeRenderer.rect(rect.x, rect.y, rect.width, rect.height);

      shapeRenderer.end();
      */
   }

   @Override
   public void dispose() {

      background.dispose();
      pause.dispose();
      font.dispose();
      for (Sprite sprite:sprites)
      {
         sprite.dispose();
      }
   }


}
