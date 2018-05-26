package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
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

public class SettingsStage extends Stage {
    private final float VIEWPORT_WIDTH = 800;
    private final float PIXEL_TO_METER = 0.04f;
    private float ratio;
    private BattleShip game;
    private TextButton toggleButton;
    private TextButton backButton;
    private Viewport viewport;
    private Table table;
    private Music music;

    SettingsStage(Music music) {
        game = BattleShip.getInstance();
        this.music = music;

        ratio = ((float) Gdx.graphics.getHeight() / (float) Gdx.graphics.getWidth());
        this.viewport = new FitViewport(VIEWPORT_WIDTH, VIEWPORT_WIDTH * ratio);
        viewport.apply();
        this.setViewport(this.viewport);

        Gdx.input.setInputProcessor(this);

        table = new Table();
        table.setFillParent(true);
        this.addActor(table);

        Label title = new Label("Settings", new Label.LabelStyle(new BitmapFont(), null));
        title.setColor(Color.BLACK);
        table.add(title).height(VIEWPORT_WIDTH * ratio / 3).colspan(2).center();

        table.row();

        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = new BitmapFont();

        toggleButton = new TextButton("Toggle Music", style);
        table.add(toggleButton).width(VIEWPORT_WIDTH / 5).height(VIEWPORT_WIDTH * ratio / 5).expand();
        toggleButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new CreatorScreen());
            }
        });

        backButton = new TextButton("Back", style);
        table.add(backButton).width(VIEWPORT_WIDTH / 5).height(VIEWPORT_WIDTH * ratio / 5).expand();
        backButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                
            }
        });

        table.row();

        table.add().height(VIEWPORT_WIDTH * ratio / 3).colspan(2);
    }

    @Override
    public Viewport getViewport() {
        return viewport;
    }
}
