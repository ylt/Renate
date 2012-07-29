package co.d3s.ylt.renate.entity;

import java.util.LinkedList;
import java.util.List;

import co.d3s.ylt.renate.player.Player;
import co.d3s.ylt.renate.world.Chunk;
import co.d3s.ylt.renate.world.ChunkReference;
import co.d3s.ylt.renate.world.World;

public class PlayerTracker {
	
	private Player player;
	private List<Chunk> loaded; //lists of loaded chunks,
	
	public List<ChunkReference> nearChunks() {
		World world = player.world;
		int r = player.chunkradius; //TODO: Do right later.
		/* use better code later */
		List<ChunkReference> chunks = new LinkedList<ChunkReference>();
		for(int x = -r; x <= r; x++) {
			for(int y = -r; y <= r; y++) {
				for(int z = -5; z <= 5; z++) {
					world.getChunkReference(x,y,z);
				}
			}
		}
		return chunks;
	}
}
