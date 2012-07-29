package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;

public class Packet051MapChunk extends PlayerPacket {
	public Packet051MapChunk(Protocol protocol) {
		super(protocol);
	}
	public Packet051MapChunk(int X, int Z, byte column, short primaryBitMap, short addBitMap, int compressedSize, int unused, byte[] data){
		this.X = X;
		this.Z = Z;
		this.column = column;
		this.primaryBitMap = primaryBitMap;
		this.addBitMap = addBitMap;
		this.compressedSize = compressedSize;
		this.unused = unused;
		this.data = data;
	}
	
	public int X;
	public int Z;
	public byte column;
	public short primaryBitMap;
	public short addBitMap = 0;
	public int compressedSize;
	public int unused = 0;
	public byte[] data;
	
	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.put((byte) 51);
		buffer.putInt(X);
		buffer.putInt(Z);
		buffer.put(column);
		buffer.putShort(primaryBitMap);
		buffer.putShort(addBitMap);
		buffer.putInt(compressedSize);
		buffer.putInt(unused);
		buffer.put(data);
	}

	/*public Packet051MapChunk(int X, short Y, int Z, byte Size_X, byte Size_Y,
			byte Size_Z, int Compressed, byte[] chunk) {

		this.X = X;
		this.Y = Y;
		this.Z = Z;
		this.Size_X = Size_X;
		this.Size_Y = Size_Y;
		this.Size_Z = Size_Z;
		this.Compressed = Compressed;
		this.chunk = chunk;

	}

	public int X;
	public short Y;
	public int Z;
	public byte Size_X;
	public byte Size_Y;
	public byte Size_Z;
	public int Compressed;
	public byte[] chunk;

	{
		bytes = type_int + type_short + type_int + type_byte + type_byte
				+ type_byte + type_int + chunk.length;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.put((byte) 51);
		buffer.putInt(X);
		buffer.putShort(Y);
		buffer.putInt(Z);
		buffer.put(Size_X);
		buffer.put(Size_Y);
		buffer.put(Size_Z);
		buffer.putInt(Compressed);
		buffer.put(chunk);
	}*/
}
