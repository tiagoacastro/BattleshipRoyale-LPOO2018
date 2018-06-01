package com.mygdx.game.view;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.BattleShip;

/**
 * Screen when it's your turn
 */
public class EndGameScreen extends ScreenAdapter {
    private BattleShip game;
    private EndGameStage endGameStage;
    private String status;
    /**
     * GameScreen Default Constructor
     */
    public EndGameScreen(String status){
        game = BattleShip.getInstance();

        this.loadAssets();
        this.status = status;

        endGameStage = new EndGameStage();
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
        this.drawBackground();
        game.getBatch().end();

        endGameStage.act();
        endGameStage.draw();
    }
    /**
     * Resize override
     * @param width     width
     * @param height    height
     */
    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        endGameStage.getViewport().update(width, height, true);
    }

    private void drawBackground() {
        Texture background = game.getAssetManager().get("oceanBackground.png", Texture.class);
        game.getBatch().draw(background,0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }
}

