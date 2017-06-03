package com.mygdx.game.config;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

/**
 * Created by Jeremy on 5/29/2017.
 */

public class Configuration {

   // Screen Variables
   public static final int WIDTH = 480;
   public static final int HEIGHT = 800;
   public static final int BACKGROUND_VELOCITY = -50;

   // Game Variables
   public static final int NUM_ASTEROIDS_CLEARED = 0;
   public static final int NEXT_DIFFICULTY = 6;
   public static final int SCORE = 0;
   public static final int NUM_ASTEROIDS = 4;
   public static final int MINIMUM_ASTEROID_VELOCITY = -125;
   public static final int ASTEROID_FLUCTUATION = 100;
   public static final String characters = "abcdefghijklmnopqrstuvwxyz'1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ:!@#$$%^&*()_";
   public static final String title = "Sir Jelly's Adventure";

   // Assets
   public static final FileHandle font = Gdx.files.internal("fonts/radiospace.fnt");
   public static final FileHandle background = Gdx.files.internal("spacebackground.png");
   public static final FileHandle gameOverButton = Gdx.files.internal("buttons/gameover.jpg");
   public static final FileHandle pauseButton = Gdx.files.internal("buttons/pause.png");
   public static final FileHandle playButton = Gdx.files.internal("buttons/playbutton.png");
   public static final FileHandle jellyfish = Gdx.files.internal("sprites/spacejellyfish.png");
   public static final FileHandle asteroid = Gdx.files.internal("sprites/asteroid-icon.png");
}
