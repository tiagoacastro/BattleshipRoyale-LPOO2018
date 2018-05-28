package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.game.BattleShip;
import com.mygdx.game.controller.BoardController;

/**
 * Menu Screen
 */
public class GameScreen extends ScreenAdapter {
    private BattleShip game;
    private GameStage gameStage;
    /**
     * GameScreen Default Constructor
     */
    GameScreen(BoardController board){
        game = BattleShip.getInstance();

        this.loadAssets();

        gameStage = new GameStage(board);
    }
    /**
     * Loads the assets needed by this screen.
     */
    private void loadAssets() {

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
}

