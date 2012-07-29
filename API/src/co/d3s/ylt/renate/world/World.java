package co.d3s.ylt.renate.world;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import co.d3s.ylt.renate.entity.Entity;

public class World {

	public World(String name) {
		//does it exist?
		File wfile = new File("worlds/"+name);
		if (wfile.exists()) {
			load(wfile);
		}
		else {
			create(wfile);
		}
		//TODO: add server references?
	}
	private void create(File wfile) {
		File pfile = wfile.getParentFile();
		if ((pfile.exists() && pfile.isDirectory()) || pfile.mkdir()) return; //TODO: THROW A FUCKING EXCEPTION!
		try {
			if (!wfile.createNewFile()) return;
		} catch (IOException e) {
			 return;
		}
	}
	private void load(File wfile) {
		//TODO: need to decide upon fileformat
	}
	
	List<Entity> entities = new LinkedList<Entity>();
	
	public HashMap<Long,ChunkReference> chunks = new HashMap<Long,ChunkReference>();
	public Chunk getChunk(int x, int y) {
		Chunk chunk = chunks.get((long) (x+y<<32)).get();
		if (chunk == null) {
			chunk = new Chunk(this, x, y);
			chunks.put((long) (x+y<<32), new ChunkReference(chunk));
		}
		return chunk;
	}
	public void tick() {
		//tick our entities!
		for (Entity entity : entities) {
			entity.tick();
		}
	}
	public void getChunkReference(int x, int y, int z) {
		// TODO Auto-generated method stub
		
	}
}
