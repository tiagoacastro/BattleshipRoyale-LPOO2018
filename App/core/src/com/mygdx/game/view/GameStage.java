package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.BattleShip;
import com.mygdx.game.controller.BoardController;
import com.mygdx.game.controller.EasyBehaviour;
import com.mygdx.game.controller.GameController;

class GameStage extends Stage {
    private static final float VIEWPORT_WIDTH = 800;
    private static final int BOARD_SIZE = 10;
    private float ratio;
    private BattleShip game;
    private Viewport viewport;
    private GameController controller;
    private Table userBoardTable;
    private Table botBoardTable;
    private Table guiTable;
    private boolean toggleBoard = false;
    private int auxX, auxY;

    GameStage(BoardController board) {
        game = BattleShip.getInstance();
        this.controller = new GameController(board, new EasyBehaviour());

        ratio = ((float) Gdx.graphics.getHeight() / (float) Gdx.graphics.getWidth());
        this.viewport = new FitViewport(VIEWPORT_WIDTH, VIEWPORT_WIDTH * ratio);
        viewport.apply();
        this.setViewport(this.viewport);

        Gdx.input.setInputProcessor(this);

        this.drawUserBoard();

        this.drawBotBoard();

        this.drawGui();
    }

    private void drawUserBoard(){
        userBoardTable = new Table();
        userBoardTable.setFillParent(true);
        this.addActor(userBoardTable);
        userBoardTable.setVisible(false);

        userBoardTable.add().height(VIEWPORT_WIDTH*ratio/12).colspan(12);

        userBoardTable.row();

        for(int y = 0; y < BOARD_SIZE; y++){

            userBoardTable.add().width(VIEWPORT_WIDTH/24);

            for(int x = 0; x < BOARD_SIZE; x++){
                userBoardTable.add(controller.getUserBoard().getBoard().getMatrix()[y][x].getButtonRm()).width(VIEWPORT_WIDTH/24).height(VIEWPORT_WIDTH*ratio/12);
            }

            userBoardTable.add().width(13*VIEWPORT_WIDTH/24);

            userBoardTable.row();
        }

        userBoardTable.add().height(VIEWPORT_WIDTH*ratio/12).colspan(12);
    }

    private void drawBotBoard(){
        botBoardTable = new Table();
        botBoardTable.setFillParent(true);
        this.addActor(botBoardTable);

        botBoardTable.add().height(VIEWPORT_WIDTH*ratio/12).colspan(12);

        botBoardTable.row();

        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = new BitmapFont();

        for(int y = 0; y < BOARD_SIZE; y++){
            for(int x = 0; x < BOARD_SIZE; x++){

                Texture cellTexture = game.getAssetManager().get("square.png");
                TextureRegion cellTextureRegion = new TextureRegion(cellTexture);
                TextureRegionDrawable cellTextureRegionDrawable = new TextureRegionDrawable(cellTextureRegion);
                Button.ButtonStyle style2 = new Button.ButtonStyle(cellTextureRegionDrawable,cellTextureRegionDrawable,cellTextureRegionDrawable);
                Button cellButton = new Button(); //Set the button up
                cellButton.setStyle(style2);

                this.controller.getBotBoard().getBoard().getMatrix()[y][x].setButton(cellButton);
            }
        }

        this.controller.getBotBoard().populate();

        for(int y = 0; y < BOARD_SIZE; y++){

            botBoardTable.add().width(13*VIEWPORT_WIDTH/24);

            for(int x = 0; x < BOARD_SIZE; x++){
                botBoardTable.add(this.controller.getBotBoard().getBoard().getMatrix()[y][x].getButtonRm()).width(VIEWPORT_WIDTH/24).height(VIEWPORT_WIDTH*ratio/12);
                auxX = x;
                auxY = y;
                this.controller.getBotBoard().getBoard().getMatrix()[y][x].setShoot(controller);
            }

            botBoardTable.add().width(VIEWPORT_WIDTH/24);

            botBoardTable.row();
        }

        botBoardTable.add().height(VIEWPORT_WIDTH*ratio/12).colspan(12);
    }

    private void drawGui(){
        guiTable = new Table();
        guiTable.setFillParent(true);
        this.addActor(guiTable);

        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = new BitmapFont();

        guiTable.add().height(11*VIEWPORT_WIDTH*ratio/12).colspan(2);

        guiTable.row();

        guiTable.add().width(VIEWPORT_WIDTH/2);

        TextButton button = new TextButton("Toggle my board", style);
        button.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y){
                if(toggleBoard) {
                    userBoardTable.setVisible(false);
                    toggleBoard = false;
                }else {
                    userBoardTable.setVisible(true);
                    toggleBoard = true;
                }
            }
        });

        guiTable.add(button).width(VIEWPORT_WIDTH/4).expand().center();
    }

    @Override
    public void act() {
        super.act();

        float gyroY = Gdx.input.getGyroscopeY();
        if(gyroY >= 5){
            controller.shoot();
        }
    }

    @Override
    public Viewport getViewport() {
        return viewport;
    }
}
