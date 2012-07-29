package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;

public class Packet061 extends PlayerPacket {
	public Packet061(Protocol protocol) {
		super(protocol);
	}

	public int ID;
	public int X;
	public byte Y;
	public int Z;
	public int Data;

	{
		bytes = type_int * 2 + type_byte + type_int * 2;
	}

	@Override
	public boolean receive(ByteBuffer buffer) throws IOException {
		buffer.getInt(ID);
		buffer.getInt(X);
		buffer.get(Y);
		buffer.getInt(Z);
		buffer.getInt(Data);
		return true;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.putInt(ID);
		buffer.putInt(X);
		buffer.put(Y);
		buffer.putInt(Z);
		buffer.putInt(Data);
	}
}
