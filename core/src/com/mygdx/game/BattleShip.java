package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.mygdx.game.Screens.GameScreen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * BattleShip game class (singleton)
 */
public class BattleShip extends Game {
	private static BattleShip battleship;
	private AssetManager assetManager;
	public SpriteBatch batch;
	/**
	 * Creates a new game and set the current screen
	 */
	@Override
	public void create() {
		battleship = this;
		assetManager = new AssetManager();
        batch = new SpriteBatch();
		setScreen(new GameScreen());
	}
	/**
	 * Render override
	 */
	@Override
	public void render() {
		super.render();
	}
	/**
	 * Dispose Override
	 */
	@Override
	public void dispose() {
		super.dispose();
		assetManager.dispose();
		batch.dispose();
	}
	/**
	 * Getter for the game instance
	 * @return	game instance
	 */
	public static BattleShip getInstance() {
		return battleship;
	}
	/**
	 * Getter for the asset manager
	 * @return	asset manager
	 */
	AssetManager getAssetManager() {
		return assetManager;
	}
}