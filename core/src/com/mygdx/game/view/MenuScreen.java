package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.game.BattleShip;

/**
 * Menu Screen
 */
public class MenuScreen extends ScreenAdapter {
    private BattleShip game;
    private MenuStage menuStage;
    /**
     * GameScreen Default Constructor
     */
    public MenuScreen(){
        game = BattleShip.getInstance();

        this.loadAssets();

        menuStage = new MenuStage();
    }
    /**
     * Loads the assets needed by this screen.
     */
    private void loadAssets() {
        game.getAssetManager().load("thunder.mp3", Music.class);
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

        menuStage.act();
        menuStage.draw();
    }
    /**
     * Resize override
     * @param width     width
     * @param height    height
     */
    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        menuStage.getViewport().update(width, height, true);
    }
}

