package com.mygdx.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.BattleShip;
import com.mygdx.game.model.Carrier;
import com.mygdx.game.model.Cell;
import com.mygdx.game.model.Cruiser;
import com.mygdx.game.model.Dreadnought;
import com.mygdx.game.model.PatrolBoat;
import com.mygdx.game.model.Submarine;

public class CellController {
    private Cell cellModel;
    private CellController me;

    public CellController(Cell cellModel) {
        this.cellModel = cellModel;
    }

    public Cell getCellModel() {
        return cellModel;
    }

    public void setButton(Button button) {
        this.cellModel.setButton(button);

        ClickListener listener;

        this.cellModel.getButton().addListener(listener = new ClickListener() {
            public void clicked(InputEvent event, float x, float y){
                ShipController ship = cellModel.getBoard().getChosen();
                if(ship != null){
                    ship.update(cellModel.getBoard().getBoard(), cellModel.getColumn(), cellModel.getLine());
                }
            }
        });

        this.cellModel.setCreateListener(listener);
    }

    public void setShoot(GameController gController){
        this.cellModel.setController(gController);
        me = this;

        ClickListener listener;

        this.cellModel.getButton().addListener(listener = new ClickListener() {
            public void clicked(InputEvent event, float x, float y){
                cellModel.getController().setChosen(me);
            }
        });
    }

    public Button getButtonRm() {
        this.cellModel.getButton().removeListener(this.cellModel.getCreateListener());
        return this.cellModel.getButton();
    }

    private void playCannonSound() {
        Sound cannon = BattleShip.getInstance().getAssetManager().get("cannonSound.mp3");
        cannon.play();
    }

    public boolean destroy(){
        if(this.cellModel.getShootListener() != null)
            this.cellModel.getButton().removeListener(this.cellModel.getShootListener());

        if(this.cellModel.getShip() != null) {
            this.cellModel.setDestroyed(true);
            Gdx.input.vibrate(500);
            playCannonSound();

            Texture hitCellTexture = BattleShip.getInstance().getAssetManager().get("redSquare.png");
            Sprite sprite = new Sprite(hitCellTexture);
            TextureRegion hitCellTextureRegion = new TextureRegion(sprite);
            TextureRegionDrawable hitCellTextureRegionDrawable = new TextureRegionDrawable(hitCellTextureRegion);
            ImageButton.ButtonStyle style = new ImageButton.ButtonStyle(hitCellTextureRegionDrawable,hitCellTextureRegionDrawable,hitCellTextureRegionDrawable);
            this.cellModel.getButton().setStyle(style);

            this.cellModel.getShip().check();

            return true;
        }

        Texture hitCellTexture = BattleShip.getInstance().getAssetManager().get("greenSquare.png");
        Sprite sprite = new Sprite(hitCellTexture);
        TextureRegion hitCellTextureRegion = new TextureRegion(sprite);
        TextureRegionDrawable hitCellTextureRegionDrawable = new TextureRegionDrawable(hitCellTextureRegion);
        ImageButton.ButtonStyle style = new ImageButton.ButtonStyle(hitCellTextureRegionDrawable,hitCellTextureRegionDrawable,hitCellTextureRegionDrawable);
        this.cellModel.getButton().setStyle(style);

        return false;
    }

    public void occupy(ShipController ship, int index) {
        this.cellModel.setShip(ship);

        int rotateAngle = 0;

        switch (this.cellModel.getShip().getShipModel().getWay()) {
            case W:
                rotateAngle = 0;
                break;
            case N:
                rotateAngle = 270;
                break;
            case E:
                rotateAngle = 180;
                break;
            case S:
                rotateAngle = 90;
                break;
        }

        if (this.cellModel.getShip().getShipModel() instanceof Carrier) {

            String file = "blueCarrier" + Integer.toString(index + 1) + "-" + Integer.toString(rotateAngle) + ".png";
            Texture cellTexture = BattleShip.getInstance().getAssetManager().get(file);
            Sprite sprite = new Sprite(cellTexture);
            TextureRegion cellTextureRegion = new TextureRegion(sprite);
            TextureRegionDrawable cellTextureRegionDrawable = new TextureRegionDrawable(cellTextureRegion);
            ImageButton.ButtonStyle style = new ImageButton.ButtonStyle(cellTextureRegionDrawable, cellTextureRegionDrawable, cellTextureRegionDrawable);
            this.cellModel.getButton().setStyle(style);

        } else if (this.cellModel.getShip().getShipModel() instanceof Dreadnought) {

            String file = "blueDreadnought" + Integer.toString(index + 1) + "-" + Integer.toString(rotateAngle) + ".png";
            Texture cellTexture = BattleShip.getInstance().getAssetManager().get(file);
            Sprite sprite = new Sprite(cellTexture);
            TextureRegion cellTextureRegion = new TextureRegion(sprite);
            TextureRegionDrawable cellTextureRegionDrawable = new TextureRegionDrawable(cellTextureRegion);
            ImageButton.ButtonStyle style = new ImageButton.ButtonStyle(cellTextureRegionDrawable, cellTextureRegionDrawable, cellTextureRegionDrawable);
            this.cellModel.getButton().setStyle(style);

        } else if (this.cellModel.getShip().getShipModel() instanceof Submarine) {

            String file = "blueSubmarine" + Integer.toString(index + 1) + "-" + Integer.toString(rotateAngle) + ".png";;
            Texture cellTexture = BattleShip.getInstance().getAssetManager().get(file);
            Sprite sprite = new Sprite(cellTexture);
            TextureRegion cellTextureRegion = new TextureRegion(sprite);
            TextureRegionDrawable cellTextureRegionDrawable = new TextureRegionDrawable(cellTextureRegion);
            ImageButton.ButtonStyle style = new ImageButton.ButtonStyle(cellTextureRegionDrawable, cellTextureRegionDrawable, cellTextureRegionDrawable);
            this.cellModel.getButton().setStyle(style);

        } else if (this.cellModel.getShip().getShipModel() instanceof Cruiser) {

            String file = "blueCruiser" + Integer.toString(index + 1) + "-" + Integer.toString(rotateAngle) + ".png";;
            Texture cellTexture = BattleShip.getInstance().getAssetManager().get(file);
            Sprite sprite = new Sprite(cellTexture);
            TextureRegion cellTextureRegion = new TextureRegion(sprite);
            TextureRegionDrawable cellTextureRegionDrawable = new TextureRegionDrawable(cellTextureRegion);
            ImageButton.ButtonStyle style = new ImageButton.ButtonStyle(cellTextureRegionDrawable, cellTextureRegionDrawable, cellTextureRegionDrawable);
            this.cellModel.getButton().setStyle(style);

        } else if (this.cellModel.getShip().getShipModel() instanceof PatrolBoat) {

            String file = "bluePatrolBoat" + Integer.toString(index + 1) + "-" + Integer.toString(rotateAngle) + ".png";
            Texture cellTexture = BattleShip.getInstance().getAssetManager().get(file);
            Sprite sprite = new Sprite(cellTexture);
            TextureRegion cellTextureRegion = new TextureRegion(sprite);
            TextureRegionDrawable cellTextureRegionDrawable = new TextureRegionDrawable(cellTextureRegion);
            ImageButton.ButtonStyle style = new ImageButton.ButtonStyle(cellTextureRegionDrawable, cellTextureRegionDrawable, cellTextureRegionDrawable);
            this.cellModel.getButton().setStyle(style);
        }
    }

    public boolean occupied(ShipController s){
        return s != this.cellModel.getShip() && this.cellModel.getShip() != null;
    }

    public void free(){
        this.cellModel.setShip(null);

        Texture cellTexture = BattleShip.getInstance().getAssetManager().get("square.png");
        TextureRegion cellTextureRegion = new TextureRegion(cellTexture);
        TextureRegionDrawable cellTextureRegionDrawable = new TextureRegionDrawable(cellTextureRegion);
        Button.ButtonStyle style2 = new Button.ButtonStyle(cellTextureRegionDrawable,cellTextureRegionDrawable,cellTextureRegionDrawable);
        this.cellModel.getButton().setStyle(style2);
    }
}
