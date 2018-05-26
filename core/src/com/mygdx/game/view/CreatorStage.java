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
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.BattleShip;
import com.mygdx.game.controller.BoardController;
import com.mygdx.game.controller.ShipController;

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
                board.getBoard().getMatrix()[y][x].setButton(button);;
            }
            boardTable.add().width(VIEWPORT_WIDTH/24);
            boardTable.row();
        }
        boardTable.add().height(VIEWPORT_WIDTH*ratio/12).colspan(12);
    }

    private void drawGui(){
        Label title = new Label("Board Creator", new Label.LabelStyle(new BitmapFont(), null));
        title.setColor(Color.BLACK);
        guiTable.add(title).center().height(VIEWPORT_WIDTH*ratio/12).colspan(2);
        guiTable.row();
        for (int i = 0; i < 5; i++) {
            ImageButton.ImageButtonStyle style = new ImageButton.ImageButtonStyle();
            ImageButton shipButton = new ImageButton(style);
            shipButton = createShipButton(i, shipButton);
            guiTable.add(shipButton).width(VIEWPORT_WIDTH / 4).height(10*VIEWPORT_WIDTH * ratio / 108).center().expand();
            guiTable.add().width(VIEWPORT_WIDTH / 2).height(10*VIEWPORT_WIDTH * ratio / 108);
            guiTable.row();
            if(i != 4) {
                guiTable.add().width(VIEWPORT_WIDTH).height(10 * VIEWPORT_WIDTH * ratio / 108).colspan(2);
                guiTable.row();
            }
        }
        TextButton.TextButtonStyle textStyle = new TextButton.TextButtonStyle();
        textStyle.font = new BitmapFont();
        TextButton rotateButton = new TextButton("rotate", textStyle);
        rotateButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y){
                if(board.getChosen() != null)
                    board.getChosen().rotate();
            }
        });
        guiTable.add(rotateButton).width(VIEWPORT_WIDTH / 4).height(VIEWPORT_WIDTH*ratio/12).colspan(2).expand();
    }

    private ImageButton createShipButton(int i,ImageButton shipButton) {
        switch(i){
            case 0:
                Texture myCarrier = game.getAssetManager().get("carrier.png");
                TextureRegion myCarrierRegion = new TextureRegion(myCarrier);
                TextureRegionDrawable myCarrierRegionDrawable = new TextureRegionDrawable(myCarrierRegion);
                shipButton = new ImageButton(myCarrierRegionDrawable); //Set the button up
                shipButton.addListener(new ClickListener() {
                    public void clicked(InputEvent event, float x, float y){
                        board.setChosen(BoardController.Ships.carrier);
                    }
                });
                break;
            case 1:
                Texture myDreadnought = game.getAssetManager().get("ship_small_b_body.png");
                TextureRegion myDreadnoughtRegion = new TextureRegion(myDreadnought);
                TextureRegionDrawable myDreadnoughtRegionDrawable = new TextureRegionDrawable(myDreadnoughtRegion);
                shipButton = new ImageButton(myDreadnoughtRegionDrawable); //Set the button up
                shipButton.addListener(new ClickListener() {
                    public void clicked(InputEvent event, float x, float y){
                        board.setChosen(BoardController.Ships.dreadnought);
                    }
                });
                break;
            case 2:
                Texture mySubmarine = game.getAssetManager().get("submarine.png");
                TextureRegion mySubmarineRegion = new TextureRegion(mySubmarine);
                TextureRegionDrawable mySubmarineRegionDrawable = new TextureRegionDrawable(mySubmarineRegion);
                shipButton = new ImageButton(mySubmarineRegionDrawable); //Set the button up
                shipButton.addListener(new ClickListener() {
                    public void clicked(InputEvent event, float x, float y){
                        board.setChosen(BoardController.Ships.submarine);
                    }
                });
                break;
            case 3:
                Texture myCruiser = game.getAssetManager().get("cruiser.png");
                TextureRegion myCruiserRegion = new TextureRegion(myCruiser);
                TextureRegionDrawable myCruiserRegionDrawable = new TextureRegionDrawable(myCruiserRegion);
                shipButton = new ImageButton(myCruiserRegionDrawable); //Set the button up
                shipButton.addListener(new ClickListener() {
                    public void clicked(InputEvent event, float x, float y){
                        board.setChosen(BoardController.Ships.cruiser);
                    }
                });
                break;
            case 4:
                Texture myPatrolBoat = game.getAssetManager().get("patrolBoat.png");
                TextureRegion myPatrolBoatRegion = new TextureRegion(myPatrolBoat);
                TextureRegionDrawable myPatrolBoatRegionDrawable = new TextureRegionDrawable(myPatrolBoatRegion);
                shipButton = new ImageButton(myPatrolBoatRegionDrawable); //Set the button up
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


