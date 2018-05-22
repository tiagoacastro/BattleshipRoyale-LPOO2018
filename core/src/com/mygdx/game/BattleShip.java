package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.view.MenuScreen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * BattleShip game class (singleton)
 */
public class BattleShip extends Game {
	public final float VIEWPORT_WIDTH = 30;
	public final float PIXEL_TO_METER = 0.04f;
	public float ratio;
	private static BattleShip battleship;
	private AssetManager assetManager;
	private SpriteBatch batch;
	private BattleShip game;
	private Viewport viewport;
	/**
	 * Creates a new game and set the current screen
	 */
	@Override
	public void create() {
		battleship = this;
		ratio = ((float) Gdx.graphics.getHeight() / (float) Gdx.graphics.getWidth());
		this.viewport = new FitViewport(VIEWPORT_WIDTH, VIEWPORT_WIDTH * ratio);
		assetManager = new AssetManager();
        batch = new SpriteBatch();
		setScreen(new MenuScreen());
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
	public AssetManager getAssetManager() {
		return assetManager;
	}
	/**
	 * Getter for the sprite batch
	 * @return	sprite batch
	 */
	public SpriteBatch getBatch() {
		return batch;
	}

	/**
	 * Getter for the viewport
	 * @return	viewport
	 */
	public Viewport getViewport() {
		return viewport;
	}
}