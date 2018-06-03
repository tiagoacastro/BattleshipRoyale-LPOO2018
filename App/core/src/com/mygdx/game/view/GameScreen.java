package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.BattleShip;
import com.mygdx.game.controller.BoardController;

/**
 * Game Screen
 */
public class GameScreen extends ScreenAdapter {
    private BattleShip game;
    private GameStage gameStage;
    /**
     * GameScreen Constructor
     */
    GameScreen(BoardController board, DifficultyStage.Difficulty difficulty){
        game = BattleShip.getInstance();

        this.loadAssets();

        gameStage = new GameStage(board, difficulty);
    }
    /**
     * Loads the assets needed by this screen.
     */
    private void loadAssets() {

        game.getAssetManager().load("cannonSound.mp3", Sound.class);

        game.getAssetManager().load("destroyedCarrier.png", Texture.class);
        game.getAssetManager().load("destroyedCruiser.png", Texture.class);
        game.getAssetManager().load("destroyedPatrolBoat.png", Texture.class);
        game.getAssetManager().load("destroyedSubmarine.png", Texture.class);
        game.getAssetManager().load("destroyedDreadnought.png", Texture.class);
        game.getAssetManager().load("redSquare.png", Texture.class);
        game.getAssetManager().load("greenSquare.png", Texture.class);

        game.getAssetManager().finishLoading();
    }
    /**
     * Render override
     * @param delta delta
     */
    @Override
    public void render(float delta) {
        super.render(delta);

        Gdx.gl.glClearColor(255,255,255,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        game.getBatch().begin();
        this.drawBackground();
        game.getBatch().end();

        gameStage.act();
        gameStage.draw();
    }
    /**
     * Resize override
     * @param width     width
     * @param height    height
     */
    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        gameStage.getViewport().update(width, height, true);
    }
    /**
     * Draws background
     */
    private void drawBackground() {
        Texture background = game.getAssetManager().get("oceanBackground.png", Texture.class);
        game.getBatch().draw(background,0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }
}

