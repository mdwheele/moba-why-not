package com.mdwheele.moba.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mdwheele.moba.MobaGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.width = 1280;
		config.height = 720;
		config.foregroundFPS = 0;
		config.backgroundFPS = 0;
		config.vSyncEnabled = false;

		new LwjglApplication(new MobaGame(), config);
	}
}
