Basic Networking and the Otto Event Bus
---

Today, we're going to cover some basic client / server networking in Java with LibGdx and an awesome library called [KryoNet][kryonet]. KryoNet is a Java library that provides a clean and simple API for efficient TCP and UDP client/server network communication using NIO. We left off with a bare LibGDX install last time so we're going to need to bring KryoNet in as a dependency using Gradle, a Java dependency manager. We'll get to that shortly. First, I want to talk about the goal for today.

> Our goal for this session is to establish client / server communication via KryoNet and send a message from one client to be broadcast to all connected clients.

Eventually, we will want to attempt to run a server-authoritative network model where clients merely send commands to the server and are responded-to with events detailing what has occurred elsewhere in the simulation. For purposes of isolating consuming code from networking concerns, I think it will be a good idea to create a boundary whereby commands are sent by callers to some network abstraction for transmission to server. Additionally, callers may register listeners with this abstraction for certain events. Commands in, events out.

Because I don't know much about how net-code will be implemented currently (synchronizing a non-deterministic physics simulation is not trivial), abstracting that implementation behind a command-oriented interface seems like a good idea. We'll see what happens.

**Sketch Notes**

1. Install [Otto][otto] and write some sample code.
2. Install [KryoNet][kryonet] and write a simple client / server inside same runtime.
3. Separate server runtime into a server project.
    - Create a Java console main class
    - Make sure you can use KryoNet / share stuff from other packages?
    - Create compound run configuration
4. Send a message from one client, see it on another connected client.
    - `> SendChatMessage(PlayerId, string message)`
    - `< ChatMessageWasReceived(PlayerId, string message)`
    - PlayerId is a guid or something, it's temporary
    - Command goes to bus

**References**

- [KryoNet][kryonet]
- [Otto][otto]
- [Gaffer on Games "Networked Physics"](http://gafferongames.com/networked-physics/introduction-to-networked-physics/)

[kryonet]: https://github.com/EsotericSoftware/kryonet
[otto]: https://github.com/square/otto