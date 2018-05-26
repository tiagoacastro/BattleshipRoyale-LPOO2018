package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.BattleShip;

class MenuStage extends Stage {
    private final float VIEWPORT_WIDTH = 800;
    private final float PIXEL_TO_METER = 0.04f;
    private float ratio;
    private BattleShip game;
    private TextButton playButton;
    private TextButton settingsButton;
    private Viewport viewport;
    private Table table;

    MenuStage() {
        game = BattleShip.getInstance();

        ratio = ((float) Gdx.graphics.getHeight() / (float) Gdx.graphics.getWidth());
        this.viewport = new FitViewport(VIEWPORT_WIDTH, VIEWPORT_WIDTH * ratio);
        viewport.apply();
        this.setViewport(this.viewport);

        Gdx.input.setInputProcessor(this);

        table = new Table();
        table.setFillParent(true);
        this.addActor(table);

        Label title = new Label("Battleship Royale", new Label.LabelStyle(new BitmapFont(), null));
        title.setColor(Color.BLACK);
        table.add(title).height(VIEWPORT_WIDTH*ratio/3).colspan(2).center();

        table.row();

        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = new BitmapFont();

        playButton = new TextButton("play", style);
        table.add(playButton).width(VIEWPORT_WIDTH/5).height(VIEWPORT_WIDTH*ratio/5).expand();
        playButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(new CreatorScreen());
            }
        });

        settingsButton = new TextButton("settings", style);
        table.add(settingsButton).width(VIEWPORT_WIDTH/5).height(VIEWPORT_WIDTH*ratio/5).expand();
        settingsButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y){
                //depois mete-se
            }
        });

        table.row();

        table.add().height(VIEWPORT_WIDTH*ratio/3).colspan(2);

        Music thunder = game.getAssetManager().get("thunder.mp3");
        thunder.play();
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
