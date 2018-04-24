package com.mygdx.game;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;

/**
 * BattleShip game class (singleton)
 */
public class BattleShip extends Game {
	private static BattleShip battleship = new BattleShip();
	private AssetManager assetManager;
	/**
	 * Creates a new game and set the current screen
	 */
	@Override
	public void create() {
		assetManager = new AssetManager();

		setScreen(new GameScreen());
	}

	/**
	 * Dispose Override
	 */
	@Override
	public void dispose(){
		battleship.dispose();
		assetManager.dispose();
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