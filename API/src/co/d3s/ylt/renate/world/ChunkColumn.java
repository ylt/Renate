package co.d3s.ylt.renate.world;

public class ChunkColumn {
	World world;
	int x;
	int z;
	byte[] biome;
	
	public ChunkColumn(World world, int x, int z){
		this.world = world;
		this.x = x;
		this.z = z;
		this.biome = new byte[256];
	}
}
