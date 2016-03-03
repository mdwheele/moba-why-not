package com.mdwheele.moba;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.squareup.otto.ThreadEnforcer;

/**
 * This class forms the entry point for our game. It is adapted per-platform
 * by android, desktop and html projects. It should be limited to dealing with
 * transitions between high-level screens. It should not have game logic in it.
 */
public class MobaGame extends ApplicationAdapter {

	Bus bus;

	@Override
	public void create () {
		bus = new Bus(ThreadEnforcer.ANY);
		bus.register(this);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		bus.post(new ChatMessageReceived());
	}

	@Subscribe
	public void doSomething(ChatMessageReceived event) {
		Gdx.app.log("DEMO", event.getMessage());
	}

}
