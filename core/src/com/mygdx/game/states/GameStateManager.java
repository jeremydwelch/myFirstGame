package com.mygdx.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.config.Configuration;
import com.mygdx.game.config.Difficulty;
import com.mygdx.game.config.Score;

import java.util.Stack;

//import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/**
 * Created by Jeremy on 5/21/2017.
 */

public class GameStateManager {

    private Stack<State> states;
    private OrthographicCamera camera;
    private Vector3 mouse;
    private Difficulty difficulty;
    private Score score;
    private Texture background;
    private Texture background2;
    private Vector3 background_position;
    private Vector3 background2_position;
    private Vector3 velocity;

//    private FreeTypeFontGenerator.FreeTypeFontParameter parameter;
//    private FreeTypeFontGenerator generator;
    private GlyphLayout layout;
    private BitmapFont font;

    public GameStateManager(Stack<State> states, OrthographicCamera camera, Vector3 mouse)
    {
        this.states = states;
        this.camera = camera;
        this.mouse = mouse;
        this.setupFont();
        this.score = new Score(Configuration.NUM_ASTEROIDS_CLEARED,
                               Configuration.NEXT_DIFFICULTY,
                               Configuration.SCORE);
        this.difficulty = new Difficulty(Configuration.NUM_ASTEROIDS,
                                         Configuration.MINIMUM_ASTEROID_VELOCITY,
                                         Configuration.ASTEROID_FLUCTUATION);

        background = new Texture(Configuration.background);
        background_position = new Vector3(0,0,0);
        background2_position = new Vector3(0, Configuration.HEIGHT, 0);

        velocity = new Vector3(0, Configuration.BACKGROUND_VELOCITY, 0);

        background2 = background;
    }

    public void push(State state)
    {
        this.states.push(state);
    }

    public void pop()
    {
        this.states.pop();
    }

    public void set(State state)
    {
        this.pop();
        this.push(state);
    }

    public OrthographicCamera getCamera()
    {
        return camera;
    }

    public Vector3 getMouse()
    {
        return mouse;
    }

    public void update(float deltaTime)
    {
      velocity.scl(deltaTime);

      background2_position.add(0, velocity.y,0);
      background_position.add(0, velocity.y,0);


      if ( background_position.y < (-Configuration.HEIGHT))
      {
         background_position.y = Configuration.HEIGHT-1;
      }
      if ( background2_position.y < (-Configuration.HEIGHT))
      {
         background2_position.y = Configuration.HEIGHT-1;
      }

      velocity.scl(1/deltaTime);

      this.states.peek().update(deltaTime);

    }
    public void render(SpriteBatch spriteBatch)
    {
        spriteBatch.begin();

        spriteBatch.draw(background, 0, background_position.y, Configuration.WIDTH, Configuration.HEIGHT);
        spriteBatch.draw(background2, 0, background2_position.y, Configuration.WIDTH, Configuration.HEIGHT);

        this.states.peek().render(spriteBatch);

        spriteBatch.end();
    }

    private void setupFont()
    {
//        generator = new FreeTypeFontGenerator(Configuration.font);
//        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
//        parameter.characters = Configuration.characters;
//        parameter.size = 30;
        layout = new GlyphLayout();
    }

    public BitmapFont createFont(int size)
    {
//        parameter.size = size;
//        font = generator.generateFont(parameter);\
//        font = new BitmapFont(Configuration.font);
        font = new BitmapFont(Configuration.font);
        font.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        return font;
    }

    public BitmapFont createFont()
    {
        return this.createFont(30);
    }


    public float getTextWidth(BitmapFont font, String text)
    {
        layout.setText(font, text);
        return layout.width;
    }

    public Difficulty getDifficulty() {
        return this.difficulty;
    }

    public Score getScore() {
        return this.score;
    }
}
