package com.mdwheele.moba.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mdwheele.moba.MobaGame;
import com.mdwheele.moba.Settings;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		// @TODO Settings should be pulled from preferences. Statics aren't gonna cut it. But
		// @TODO damn it looks good.
		config.width = Settings.WINDOW_WIDTH;
		config.height = Settings.WINDOW_HEIGHT;
		config.foregroundFPS = Settings.MAX_FPS;
		config.backgroundFPS = Settings.MAX_FPS;
		config.vSyncEnabled = Settings.VSYNC;

		new LwjglApplication(new MobaGame(), config);
	}
}
