package com.mdwheele.moba.server;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.mdwheele.moba.ChatMessage;

import java.io.IOException;

public class MobaServer
{

    public static void main(String[] args)
    {
        final Server server = new Server();
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
                    System.out.println("SERVER: Client said: \"" + request.getMessage() + "\"");

                    // Respond
                    server.sendToAllTCP(new ChatMessage("That's nice. Thanks!"));
                }
            }
        });
    }

}
