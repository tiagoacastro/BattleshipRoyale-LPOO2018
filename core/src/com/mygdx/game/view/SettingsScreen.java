package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.game.BattleShip;

/**
 * Settings Screen
 */
class SettingsScreen extends ScreenAdapter {
    private BattleShip game;
    private SettingsStage settingsStage;
    /**
     * GameScreen Default Constructor
     */
    SettingsScreen(Music music){
        game = BattleShip.getInstance();

        this.loadAssets();

        settingsStage = new SettingsStage(music);
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

        settingsStage.act();
        settingsStage.draw();
    }
    /**
     * Resize override
     * @param width     width
     * @param height    height
     */
    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        settingsStage.getViewport().update(width, height, true);
    }
}
