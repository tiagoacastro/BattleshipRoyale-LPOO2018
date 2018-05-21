package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.BattleShip;
import com.mygdx.game.controller.BoardController;
import com.badlogic.gdx.utils.viewport.*;


/**
 * Screen when it's your turn
 */
public class CreatorScreen extends ScreenAdapter{
    private static final float VIEWPORT_WIDTH = 400;
    private Viewport viewport;

    private BattleShip game;
    private Texture texture;
    private BoardController board;
    /**
     * GameScreen Default Constructor
     */
    public CreatorScreen(){
        float ratio = ((float) Gdx.graphics.getHeight() / (float) Gdx.graphics.getWidth());
        this.viewport = new FitViewport(VIEWPORT_WIDTH, VIEWPORT_WIDTH * ratio);
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
        boolean f = false;
        if (Gdx.input.isTouched()) {
            f = true;
        }
        if(f)
            Gdx.gl.glClearColor(255,255,255,1);
        else
            Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
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
        viewport.update(width, height, true);
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
