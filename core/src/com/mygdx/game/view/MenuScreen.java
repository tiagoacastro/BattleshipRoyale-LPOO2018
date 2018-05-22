package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.BattleShip;

/**
 * Menu Screen
 */
public class MenuScreen extends ScreenAdapter {
    private MenuStage menuStage;

    private BattleShip game;
    /**
     * GameScreen Default Constructor
     */
    public MenuScreen(){
        game = BattleShip.getInstance();

        loadAssets();

        menuStage = new MenuStage();
        Gdx.input.setInputProcessor(menuStage);
    }
    /**
     * Loads the assets needed by this screen.
     */
    private void loadAssets() {
        this.game.getAssetManager().load( "black.jpg" , Texture.class);
        this.game.getAssetManager().finishLoading();
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
        /*
        Texture badlogic = game.getAssetManager().get("badlogic.jpg");
        game.getBatch().begin();
        game.getBatch().draw(badlogic,0,0);
        game.getBatch().end();
        */
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
        game.getViewport().update(width, height, true);
    }
    /**
     * Dispose Override
     */
    @Override
    public void dispose() {
        super.dispose();
        game.dispose();
    }
}

