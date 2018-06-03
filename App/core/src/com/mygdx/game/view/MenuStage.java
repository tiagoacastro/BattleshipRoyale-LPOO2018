package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.BattleShip;
import com.mygdx.game.utility.ButtonFactory;
import com.mygdx.game.utility.Facebook;

/**
 * Stage for the Menu screen
 */
class MenuStage extends Stage {
    private static final float VIEWPORT_WIDTH = 800;
    private BattleShip game;
    private Viewport viewport;
    static private Music music;
    /**
     * Menu Stage constructor where the layout is all created
     */
    MenuStage() {
        game = BattleShip.getInstance();

        float ratio = ((float) Gdx.graphics.getHeight() / (float) Gdx.graphics.getWidth());
        this.viewport = new FitViewport(VIEWPORT_WIDTH, VIEWPORT_WIDTH * ratio);
        viewport.apply();
        this.setViewport(this.viewport);

        Gdx.input.setInputProcessor(this);

        Table table = new Table();
        table.setFillParent(true);
        this.addActor(table);

        table.add().height(VIEWPORT_WIDTH*ratio/2).colspan(2);

        table.row();

        TextButton playButton = ButtonFactory.createButton("PLAY",80);
        table.add(playButton).width(VIEWPORT_WIDTH/5).height(VIEWPORT_WIDTH*ratio/5).padRight(300);
        playButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(new CreatorScreen());
            }
        });

        table.row();

        music = game.getAssetManager().get("thunder.mp3");
        music.play();

        Texture soundOff = game.getAssetManager().get("soundOff.png");
        Texture soundOn = game.getAssetManager().get("soundOn.png");
        Texture facebook = game.getAssetManager().get("facebook.png");
        TextureRegion mySoundOnRegion = new TextureRegion(soundOff);
        TextureRegion mySoundOffRegion = new TextureRegion(soundOn);
        TextureRegion facebookRegion = new TextureRegion(facebook);
        TextureRegionDrawable mySoundOnRegionDrawable = new TextureRegionDrawable(mySoundOnRegion);
        TextureRegionDrawable mySoundOffRegionDrawable = new TextureRegionDrawable(mySoundOffRegion);
        TextureRegionDrawable facebookRegionDrawable = new TextureRegionDrawable(facebookRegion);

        ImageButton facebookButton = new ImageButton(facebookRegionDrawable);
        table.add(facebookButton).width(VIEWPORT_WIDTH/10).height(VIEWPORT_WIDTH*ratio/6).expand().right().bottom();
        facebookButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y){
                Facebook facebook = new Facebook();
                facebook.login();
            }
        });

        ImageButton toggleSoundButton = new ImageButton(mySoundOffRegionDrawable,mySoundOnRegionDrawable,mySoundOnRegionDrawable);
        table.add(toggleSoundButton).width(VIEWPORT_WIDTH/6).height(VIEWPORT_WIDTH*ratio/6).expand().right().bottom();
        toggleSoundButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y){
                if(music.isPlaying()) {
                    music.pause();
                }else{
                    music.play();
                }
            }
        });
        table.add().width(VIEWPORT_WIDTH/20).height(VIEWPORT_WIDTH*ratio*4/15);

        table.row();

        table.add().height(VIEWPORT_WIDTH*ratio/15).colspan(2);
    }
    /**
     * Getter for the viewport
     * @return  viewport
     */
    @Override
    public Viewport getViewport() {
        return viewport;
    }

    /**
     * stops the music
     */
    static public void stopMusic() {music.stop();}
}
