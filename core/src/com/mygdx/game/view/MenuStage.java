package com.mygdx.game.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;


import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.BattleShip;

class MenuStage extends Stage {
    private BattleShip game;
    private ImageButton playButton;
    //private Table table;

    MenuStage() {
        game = BattleShip.getInstance();
        setViewport(this.game.getViewport());
        //table = new Table();

        //BitmapFont font = new BitmapFont();
        Texture buttonTexture = this.game.getAssetManager().get("black.jpg");
        Drawable black = new TextureRegionDrawable(new TextureRegion(buttonTexture));

        /*TextButtonStyle textButtonStyle = new TextButtonStyle();
        textButtonStyle.font = font;
        textButtonStyle.up = black;
        textButtonStyle.down = black;
        textButtonStyle.checked = black;*/

        playButton = new ImageButton(black);
        //playButton.setPosition(20, 20);
        //playButton.setSize(10, 5);
        //table.add(playButton);
        addActor(playButton);
        //addActor(table);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

    }

    @Override
    public void draw() {
        super.draw();
    }
}
