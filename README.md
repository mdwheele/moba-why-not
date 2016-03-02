Why not make a MOBA? 
---

In tradition with my normal "start writing a game and then drop it" mentality, I have decided that it is a good idea to write a MOBA. In reality, this will probably end in a tech demo of pathfinding in a box2d 2d physics simulation, waypoint / goal pathfinding AI walking along a lane having been spawned at some random-ass location and finally... maybe a tower. But it's not going to shoot anything because by the time I get to it, I'll likely have lost interest. The facts... are real.

So what the shit is a MOBA?

A MOBA is... [lemme look up what the hell it stands for](https://en.wikipedia.org/wiki/Multiplayer_online_battle_arena). Look at that!

> Multiplayer online battle arena (MOBA), also known as action real-time strategy (ARTS), originated as a subgenre of the real-time strategy (RTS) genre of video games, in which a player controls a single character in one of two teams. The objective is to destroy the opposing team's main structure with the assistance of periodically spawned computer-controlled units that march forward along set paths.

So there is a board, there will be at least one lane and two teams will be at opposing ends of that lane. Players on each team control a character and the goal is to attack the other team and blow up what's on the other end. To help things along and provide some basic-ass PvE (player versus environment) basis for experience-gain (leveling up) there will be these random mobs (monsters) that spawn in the lane and march their happy little selves towards the opposing team. They have EXTREMELY basic AI and basically just march along a waypoint chain until they are in range to attack (melee / ranged, etc). All in all, players help the "creeps" move towards enemy base and that's pretty much the end of it.

MOBA is kinda like... tower defense... with user-controlled players... and you didn't build any of the towers... and you're destroying the towers. It's fickle like that.

So, fuck all that. I want to make something more interesting! RECENTLY, I have taken up playing [Heroes of the Storm](https://en.wikipedia.org/wiki/Heroes_of_the_Storm) after having played [League of Legends]() for a long time. HotS is similar to LoL in many ways; different in more. It's an interesting take on the genre. But... fuck all that too! 

I've also been playing Rust, which is basically a hit-random-people-with-rocks-and-spears-while-naked meets Minecraft meets every internet troll ever; all combined into some DayZ [ramble ramble ramble]. It's insanity implemented in Unity. I also like Power Rangers ... and I also like the idea of a MOBA that has a persistent experience between games. More players. Player experiences carry-over between games. So... I propose...

MMOBAMMCR (Massively Multiplayer Online Battle Arena Mechatronic MineCraft Rust) Simulator 

~big reveal~

In all seriousness, the idea would stick pretty close to a traditional MOBA, with a few additions:

* I want more than five-versus-five battles.
* Feeling that players are in an open-world, yet objectives still matter.
* A giant mech that teams work towards building and must pilot together.
* Goal becomes to destroy the other players mech.
* Mech can only be damaged by opposing mech? (gonna have to mind-map at this point, no more detail here)
* Players can build free-form structures along lanes, traps in jungle.
* To build anything, players must gather resources from environment. This is persistant? (meaning, farm forest out, creates new pathways, consumes global resources)

Tech shit I'm interested in working with:

* Multiplayer anything
  * EventSourced architecture? lol.. Uhm, what if clients polled equivalent of a ES read head for updates? Sent inputs as commands.
  * This *seems* to be what HotS is doing. When connectivity is lost, you get a "you're 0:03 seconds behind server.. catching up." kind of thing.
  * Server-authoritative deterministic physics simulation (do I need this? can I just fake physics? probably, but it'll be the different in implementing A* vs steering behaviours... think I want to play with steering behaviours)
* Steering Behaviours
  * A* doesn't deal well with an ever-changing "navmesh". So destructable (consumable) terrain isn't going to fly well as the navigation graph will need to be constantly regenerated. Sad day.
  * Steering behaviours produce realistic-enough pathfinding behaviours at a computational cost. Lots of research out there we can work from.
* Another stab at working with an ECS (entity component system). Artemis-ODB (upstream is dead) would be the choice this time (used Ashley last time).
* Match-making (low priority)

Project management stuff.

I'm going to have to keep myself focused on small iterations with clear goals throughout the process. It **will** be a good idea to do some work up-front to set longer term direction throughout the streaming process for this thing. It is absolutely critical (if I care to finish with something useful) that work is organized such that it can be worked on without a lot of fuss and I can leave and come back and see exactly where I left off and where I was going. Goal-oriented (pull) project management / planning.

- Mind map for high-level ideas / whatifs / future ideas
- Trello for task management

**Application Life-cycle Overview (LibGdx)**

![](https://github.com/libgdx/libgdx/wiki/images/70efff32-dd28-11e3-9fc4-1eb57143aee6.png)