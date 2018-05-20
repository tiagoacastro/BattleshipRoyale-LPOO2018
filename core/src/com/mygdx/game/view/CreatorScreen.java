package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.BattleShip;
import com.mygdx.game.controller.BoardController;

/**
 * Screen when it's your turn
 */
public class CreatorScreen extends ScreenAdapter{
    private BattleShip game;
    private Texture texture;
    private BoardController board;
    /**
     * GameScreen Default Constructor
     */
    public CreatorScreen(){
        texture  = new Texture("badlogic.jpg");
        game = BattleShip.getInstance();
        board = new BoardController(20);
    }
    /**
     * Render override
     * @param delta delta
     */
    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(texture,0,0);
        game.batch.end();
    }
    /**
     * Resize override
     * @param width     width
     * @param height    height
     */
    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }
    /**
     * Show override
     */
    @Override
    public void show() {
        super.show();
    }
    /**
     * Hide Override
     */
    @Override
    public void hide() {
        super.hide();
    }

    /**
     * Pause Override
     */
    @Override
    public void pause() {
        super.pause();
    }
    /**
     * Resume Override
     */
    @Override
    public void resume() {
        super.resume();
    }
    /**
     * Dispose Override
     */
    @Override
    public void dispose() {
        super.dispose();
        texture.dispose();
        game.dispose();
    }
}
