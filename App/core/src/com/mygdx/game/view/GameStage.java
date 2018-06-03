package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.BattleShip;
import com.mygdx.game.controller.BoardController;
import com.mygdx.game.controller.CrazyBehaviour;
import com.mygdx.game.controller.EasyBehaviour;
import com.mygdx.game.controller.HardBehaviour;
import com.mygdx.game.controller.GameController;
import com.mygdx.game.utility.ButtonFactory;

/**
 * Stage for the game screen
 */
public class GameStage extends Stage {
    private static final float VIEWPORT_WIDTH = 800;
    private static final int BOARD_SIZE = 10;
    private float ratio;
    private BattleShip game;
    private Viewport viewport;
    private GameController controller;
    private Table userBoardTable;
    private Table botStatus;
    private boolean toggleBoard = false;
    private Button carrier;
    private Button cruiser;
    private Button patrolBoat;
    private Button submarine;
    private Button dreadnought;
    private static Music music;
    /**
     * Game stage constructor where the basic stage setup is done and the table creators are called
     * @param board         user's board
     * @param difficulty    game difficulty
     */
    GameStage(BoardController board, DifficultyStage.Difficulty difficulty) {
        game = BattleShip.getInstance();

        this.setController(board, difficulty);

        ratio = ((float) Gdx.graphics.getHeight() / (float) Gdx.graphics.getWidth());
        this.viewport = new FitViewport(VIEWPORT_WIDTH, VIEWPORT_WIDTH * ratio);
        viewport.apply();
        this.setViewport(this.viewport);

        Gdx.input.setInputProcessor(this);

        this.drawUserBoard();

        this.drawBotBoard();

        this.drawHUD();

        this.drawBotStatusHUD();
    }

    /**
     * Hides the bot's ships
     */
    private void hideBotShips() {

        for(int y = 0; y < BOARD_SIZE; y++){
            for(int x = 0; x < BOARD_SIZE; x++){

                Texture cellTexture = game.getAssetManager().get("square.png");
                TextureRegion cellTextureRegion = new TextureRegion(cellTexture);
                TextureRegionDrawable cellTextureRegionDrawable = new TextureRegionDrawable(cellTextureRegion);
                Button.ButtonStyle style2 = new Button.ButtonStyle(cellTextureRegionDrawable,cellTextureRegionDrawable,cellTextureRegionDrawable);
                Button cellButton = new Button(); //Set the button up
                cellButton.setStyle(style2);

                this.controller.getBotBoard().getBoard().getMatrix()[y][x].setButton(cellButton);
            }
        }

    }

    /**
     * creates ship buttons with no listener just to show which ships the user still needs to destroy
     * @param i
     */
    private void createShipButton(int i) {
        switch (i) {
            case 0:
                Texture myCarrier = game.getAssetManager().get("carrier.png");
                TextureRegion myCarrierRegion = new TextureRegion(myCarrier);
                TextureRegionDrawable myCarrierRegionDrawable = new TextureRegionDrawable(myCarrierRegion);
                Button.ButtonStyle style = new Button.ButtonStyle(myCarrierRegionDrawable,myCarrierRegionDrawable,myCarrierRegionDrawable);
                carrier = new Button(); //Set the button up
                carrier.setStyle(style);
                botStatus.add(carrier).width(VIEWPORT_WIDTH/5).height(12*VIEWPORT_WIDTH * ratio / 80).center();
                break;
            case 1:
                Texture myDreadnought = game.getAssetManager().get("dreadnought.png");
                TextureRegion myDreadnoughtRegion = new TextureRegion(myDreadnought);
                TextureRegionDrawable myDreadnoughtRegionDrawable = new TextureRegionDrawable(myDreadnoughtRegion);
                Button.ButtonStyle style2 = new Button.ButtonStyle(myDreadnoughtRegionDrawable,myDreadnoughtRegionDrawable,myDreadnoughtRegionDrawable);
                dreadnought = new Button(); //Set the button up
                dreadnought.setStyle(style2);
                botStatus.add(dreadnought).width(VIEWPORT_WIDTH/5).height(5*VIEWPORT_WIDTH * ratio / 80).center();
                break;
            case 2:
                Texture mySubmarine = game.getAssetManager().get("submarine.png");
                TextureRegion mySubmarineRegion = new TextureRegion(mySubmarine);
                TextureRegionDrawable mySubmarineRegionDrawable = new TextureRegionDrawable(mySubmarineRegion);
                Button.ButtonStyle style3 = new Button.ButtonStyle(mySubmarineRegionDrawable,mySubmarineRegionDrawable,mySubmarineRegionDrawable);
                submarine = new Button(); //Set the button up
                submarine.setStyle(style3);
                botStatus.add(submarine).width(VIEWPORT_WIDTH/5).height(8*VIEWPORT_WIDTH * ratio / 80).center();
                break;
            case 3:
                Texture myCruiser = game.getAssetManager().get("cruiser.png");
                TextureRegion myCruiserRegion = new TextureRegion(myCruiser);
                TextureRegionDrawable myCruiserRegionDrawable = new TextureRegionDrawable(myCruiserRegion);
                Button.ButtonStyle style4 = new Button.ButtonStyle(myCruiserRegionDrawable,myCruiserRegionDrawable,myCruiserRegionDrawable);
                cruiser = new Button(); //Set the button up
                cruiser.setStyle(style4);
                botStatus.add(cruiser).width(VIEWPORT_WIDTH/5).height(6*VIEWPORT_WIDTH * ratio / 80).center();
                break;
            case 4:
                Texture myPatrolBoat = game.getAssetManager().get("patrolBoat.png");
                TextureRegion myPatrolBoatRegion = new TextureRegion(myPatrolBoat);
                TextureRegionDrawable myPatrolBoatRegionDrawable = new TextureRegionDrawable(myPatrolBoatRegion);
                Button.ButtonStyle style5 = new Button.ButtonStyle(myPatrolBoatRegionDrawable,myPatrolBoatRegionDrawable,myPatrolBoatRegionDrawable);
                patrolBoat = new Button(); //Set the button up
                patrolBoat.setStyle(style5);
                botStatus.add(patrolBoat).width(VIEWPORT_WIDTH/5).height(6*VIEWPORT_WIDTH * ratio / 80).center();
                break;
        }
    }

    /**
     * Draws bot's to be destroyed
     */
    private void drawBotStatusHUD(){
        botStatus = new Table();
        botStatus.setFillParent(true);
        this.addActor(botStatus);
        botStatus.setVisible(true);

        botStatus.add().height(VIEWPORT_WIDTH*ratio/20).colspan(12);

        botStatus.row();

        for (int i = 0; i < 5; i++) {
            createShipButton(i);

            botStatus.add().width(VIEWPORT_WIDTH / 2).height(10*VIEWPORT_WIDTH * ratio / 108);

            botStatus.row();

            if(i != 4) {
                botStatus.add().width(VIEWPORT_WIDTH).height(5 * VIEWPORT_WIDTH * ratio / 108).colspan(2);

                botStatus.row();
            }
        }
    }

    /**
     * Draws user's board
     */
    private void drawUserBoard(){
        userBoardTable = new Table();
        userBoardTable.setFillParent(true);
        this.addActor(userBoardTable);
        userBoardTable.setVisible(false);

        userBoardTable.add().height(VIEWPORT_WIDTH*ratio/12).colspan(12);

        userBoardTable.row();

        for(int y = 0; y < BOARD_SIZE; y++){

            userBoardTable.add().width(VIEWPORT_WIDTH/24);

            for(int x = 0; x < BOARD_SIZE; x++){
                userBoardTable.add(controller.getUserBoard().getBoard().getMatrix()[y][x].getButtonRm()).width(VIEWPORT_WIDTH/24).height(VIEWPORT_WIDTH*ratio/12);
            }

            userBoardTable.add().width(13*VIEWPORT_WIDTH/24);

            userBoardTable.row();
        }

        userBoardTable.add().height(VIEWPORT_WIDTH*ratio/12).colspan(12);
    }

    /**
     * Draws the bot's board
     */
    private void drawBotBoard(){
        Table botBoardTable = new Table();
        botBoardTable.setFillParent(true);
        this.addActor(botBoardTable);

        botBoardTable.add().height(VIEWPORT_WIDTH*ratio/12).colspan(12);

        botBoardTable.row();

        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = new BitmapFont();

        for(int y = 0; y < BOARD_SIZE; y++){
            for(int x = 0; x < BOARD_SIZE; x++){

                Texture cellTexture = game.getAssetManager().get("square.png");
                TextureRegion cellTextureRegion = new TextureRegion(cellTexture);
                TextureRegionDrawable cellTextureRegionDrawable = new TextureRegionDrawable(cellTextureRegion);
                Button.ButtonStyle style2 = new Button.ButtonStyle(cellTextureRegionDrawable,cellTextureRegionDrawable,cellTextureRegionDrawable);
                Button cellButton = new Button(); //Set the button up
                cellButton.setStyle(style2);
                this.controller.getBotBoard().getBoard().getMatrix()[y][x].setButton(cellButton);
            }
        }

        this.controller.getBotBoard().populate();

        this.hideBotShips();

        for(int y = 0; y < BOARD_SIZE; y++){

            botBoardTable.add().width(13*VIEWPORT_WIDTH/24);

            for(int x = 0; x < BOARD_SIZE; x++){
                botBoardTable.add(this.controller.getBotBoard().getBoard().getMatrix()[y][x].getButtonRm()).width(VIEWPORT_WIDTH/24).height(VIEWPORT_WIDTH*ratio/12);
                this.controller.getBotBoard().getBoard().getMatrix()[y][x].setShoot(controller);
            }
            botBoardTable.add().width(VIEWPORT_WIDTH/24);

            botBoardTable.row();
        }

        botBoardTable.add().height(VIEWPORT_WIDTH*ratio/12).colspan(12);
    }
    /**
     * Draw's the game HUD
     */
    private void drawHUD(){
        Table guiTable = new Table();
        guiTable.setFillParent(true);
        this.addActor(guiTable);

        music = game.getAssetManager().get("pirates.mp3");
        music.setLooping(true);
        music.play();
        music.setVolume(0.3f);

        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = new BitmapFont();

        guiTable.add().height(6*VIEWPORT_WIDTH*ratio/12).colspan(2);

        guiTable.row();

        guiTable.add().width(VIEWPORT_WIDTH/2);

        TextButton button = ButtonFactory.createButton("Toggle my board", 20);
        button.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y){
                Sound sound = game.getAssetManager().get("buttonSound.mp3");
                sound.play(0.2f);
                if(toggleBoard) {
                    userBoardTable.setVisible(false);
                    botStatus.setVisible(true);
                    toggleBoard = false;
                }else {
                    userBoardTable.setVisible(true);
                    botStatus.setVisible(false);
                    toggleBoard = true;
                }
            }
        });
        guiTable.add(button).width(VIEWPORT_WIDTH/4).expand().center().bottom();

        Texture soundOff = game.getAssetManager().get("soundOff.png");
        Texture soundOn = game.getAssetManager().get("soundOn.png");
        TextureRegion mySoundOnRegion = new TextureRegion(soundOff);
        TextureRegion mySoundOffRegion = new TextureRegion(soundOn);
        TextureRegionDrawable mySoundOnRegionDrawable = new TextureRegionDrawable(mySoundOnRegion);
        TextureRegionDrawable mySoundOffRegionDrawable = new TextureRegionDrawable(mySoundOffRegion);
        ImageButton toggleSoundButton = new ImageButton(mySoundOffRegionDrawable,mySoundOnRegionDrawable,mySoundOnRegionDrawable);
        guiTable.add(toggleSoundButton).width(VIEWPORT_WIDTH/8).height(VIEWPORT_WIDTH*ratio/14).expand().center().bottom();
        toggleSoundButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y){
                Sound sound = game.getAssetManager().get("buttonSound.mp3");
                sound.play(0.2f);
                if(music.isPlaying()) {
                    music.pause();
                }else{
                    music.play();
                }
            }
        });

        Table auxTable = new Table();
        auxTable.setFillParent(true);
        this.addActor(auxTable);

        TextButton myBoard = ButtonFactory.createButton("My Board", 20);

        auxTable.add(myBoard).width(VIEWPORT_WIDTH / 4).height(VIEWPORT_WIDTH*ratio/12).expand().center().top();

        TextButton botsBoard = ButtonFactory.createButton("Bot's Board", 20);

        auxTable.add(botsBoard).width(VIEWPORT_WIDTH / 4).height(VIEWPORT_WIDTH*ratio/12).expand().center().top();

    }
    /**
     * act Override with gyroscope input
     */
    @Override
    public void act() {
        super.act();

        boolean gyroscopeAvail = Gdx.input.isPeripheralAvailable(Input.Peripheral.Gyroscope);

        if(gyroscopeAvail) {
            float gyroY = Gdx.input.getGyroscopeY();
            if (gyroY >= 5) {
                controller.shoot();
            }
        }else
            controller.shoot();
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
     * Setter for the game controller which receives a difficulty and applys it to it
     * @param board         board
     * @param difficulty    difficulty
     */
    private void setController(BoardController board, DifficultyStage.Difficulty difficulty){
        switch (difficulty){
            case EASY:
                this.controller = new GameController(board, new EasyBehaviour(),this);
                break;
            case HARD:
                this.controller = new GameController(board, new HardBehaviour(),this);
                break;
            case CRAZY:
                this.controller = new GameController(board, new CrazyBehaviour(),this);
                break;
        }
    }

    /**
     * Sets the carrier sprite to the destroyed one upon user destruction
     */
    public void setCarrierDestroyed() {
        Texture hitCellTexture = BattleShip.getInstance().getAssetManager().get("destroyedCarrier.png");
        Sprite sprite = new Sprite(hitCellTexture);
        TextureRegion hitCellTextureRegion = new TextureRegion(sprite);
        TextureRegionDrawable hitCellTextureRegionDrawable = new TextureRegionDrawable(hitCellTextureRegion);
        ImageButton.ButtonStyle style = new ImageButton.ButtonStyle(hitCellTextureRegionDrawable,hitCellTextureRegionDrawable,hitCellTextureRegionDrawable);
        this.carrier.setStyle(style);
    }
    /**
     * Sets the cruiser sprite to the destroyed one upon user destruction
     */
    public void setCruiserDestroyed() {
        Texture hitCellTexture = BattleShip.getInstance().getAssetManager().get("destroyedCruiser.png");
        Sprite sprite = new Sprite(hitCellTexture);
        TextureRegion hitCellTextureRegion = new TextureRegion(sprite);
        TextureRegionDrawable hitCellTextureRegionDrawable = new TextureRegionDrawable(hitCellTextureRegion);
        ImageButton.ButtonStyle style = new ImageButton.ButtonStyle(hitCellTextureRegionDrawable,hitCellTextureRegionDrawable,hitCellTextureRegionDrawable);
        this.cruiser.setStyle(style);
    }
    /**
     * Sets the patrolBoat sprite to the destroyed one upon user destruction
     */
    public void setPatrolBoatDestroyed() {
        Texture hitCellTexture = BattleShip.getInstance().getAssetManager().get("destroyedPatrolBoat.png");
        Sprite sprite = new Sprite(hitCellTexture);
        TextureRegion hitCellTextureRegion = new TextureRegion(sprite);
        TextureRegionDrawable hitCellTextureRegionDrawable = new TextureRegionDrawable(hitCellTextureRegion);
        ImageButton.ButtonStyle style = new ImageButton.ButtonStyle(hitCellTextureRegionDrawable,hitCellTextureRegionDrawable,hitCellTextureRegionDrawable);
        this.patrolBoat.setStyle(style);
    }
    /**
     * Sets the submarine sprite to the destroyed one upon user destruction
     */
    public void setSubmarineDestroyed() {
        Texture hitCellTexture = BattleShip.getInstance().getAssetManager().get("destroyedSubmarine.png");
        Sprite sprite = new Sprite(hitCellTexture);
        TextureRegion hitCellTextureRegion = new TextureRegion(sprite);
        TextureRegionDrawable hitCellTextureRegionDrawable = new TextureRegionDrawable(hitCellTextureRegion);
        ImageButton.ButtonStyle style = new ImageButton.ButtonStyle(hitCellTextureRegionDrawable,hitCellTextureRegionDrawable,hitCellTextureRegionDrawable);
        this.submarine.setStyle(style);
    }
    /**
     * Sets the dreadnought sprite to the destroyed one upon user destruction
     */
    public void setDreadnoughtDestroyed() {
        Texture hitCellTexture = BattleShip.getInstance().getAssetManager().get("destroyedDreadnought.png");
        Sprite sprite = new Sprite(hitCellTexture);
        TextureRegion hitCellTextureRegion = new TextureRegion(sprite);
        TextureRegionDrawable hitCellTextureRegionDrawable = new TextureRegionDrawable(hitCellTextureRegion);
        ImageButton.ButtonStyle style = new ImageButton.ButtonStyle(hitCellTextureRegionDrawable,hitCellTextureRegionDrawable,hitCellTextureRegionDrawable);
        this.dreadnought.setStyle(style);
    }

    /**
     * stops the music
     */
    static public void stopMusic() {music.stop();}
}
