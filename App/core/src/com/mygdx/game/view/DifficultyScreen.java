package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.BattleShip;
import com.mygdx.game.controller.BoardController;

/**
 * Screen to choose the difficulty
 */
public class DifficultyScreen extends ScreenAdapter {
    private BattleShip game;
    private DifficultyStage difficultyStage;
    /**
     * DifficultyScreen Constructor
     */
    DifficultyScreen(BoardController board){
        game = BattleShip.getInstance();

        this.loadAssets();

        difficultyStage = new DifficultyStage(board);
    }
    /**
     * Loads the assets needed by this screen.
     */
    private void loadAssets() {
        game.getAssetManager().load("oceanBackground.png", Texture.class);
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
        drawBackground();
        game.getBatch().end();

        difficultyStage.act();
        difficultyStage.draw();
    }
    /**
     * Resize override
     * @param width     width
     * @param height    height
     */
    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        difficultyStage.getViewport().update(width, height, true);
    }
    /**
     * Draws the background
     */
    private void drawBackground() {
        Texture background = game.getAssetManager().get("oceanBackground.png", Texture.class);
        game.getBatch().draw(background,0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }
}