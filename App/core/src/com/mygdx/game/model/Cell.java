package com.mygdx.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.BattleShip;
import com.mygdx.game.controller.BoardController;
import com.mygdx.game.controller.GameController;
import com.mygdx.game.controller.ShipController;

import java.util.Objects;

/**
 * Ship part that creates the boats
 */
public class Cell {
    private ShipController ship = null;
    private int column;
    private int line;
    private boolean destroyed = false;
    private TextButton button;
    private Button button2;
    private BoardController board;
    private ClickListener createListener;
    private ClickListener shootListener = null;
    private GameController controller;
    private Cell me;

    Cell(int x, int y, BoardController board){
        this.column = x;
        this.line = y;
        this.board = board;
    }

    public boolean occupied(ShipController s){
        return s != ship && ship != null;
    }

    public void free(){
        this.ship = null;
        button.setText("c");

        Texture cellTexture = BattleShip.getInstance().getAssetManager().get("square.png");
        TextureRegion cellTextureRegion = new TextureRegion(cellTexture);
        TextureRegionDrawable cellTextureRegionDrawable = new TextureRegionDrawable(cellTextureRegion);
        Button.ButtonStyle style2 = new Button.ButtonStyle(cellTextureRegionDrawable,cellTextureRegionDrawable,cellTextureRegionDrawable);
        this.button2.setStyle(style2);
    }

    public void occupy(ShipController ship, int index) {
        this.ship = ship;

        int rotateAngle = 0;

        switch (this.ship.getShipModel().getWay()) {
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

        if (this.ship.getShipModel() instanceof Carrier) {
            this.button.setText("5");

            String file = "blueCarrier" + Integer.toString(index + 1) + "-" + Integer.toString(rotateAngle) + ".png";
            Texture cellTexture = BattleShip.getInstance().getAssetManager().get(file);
            Sprite sprite = new Sprite(cellTexture);
            TextureRegion cellTextureRegion = new TextureRegion(sprite);
            TextureRegionDrawable cellTextureRegionDrawable = new TextureRegionDrawable(cellTextureRegion);
            ImageButton.ButtonStyle style = new ImageButton.ButtonStyle(cellTextureRegionDrawable, cellTextureRegionDrawable, cellTextureRegionDrawable);
            this.button2.setStyle(style);

        } else if (this.ship.getShipModel() instanceof Dreadnought) {
            this.button.setText("4");

            String file = "blueDreadnought" + Integer.toString(index + 1) + "-" + Integer.toString(rotateAngle) + ".png";
            Texture cellTexture = BattleShip.getInstance().getAssetManager().get(file);
            Sprite sprite = new Sprite(cellTexture);
            TextureRegion cellTextureRegion = new TextureRegion(sprite);
            TextureRegionDrawable cellTextureRegionDrawable = new TextureRegionDrawable(cellTextureRegion);
            ImageButton.ButtonStyle style = new ImageButton.ButtonStyle(cellTextureRegionDrawable, cellTextureRegionDrawable, cellTextureRegionDrawable);
            this.button2.setStyle(style);
        } else if (this.ship.getShipModel() instanceof Submarine) {
            this.button.setText("3");

            String file = "blueSubmarine" + Integer.toString(index + 1) + "-" + Integer.toString(rotateAngle) + ".png";;
            Texture cellTexture = BattleShip.getInstance().getAssetManager().get(file);
            Sprite sprite = new Sprite(cellTexture);
            TextureRegion cellTextureRegion = new TextureRegion(sprite);
            TextureRegionDrawable cellTextureRegionDrawable = new TextureRegionDrawable(cellTextureRegion);
            ImageButton.ButtonStyle style = new ImageButton.ButtonStyle(cellTextureRegionDrawable, cellTextureRegionDrawable, cellTextureRegionDrawable);
            this.button2.setStyle(style);
        } else if (this.ship.getShipModel() instanceof Cruiser) {
            this.button.setText("2");

            String file = "blueCruiser" + Integer.toString(index + 1) + "-" + Integer.toString(rotateAngle) + ".png";;
            Texture cellTexture = BattleShip.getInstance().getAssetManager().get(file);
            Sprite sprite = new Sprite(cellTexture);
            TextureRegion cellTextureRegion = new TextureRegion(sprite);
            TextureRegionDrawable cellTextureRegionDrawable = new TextureRegionDrawable(cellTextureRegion);
            ImageButton.ButtonStyle style = new ImageButton.ButtonStyle(cellTextureRegionDrawable, cellTextureRegionDrawable, cellTextureRegionDrawable);
            this.button2.setStyle(style);
        } else if (this.ship.getShipModel() instanceof PatrolBoat) {
            this.button.setText("1");

            String file = "bluePatrolBoat" + Integer.toString(index + 1) + "-" + Integer.toString(rotateAngle) + ".png";
            Texture cellTexture = BattleShip.getInstance().getAssetManager().get(file);
            Sprite sprite = new Sprite(cellTexture);
            TextureRegion cellTextureRegion = new TextureRegion(sprite);
            TextureRegionDrawable cellTextureRegionDrawable = new TextureRegionDrawable(cellTextureRegion);
            ImageButton.ButtonStyle style = new ImageButton.ButtonStyle(cellTextureRegionDrawable, cellTextureRegionDrawable, cellTextureRegionDrawable);
            this.button2.setStyle(style);
        }
    }

    public boolean destroy(){
        if(shootListener != null)
            this.button.removeListener(shootListener);

        if(ship != null) {
            this.destroyed = true;
            playCannonSound();
            this.button.setText("*");

            Texture hitCellTexture = BattleShip.getInstance().getAssetManager().get("redSquare.png");
            Sprite sprite = new Sprite(hitCellTexture);
            TextureRegion hitCellTextureRegion = new TextureRegion(sprite);
            TextureRegionDrawable hitCellTextureRegionDrawable = new TextureRegionDrawable(hitCellTextureRegion);
            ImageButton.ButtonStyle style = new ImageButton.ButtonStyle(hitCellTextureRegionDrawable,hitCellTextureRegionDrawable,hitCellTextureRegionDrawable);
            this.button2.setStyle(style);

            this.ship.check();

            return true;
        }

        this.button.setText("X");

        Texture hitCellTexture = BattleShip.getInstance().getAssetManager().get("greenSquare.png");
        Sprite sprite = new Sprite(hitCellTexture);
        TextureRegion hitCellTextureRegion = new TextureRegion(sprite);
        TextureRegionDrawable hitCellTextureRegionDrawable = new TextureRegionDrawable(hitCellTextureRegion);
        ImageButton.ButtonStyle style = new ImageButton.ButtonStyle(hitCellTextureRegionDrawable,hitCellTextureRegionDrawable,hitCellTextureRegionDrawable);
        this.button2.setStyle(style);

        return false;
    }

    private void playCannonSound() {

        Sound cannon = BattleShip.getInstance().getAssetManager().get("cannonSound.mp3");
        cannon.play();
    }

    public boolean check(){
        return destroyed;
    }

    public void setX(int x) {
        this.column = x;
    }

    public void setY(int y) {
        this.line = y;
    }

    public int getX() {
        return column;
    }

    public int getY() {
        return line;
    }

    public TextButton getButtonRm() {
        this.button.removeListener(createListener);
        return button;
    }

    public TextButton getButton() {
        return button;
    }

    public Button getButton2() {
        this.button.removeListener(createListener);
        return button2;
    }

    public void setButton(TextButton button) {
        this.button = button;

        this.button.addListener(createListener = new ClickListener() {
            public void clicked(InputEvent event, float x, float y){
                ShipController ship = board.getChosen();
                if(ship != null){
                    ship.update(board.getBoard(), column, line);
                }
            }
        });
    }

    public void setButton(Button button) {
        this.button2 = button;

        this.button2.addListener(createListener = new ClickListener() {
            public void clicked(InputEvent event, float x, float y){
                ShipController ship = board.getChosen();
                if(ship != null){
                    ship.update(board.getBoard(), column, line);
                }
            }
        });
    }

    public void setShoot(GameController gController){
        this.controller = gController;
        me = this;

        button.addListener(shootListener = new ClickListener() {
            public void clicked(InputEvent event, float x, float y){
                controller.setChosen(me);
            }
        });
    }
}
