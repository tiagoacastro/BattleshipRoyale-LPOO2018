package com.mygdx.game;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

/**
 * Launcher for android
 */
public class AndroidLauncher extends AndroidApplication {
	/**
	 * starts the game
	 */
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		config.useGyroscope =  true;
		config.useAccelerometer = false;
		config.useCompass = false;
		initialize(new BattleShip(), config);
	}
}
