package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.BattleShip;

import org.omg.CORBA.BAD_CONTEXT;

/**
 * Screen when it's your turn
 */
public class CreatorScreen extends ScreenAdapter{
    private BattleShip game;
    private CreatorStage creatorStage;
    /**
     * GameScreen Default Constructor
     */
    public CreatorScreen(){
        game = BattleShip.getInstance();

        this.loadAssets();

        creatorStage = new CreatorStage();
    }
    /**
     * Loads the assets needed by this screen.
     */
    public void loadAssets() {
    game.getAssetManager().load("ship_small_b_body.png", Texture.class);
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

        creatorStage.act();
        creatorStage.draw();
    }
    /**
     * Resize override
     * @param width     width
     * @param height    height
     */
    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        creatorStage.getViewport().update(width, height, true);
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
