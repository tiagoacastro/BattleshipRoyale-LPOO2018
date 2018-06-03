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

/**
 * Cell Controller class in charge of all the logic around the cell
 */
public class CellController {
    private Cell cellModel;
    private CellController me;
    /**
     * Constructor for the cell controller
     * @param cellModel cell model
     */
    public CellController(Cell cellModel) {
        this.cellModel = cellModel;
    }
    /**
     * Getter for the cell model
     * @return  cell model
     */
    public Cell getCellModel() {
        return cellModel;
    }
    /**
     * Sets the button, adding its listener
     * @param button    button
     */
    public void setButton(Button button) {
        this.cellModel.setButton(button);

        ClickListener listener;

        this.cellModel.getButton().addListener(listener = new ClickListener() {
            public void clicked(InputEvent event, float x, float y){
                ShipController ship = cellModel.getBoard().getChosen();
                if(ship != null){
                    ship.update(cellModel.getBoard().getBoard(), cellModel.getX(), cellModel.getY());
                }
            }
        });

        this.cellModel.setCreateListener(listener);
    }
    /**
     * Sets the shooting listener
     * @param gController   game controller
     */
    public void setShoot(GameController gController){
        this.cellModel.setController(gController);
        me = this;

        ClickListener listener;

        this.cellModel.getButton().addListener(listener = new ClickListener() {
            public void clicked(InputEvent event, float x, float y){
                cellModel.getController().setChosen(me);
            }
        });

        cellModel.setShootListener(listener);
    }
    /**
     * Getter for the button but removing its creation listener
     * @return  button
     */
    public Button getButtonRm() {
        this.cellModel.getButton().removeListener(this.cellModel.getCreateListener());
        return this.cellModel.getButton();
    }
    /**
     * Play the sound that is played when a shot is executed
     */
    private void playCannonSound() {
        Sound cannon = BattleShip.getInstance().getAssetManager().get("cannonSound.mp3");
        cannon.play(0.5f);
    }

    /**
     * Play the sound that is played when a shot is missed
     */
    private void playSplashSound() {
        Sound cannon = BattleShip.getInstance().getAssetManager().get("waterSplash.mp3");
        cannon.play(0.5f);
    }
    /**
     * Destroy the cell, playing the shooting sound, vibrating the phone and changing its representation
     * @param user  if the user was the one who shot or if it was the bot
     * @return  if the cell had a ship or not
     */
    public boolean destroy(boolean user){
        if(this.cellModel.getShootListener() != null)
            this.cellModel.getButton().removeListener(this.cellModel.getShootListener());

        this.cellModel.setDestroyed(true);

        if(this.cellModel.getShip() != null) {
            if(user) {
                Gdx.input.vibrate(300);
                playCannonSound();
            }

            if(cellModel.getButton() != null) {
                Texture hitCellTexture = BattleShip.getInstance().getAssetManager().get("redSquare.png");
                Sprite sprite = new Sprite(hitCellTexture);
                TextureRegion hitCellTextureRegion = new TextureRegion(sprite);
                TextureRegionDrawable hitCellTextureRegionDrawable = new TextureRegionDrawable(hitCellTextureRegion);
                ImageButton.ButtonStyle style = new ImageButton.ButtonStyle(hitCellTextureRegionDrawable,hitCellTextureRegionDrawable,hitCellTextureRegionDrawable);
                this.cellModel.getButton().setStyle(style);
            }

            this.cellModel.getShip().check();

            return true;
        }

        if(cellModel.getButton() != null) {
            Texture hitCellTexture = BattleShip.getInstance().getAssetManager().get("greenSquare.png");
            Sprite sprite = new Sprite(hitCellTexture);
            TextureRegion hitCellTextureRegion = new TextureRegion(sprite);
            TextureRegionDrawable hitCellTextureRegionDrawable = new TextureRegionDrawable(hitCellTextureRegion);
            ImageButton.ButtonStyle style = new ImageButton.ButtonStyle(hitCellTextureRegionDrawable, hitCellTextureRegionDrawable, hitCellTextureRegionDrawable);
            this.cellModel.getButton().setStyle(style);
        }

        if(user)
        playSplashSound();

        return false;
    }
    /**
     * Occupy cell by a ship, changing its representation depending on the ship and on it's direction
     * @param ship      ship
     * @param index     index of the cell on the ship
     */
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

        if(this.cellModel.getButton() != null) {
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

                String file = "blueSubmarine" + Integer.toString(index + 1) + "-" + Integer.toString(rotateAngle) + ".png";
                Texture cellTexture = BattleShip.getInstance().getAssetManager().get(file);
                Sprite sprite = new Sprite(cellTexture);
                TextureRegion cellTextureRegion = new TextureRegion(sprite);
                TextureRegionDrawable cellTextureRegionDrawable = new TextureRegionDrawable(cellTextureRegion);
                ImageButton.ButtonStyle style = new ImageButton.ButtonStyle(cellTextureRegionDrawable, cellTextureRegionDrawable, cellTextureRegionDrawable);
                this.cellModel.getButton().setStyle(style);

            } else if (this.cellModel.getShip().getShipModel() instanceof Cruiser) {

                String file = "blueCruiser" + Integer.toString(index + 1) + "-" + Integer.toString(rotateAngle) + ".png";
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
    }
    /**
     * Check if the cell is occupied by a ship different than the one passed by parameter
     * @param s ship
     * @return  if it's occupied or not
     */
    public boolean occupied(ShipController s){
        return s != this.cellModel.getShip() && this.cellModel.getShip() != null;
    }
    /**
     * Free the Cell, changing its representation
     */
    public void free(){
        this.cellModel.setShip(null);

        Texture cellTexture = BattleShip.getInstance().getAssetManager().get("square.png");
        TextureRegion cellTextureRegion = new TextureRegion(cellTexture);
        TextureRegionDrawable cellTextureRegionDrawable = new TextureRegionDrawable(cellTextureRegion);
        Button.ButtonStyle style2 = new Button.ButtonStyle(cellTextureRegionDrawable,cellTextureRegionDrawable,cellTextureRegionDrawable);
        this.cellModel.getButton().setStyle(style2);
    }
}
