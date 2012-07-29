package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;

public class Packet026AddExpOrb extends PlayerPacket {
	public Packet026AddExpOrb(Protocol protocol) {
		super(protocol);
	}

	public int EID;
	public int X;
	public int Y;
	public int Z;
	public short Count;

	{
		bytes = type_int + type_int + type_int + type_int + type_short;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.putInt(EID);
		buffer.putInt(X);
		buffer.putInt(Y);
		buffer.putInt(Z);
		buffer.putShort(Count);
	}
}
