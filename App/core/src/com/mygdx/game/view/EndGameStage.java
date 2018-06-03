package com.mygdx.game.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.BattleShip;
import com.mygdx.game.controller.GameController;
import com.mygdx.game.utility.ButtonFactory;

/**
 * Stage for the EndGameScreen
 */
public class EndGameStage extends Stage {
    private static final float VIEWPORT_WIDTH = 800;
    private Viewport viewport;
    /**
     * EndGameStage constructor where the layout is set up
     * @param status    WIN or LOSE
     */
    EndGameStage(GameController.State status) {
        float ratio = ((float) Gdx.graphics.getHeight() / (float) Gdx.graphics.getWidth());
        this.viewport = new FitViewport(VIEWPORT_WIDTH, VIEWPORT_WIDTH * ratio);
        viewport.apply();
        this.setViewport(this.viewport);

        Gdx.input.setInputProcessor(this);

        Table table = new Table();
        table.setFillParent(true);
        this.addActor(table);

        table.row();

        TextButton statusField = null;
        switch(status) {
            case WIN:
                statusField = ButtonFactory.createButton("YOU WON",80);
                break;
            case LOSE:
                statusField = ButtonFactory.createButton("YOU LOST",80);
                break;
        }
        table.add(statusField).width(VIEWPORT_WIDTH/5).height(VIEWPORT_WIDTH*ratio/5);

        table.row();

        TextButton tapInfo = ButtonFactory.createButton("TAP THE SCREEN TO PLAY AGAIN",30);
        table.add(tapInfo).width(VIEWPORT_WIDTH/5).height(VIEWPORT_WIDTH*ratio/5);

        this.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y){
                GameStage.stopMusic();
                Sound sound = BattleShip.getInstance().getAssetManager().get("buttonSound.mp3");
                sound.play(0.2f);
                BattleShip.getInstance().setScreen(new MenuScreen());
            }
        });
    }
    /**
     * Getter for the viewport
     * @return  viewport
     */
    @Override
    public Viewport getViewport() {
        return viewport;
    }
}
