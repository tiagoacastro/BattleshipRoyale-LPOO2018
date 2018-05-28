package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.BattleShip;

class MenuStage extends Stage {
    private static final float VIEWPORT_WIDTH = 800;
    private float ratio;
    private BattleShip game;
    private Viewport viewport;
    private Table table;
    private Music music;

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
        table.add(title).height(VIEWPORT_WIDTH*ratio*2/9).center().colspan(2);

        table.row();

        table.add().height(VIEWPORT_WIDTH*ratio/9).colspan(2);

        table.row();

        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = new BitmapFont();

        Texture playTexture = game.getAssetManager().get("playButton.png");
        TextureRegion playTextureRegion = new TextureRegion(playTexture);
        TextureRegionDrawable playTextureRegionDrawable = new TextureRegionDrawable(playTextureRegion);

        ImageButton playButton = new ImageButton(playTextureRegionDrawable); //Set the button up
        table.add(playButton).width(VIEWPORT_WIDTH/5).height(VIEWPORT_WIDTH*ratio/5).expand().center().bottom().colspan(2);
        playButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(new CreatorScreen());
            }
        });

        table.row();

        music = game.getAssetManager().get("thunder.mp3");
        music.play();

        TextButton toggleButton = new TextButton("Toggle Music", style);
        table.add(toggleButton).width(VIEWPORT_WIDTH/6).height(VIEWPORT_WIDTH*ratio/6).expand().right().bottom();
        toggleButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y){
                if(music.isPlaying()) {
                    music.stop();
                }else{
                    music.play();
                }
            }
        });
        table.add().width(VIEWPORT_WIDTH/20).height(VIEWPORT_WIDTH*ratio*4/15);

        table.row();

        table.add().height(VIEWPORT_WIDTH*ratio/15).colspan(2);
    }

    @Override
    public Viewport getViewport() {
        return viewport;
    }
}
