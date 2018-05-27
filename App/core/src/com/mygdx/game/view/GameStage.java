package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.BattleShip;
import com.mygdx.game.controller.BoardController;

class GameStage extends Stage {
    private static final float VIEWPORT_WIDTH = 800;
    private static final int BOARD_SIZE = 10;
    private float ratio;
    private BattleShip game;
    private Viewport viewport;
    private BoardController userBoard;

    GameStage(BoardController board) {
        game = BattleShip.getInstance();
        this.userBoard = board;

        ratio = ((float) Gdx.graphics.getHeight() / (float) Gdx.graphics.getWidth());
        this.viewport = new FitViewport(VIEWPORT_WIDTH, VIEWPORT_WIDTH * ratio);
        viewport.apply();
        this.setViewport(this.viewport);

        Gdx.input.setInputProcessor(this);

        this.drawBoard();

        this.drawGui();
    }

    private void drawBoard(){
        Table boardTable = new Table();
        boardTable.setFillParent(true);
        this.addActor(boardTable);

        boardTable.add().height(VIEWPORT_WIDTH*ratio/12).colspan(12);

        boardTable.row();

        for(int y = 0; y < BOARD_SIZE; y++){
            boardTable.add().width(13*VIEWPORT_WIDTH/24);

            for(int x = 0; x < BOARD_SIZE; x++){
                boardTable.add(userBoard.getBoard().getMatrix()[y][x].getCreatorButton()).width(VIEWPORT_WIDTH/24).height(VIEWPORT_WIDTH*ratio/12);
            }

            boardTable.add().width(VIEWPORT_WIDTH/24);

            boardTable.row();
        }

        boardTable.add().height(VIEWPORT_WIDTH*ratio/12).colspan(12);
    }

    private void drawGui(){

    }

    @Override
    public Viewport getViewport() {
        return viewport;
    }
}
