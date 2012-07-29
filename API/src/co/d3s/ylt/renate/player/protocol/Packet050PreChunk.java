package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;

public class Packet050PreChunk extends PlayerPacket {

	public Packet050PreChunk(Protocol protocol) {
		super(protocol);
	}

	public Packet050PreChunk(int X, int Z, byte Mode) {

		this.X = X;
		this.Z = Z;
		this.Mode = Mode;

	}

	public int X;
	public int Z;
	public byte Mode;

	{
		bytes = type_int + type_int + type_byte;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.put((byte) 50);
		buffer.putInt(X);
		buffer.putInt(Z);
		buffer.put(Mode);
	}

}
