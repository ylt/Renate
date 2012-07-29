package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;

public class Packet071Weather extends PlayerPacket {
	public Packet071Weather(Protocol protocol) {
		super(protocol);
	}

	public int ID;
	public byte UNKNOWN;
	public int X;
	public int Y;
	public int Z;

	{
		bytes = type_int + type_byte + type_int * 3;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.putInt(ID);
		buffer.put(UNKNOWN);
		buffer.putInt(X);
		buffer.putInt(Y);
		buffer.putInt(Z);
	}
}
