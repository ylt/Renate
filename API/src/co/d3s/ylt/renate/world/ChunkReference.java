package co.d3s.ylt.renate.world;

import java.lang.ref.WeakReference;

public class ChunkReference extends Object {
	Chunk chunk;
	WeakReference<Chunk> chunkref;
	public ChunkReference(Chunk chunk) {
		this.chunk = chunk;
		this.chunkref = new WeakReference<Chunk>(chunk);
	}
	//TODO: maybe worth using a phantom reference also (for deletion)
	public boolean load() {
		chunk = chunkref.get();
		return status();
	}
	public void unload() {
		chunk = null;
	}
	public Chunk get() {
		return (chunk!=null)?chunk:chunkref.get();
	}
	public boolean status() {
		return chunk!=null;
	}
}
