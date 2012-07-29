package co.d3s.ylt.renate.world;

import java.lang.ref.WeakReference;
import java.util.HashMap;

import co.d3s.ylt.renate.network.socket.SockManager;

public class WorldManager {
	SockManager server;
	HashMap<String, WeakReference<World>> weakworlds = new HashMap<String, WeakReference<World>>();
	HashMap<String, World> pinnedworlds = new HashMap<String, World>();

	public WorldManager(SockManager server) {
		this.server = server;
	}

	public World getWorld(String name) {
		WeakReference<World> wworld = weakworlds.get(name);
		if (wworld != null)
			return wworld.get();
		/*
		 * if (force == true) { World world = new World(name); worlds.put(name,
		 * new WeakReference<World>(world)); return world; }
		 */
		return null;
	}

	public World createWorld(String name) {
		World world = getWorld(name);
		if (world != null)
			return world;

		world = new World(name);
		weakworlds.put(name, new WeakReference<World>(world));
		return world;
	}
}
