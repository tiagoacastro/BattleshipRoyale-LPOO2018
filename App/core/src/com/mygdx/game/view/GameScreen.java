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

        game.getAssetManager().load("square.png", Texture.class);
        game.getAssetManager().load("bluePatrolBoat1-0.png", Texture.class);
        game.getAssetManager().load("bluePatrolBoat1-90.png", Texture.class);
        game.getAssetManager().load("bluePatrolBoat1-180.png", Texture.class);
        game.getAssetManager().load("bluePatrolBoat1-270.png", Texture.class);

        game.getAssetManager().load("blueCruiser1-0.png", Texture.class);
        game.getAssetManager().load("blueCruiser1-90.png", Texture.class);
        game.getAssetManager().load("blueCruiser1-180.png", Texture.class);
        game.getAssetManager().load("blueCruiser1-270.png", Texture.class);
        game.getAssetManager().load("blueCruiser2-0.png", Texture.class);
        game.getAssetManager().load("blueCruiser2-90.png", Texture.class);
        game.getAssetManager().load("blueCruiser2-180.png", Texture.class);
        game.getAssetManager().load("blueCruiser2-270.png", Texture.class);

        game.getAssetManager().load("blueSubmarine1-0.png", Texture.class);
        game.getAssetManager().load("blueSubmarine1-90.png", Texture.class);
        game.getAssetManager().load("blueSubmarine1-180.png", Texture.class);
        game.getAssetManager().load("blueSubmarine1-270.png", Texture.class);
        game.getAssetManager().load("blueSubmarine2-0.png", Texture.class);
        game.getAssetManager().load("blueSubmarine2-90.png", Texture.class);
        game.getAssetManager().load("blueSubmarine2-180.png", Texture.class);
        game.getAssetManager().load("blueSubmarine2-270.png", Texture.class);
        game.getAssetManager().load("blueSubmarine3-0.png", Texture.class);
        game.getAssetManager().load("blueSubmarine3-90.png", Texture.class);
        game.getAssetManager().load("blueSubmarine3-180.png", Texture.class);
        game.getAssetManager().load("blueSubmarine3-270.png", Texture.class);

        game.getAssetManager().load("blueDreadnought1-0.png", Texture.class);
        game.getAssetManager().load("blueDreadnought1-90.png", Texture.class);
        game.getAssetManager().load("blueDreadnought1-180.png", Texture.class);
        game.getAssetManager().load("blueDreadnought1-270.png", Texture.class);
        game.getAssetManager().load("blueDreadnought2-0.png", Texture.class);
        game.getAssetManager().load("blueDreadnought2-90.png", Texture.class);
        game.getAssetManager().load("blueDreadnought2-180.png", Texture.class);
        game.getAssetManager().load("blueDreadnought2-270.png", Texture.class);
        game.getAssetManager().load("blueDreadnought3-0.png", Texture.class);
        game.getAssetManager().load("blueDreadnought3-90.png", Texture.class);
        game.getAssetManager().load("blueDreadnought3-180.png", Texture.class);
        game.getAssetManager().load("blueDreadnought3-270.png", Texture.class);
        game.getAssetManager().load("blueDreadnought4-0.png", Texture.class);
        game.getAssetManager().load("blueDreadnought4-90.png", Texture.class);
        game.getAssetManager().load("blueDreadnought4-180.png", Texture.class);
        game.getAssetManager().load("blueDreadnought4-270.png", Texture.class);

        game.getAssetManager().load("blueCarrier1-0.png", Texture.class);
        game.getAssetManager().load("blueCarrier1-90.png", Texture.class);
        game.getAssetManager().load("blueCarrier1-180.png", Texture.class);
        game.getAssetManager().load("blueCarrier1-270.png", Texture.class);
        game.getAssetManager().load("blueCarrier2-0.png", Texture.class);
        game.getAssetManager().load("blueCarrier2-90.png", Texture.class);
        game.getAssetManager().load("blueCarrier2-180.png", Texture.class);
        game.getAssetManager().load("blueCarrier2-270.png", Texture.class);
        game.getAssetManager().load("blueCarrier3-0.png", Texture.class);
        game.getAssetManager().load("blueCarrier3-90.png", Texture.class);
        game.getAssetManager().load("blueCarrier3-180.png", Texture.class);
        game.getAssetManager().load("blueCarrier3-270.png", Texture.class);
        game.getAssetManager().load("blueCarrier4-0.png", Texture.class);
        game.getAssetManager().load("blueCarrier4-90.png", Texture.class);
        game.getAssetManager().load("blueCarrier4-180.png", Texture.class);
        game.getAssetManager().load("blueCarrier4-270.png", Texture.class);
        game.getAssetManager().load("blueCarrier5-0.png", Texture.class);
        game.getAssetManager().load("blueCarrier5-90.png", Texture.class);
        game.getAssetManager().load("blueCarrier5-180.png", Texture.class);
        game.getAssetManager().load("blueCarrier5-270.png", Texture.class);

        game.getAssetManager().load("cannonSound.mp3", Sound.class);

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

