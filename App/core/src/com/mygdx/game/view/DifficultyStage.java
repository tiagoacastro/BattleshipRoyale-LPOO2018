package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.BattleShip;
import com.mygdx.game.controller.BoardController;
import com.mygdx.game.controller.CrazyBehaviour;
import com.mygdx.game.utility.ButtonFactory;

public class DifficultyStage extends Stage {
    private static final float VIEWPORT_WIDTH = 800;
    private float ratio;
    private BattleShip game;
    private Viewport viewport;
    private Table table;
    private BoardController userBoard;

    public enum Difficulty{EASY, HARD, CRAZY};

    DifficultyStage(BoardController board) {
        game = BattleShip.getInstance();

        this.userBoard = board;

        ratio = ((float) Gdx.graphics.getHeight() / (float) Gdx.graphics.getWidth());
        this.viewport = new FitViewport(VIEWPORT_WIDTH, VIEWPORT_WIDTH * ratio);
        viewport.apply();
        this.setViewport(this.viewport);

        Gdx.input.setInputProcessor(this);

        table = new Table();
        table.setFillParent(true);
        this.addActor(table);

        table.add().height(VIEWPORT_WIDTH*ratio/7);

        table.row();

        TextButton crazyButton = ButtonFactory.createButton("CRAZY",60);
        table.add(crazyButton).width(VIEWPORT_WIDTH/5).height(VIEWPORT_WIDTH*ratio/7).center().expand();
        crazyButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(new GameScreen(userBoard, Difficulty.CRAZY));
            }
        });

        table.row();

        table.add().height(VIEWPORT_WIDTH*ratio/7);

        table.row();

        TextButton hardButton = ButtonFactory.createButton("HARD",60);
        table.add(hardButton).width(VIEWPORT_WIDTH/5).height(VIEWPORT_WIDTH*ratio/7).center().expand();
        hardButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(new GameScreen(userBoard, Difficulty.HARD));
            }
        });

        table.row();

        table.add().height(VIEWPORT_WIDTH*ratio/7);

        table.row();

        TextButton easyButton = ButtonFactory.createButton("EASY",60);
        table.add(easyButton).width(VIEWPORT_WIDTH/5).height(VIEWPORT_WIDTH*ratio/7).center().expand();
        easyButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(new GameScreen(userBoard, Difficulty.EASY));
            }
        });

        table.row();

        table.add().height(VIEWPORT_WIDTH*ratio/7);
    }

    @Override
    public Viewport getViewport() {
        return viewport;
    }
}

