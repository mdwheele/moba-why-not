package com.mdwheele.moba;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

/**
 * This class forms the entry point for our game. It is adapted per-platform
 * by android, desktop and html projects. It should be limited to dealing with
 * transitions between high-level screens. It should not have game logic in it.
 */
public class MobaGame extends ApplicationAdapter {

	@Override
	public void create () {
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}

}
