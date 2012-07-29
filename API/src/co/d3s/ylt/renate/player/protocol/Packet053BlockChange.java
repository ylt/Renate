package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;

public class Packet053BlockChange extends PlayerPacket {

	public Packet053BlockChange(Protocol protocol) {
		super(protocol);
	}
	
	public Packet053BlockChange(int x, byte y, int z, int blocktype, int metadata){
		this.X = x;
		this.Y = y;
		this.Z = z;
		this.BlockType = blocktype;
		this.Metadata = metadata;
	}

	public int X;
	public byte Y;
	public int Z;
	public int BlockType;
	public int Metadata;

	{
		bytes = type_int + type_byte + type_int * 3;
	}

	@Override
	public boolean receive(ByteBuffer buffer) throws IOException {
		buffer.getInt(X);
		buffer.get(Y);
		buffer.getInt(BlockType);
		buffer.getInt(Metadata);
		return true;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.putInt(X);
		buffer.put(Y);
		buffer.putInt(Z);
		buffer.putInt(BlockType);
		buffer.putInt(Metadata);
	}

}
