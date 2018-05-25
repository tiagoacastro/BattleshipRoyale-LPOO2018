package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
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
    private Table boardTable;
    private Table guiTable;

    CreatorStage() {
        game = BattleShip.getInstance();

        ratio = ((float) Gdx.graphics.getHeight() / (float) Gdx.graphics.getWidth());
        this.viewport = new FitViewport(VIEWPORT_WIDTH, VIEWPORT_WIDTH * ratio);
        viewport.apply();
        this.setViewport(this.viewport);

        Gdx.input.setInputProcessor(this);

        boardTable = new Table();
        boardTable.setFillParent(true);
        this.addActor(boardTable);
        board = new BoardController(BOARD_SIZE);
        this.drawBoard();

        guiTable = new Table();
        guiTable.setFillParent(true);
        this.addActor(guiTable);
        this.drawGui();
    }

    private void drawBoard(){
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = new BitmapFont();
        boardTable.add().height(VIEWPORT_WIDTH*ratio/12).colspan(12);
        boardTable.row();
        for(int y = 0; y < BOARD_SIZE; y++){
            boardTable.add().width(13*VIEWPORT_WIDTH/24);
            for(int x = 0; x < BOARD_SIZE; x++){
                TextButton button = new TextButton("c", style);
                boardTable.add(button).width(VIEWPORT_WIDTH/24).height(VIEWPORT_WIDTH*ratio/12);
                board.getBoard().getMatrix()[y][x].setButton(button);                                   //listener na classe cell
            }
            boardTable.add().width(VIEWPORT_WIDTH/24);
            boardTable.row();
        }
        boardTable.add().height(VIEWPORT_WIDTH*ratio/12).colspan(12);
    }

    private void drawGui(){
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = new BitmapFont();
        Label title = new Label("Board Creator", new Label.LabelStyle(new BitmapFont(), null));
        title.setColor(Color.BLACK);
        guiTable.add(title).center().height(VIEWPORT_WIDTH*ratio/12).colspan(2);
        guiTable.row();
        for (int i = 0; i < 5; i++) {
            TextButton shipButton = new TextButton("ship", style);;
            shipButton = createShipButton(style, i, shipButton);
            guiTable.add(shipButton).width(VIEWPORT_WIDTH / 4).height(10*VIEWPORT_WIDTH * ratio / 108).center().expand();
            guiTable.add().width(VIEWPORT_WIDTH / 2).height(10*VIEWPORT_WIDTH * ratio / 108);
            guiTable.row();
            if(i != 4) {
                guiTable.add().width(VIEWPORT_WIDTH).height(10 * VIEWPORT_WIDTH * ratio / 108).colspan(2);
                guiTable.row();
            }
        }
        guiTable.add().height(VIEWPORT_WIDTH*ratio/12).colspan(2);
    }

    private TextButton createShipButton(TextButton.TextButtonStyle style, int i, TextButton shipButton) {
        switch(i){
            case 0:
                shipButton = new TextButton("Carrier", style);
                shipButton.addListener(new ClickListener() {
                    public void clicked(InputEvent event, float x, float y){
                        board.setChosen(BoardController.Ships.carrier);
                    }
                });
                break;
            case 1:
                shipButton = new TextButton("Dreadnought", style);
                shipButton.addListener(new ClickListener() {
                    public void clicked(InputEvent event, float x, float y){
                        board.setChosen(BoardController.Ships.dreadnought);
                    }
                });
                break;
            case 2:
                shipButton = new TextButton("Submarine", style);
                shipButton.addListener(new ClickListener() {
                    public void clicked(InputEvent event, float x, float y){
                        board.setChosen(BoardController.Ships.submarine);
                    }
                });
                break;
            case 3:
                shipButton = new TextButton("Cruiser", style);
                shipButton.addListener(new ClickListener() {
                    public void clicked(InputEvent event, float x, float y){
                        board.setChosen(BoardController.Ships.cruiser);
                    }
                });
                break;
            case 4:
                shipButton = new TextButton("Patrol Boat", style);
                shipButton.addListener(new ClickListener() {
                    public void clicked(InputEvent event, float x, float y){
                        board.setChosen(BoardController.Ships.patrolBoat);
                    }
                });
                break;
        }
        return shipButton;
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

