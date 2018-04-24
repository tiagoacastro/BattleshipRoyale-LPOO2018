package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.BattleShip;

/**
 * Launcher for Desktop
 */
public class DesktopLauncher {

	/**
	 * main function
	 * @param arg	arguments
	 */
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new BattleShip(), config);
	}
}
