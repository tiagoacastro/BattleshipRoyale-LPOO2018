package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.BattleShip;

/**
 * Screen when it's your turn
 */
public class GameScreen extends ScreenAdapter{
    private BattleShip game;
    private Texture texture;
    /**
     * GameScreen Default Constructor
     */
    public GameScreen(){
        texture  = new Texture("badlogic.jpg");
        game = BattleShip.getInstance();
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
        game.getBatch().begin();
        game.getBatch().draw(texture,0,0);
        game.getBatch().end();
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
