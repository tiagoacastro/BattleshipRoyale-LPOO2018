package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.BattleShip;
import com.mygdx.game.controller.BoardController;

class CreatorStage extends Stage {
    private final float VIEWPORT_WIDTH = 800;
    private final float PIXEL_TO_METER = 0.04f;
    private final int BOARD_SIZE = 10;
    private float ratio;
    private BattleShip game;
    private Viewport viewport;
    private BoardController board;

    CreatorStage() {
        game = BattleShip.getInstance();

        ratio = ((float) Gdx.graphics.getHeight() / (float) Gdx.graphics.getWidth());
        this.viewport = new FitViewport(VIEWPORT_WIDTH, VIEWPORT_WIDTH * ratio);
        viewport.apply();
        this.setViewport(this.viewport);

        board = new BoardController(BOARD_SIZE);
        this.drawBoard();

        Gdx.input.setInputProcessor(this);
    }

    private void drawBoard(){
        /*for(int y = 0; y < BOARD_SIZE; y++){
            for(int x = 0; x < BOARD_SIZE; x++){
                Button button = new Button();
                button.setColor(Color.BLACK);
                this.addActor(button);
            }
        }*/
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw() {
        super.draw();
    }

    @Override
    public Viewport getViewport() {
        return viewport;
    }
}

