package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.BattleShip;

/**
 * Menu Screen
 */
public class MenuScreen extends ScreenAdapter {
    private BattleShip game;
    private MenuStage menuStage;
    /**
     * MenuScreen Constructor
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
        game.getAssetManager().load("soundOff.png", Texture.class);
        game.getAssetManager().load("soundOn.png", Texture.class);
        game.getAssetManager().load("background.png", Texture.class);
        game.getAssetManager().load("oceanBackground.png", Texture.class);
        game.getAssetManager().load("facebook.png", Texture.class);
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
    /**
     * Draw the background
     */
    private void drawBackground() {
        Texture background = game.getAssetManager().get("background.png", Texture.class);
        game.getBatch().draw(background,0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }
}

