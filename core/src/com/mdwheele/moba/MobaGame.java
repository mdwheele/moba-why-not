package com.mdwheele.moba;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.squareup.otto.ThreadEnforcer;

import java.io.IOException;

/**
 * This class forms the entry point for our game. It is adapted per-platform
 * by android, desktop and html projects. It should be limited to dealing with
 * transitions between high-level screens. It should not have game logic in it.
 */
public class MobaGame extends ApplicationAdapter {

	Bus bus;
	Server server;
	Client client;

	@Override
	public void create () {
		bus = new Bus(ThreadEnforcer.ANY);
		bus.register(this);

		// -------------------------------------------------------------

		server = new Server();
		server.start();

		// Register all classes...
		server.getKryo().register(ChatMessage.class);

		try {
			server.bind(54555, 54777);
		} catch (IOException e) {
			e.printStackTrace();
		}

		server.addListener(new Listener() {
			public void received (Connection connection, Object object) {
				if (object instanceof ChatMessage) {
					ChatMessage request = (ChatMessage)object;
					request.message = "> " + request.message;
					bus.post(request);

					connection.sendTCP(new ChatMessage("That's nice. Thanks for saying: " + request.getMessage()));
				}
			}
		});

		// -------------------------------------------------------------

		client = new Client();
		client.start();

		// Register all classes or the world ends... apparently.
		client.getKryo().register(ChatMessage.class);

		try {
			client.connect(5000, "127.0.0.1", 54555, 54777);
		} catch (IOException e) {
			e.printStackTrace();
		}

		client.addListener(new Listener() {
			public void received (Connection connection, Object object) {
				if (object instanceof ChatMessage) {
					ChatMessage response = (ChatMessage)object;
					response.message = "< " + response.message;
					bus.post(response);
				}
			}
		});

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
			client.sendTCP(new ChatMessage("BURRRRRRRRGLE"));
		}
	}

	@Override
	public void dispose() {
		client.stop();
		server.stop();
	}

	@Subscribe
	public void doSomething(ChatMessage event) {
		Gdx.app.log("DEMO", event.getMessage());
	}

}
