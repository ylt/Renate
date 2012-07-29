package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;

public class Packet028EntityVelocity extends PlayerPacket {
	public Packet028EntityVelocity(Protocol protocol) {
		super(protocol);
	}

	public int EID;
	public short X;
	public short Y;
	public short Z;

	{
		bytes = type_int + type_short + type_short + type_short;
	}

	@Override
	public boolean receive(ByteBuffer buffer) throws IOException {
		EID = buffer.getInt();
		X = buffer.getShort();
		Y = buffer.getShort();
		Z = buffer.getShort();
		return true;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.putInt(EID);
		buffer.putShort(X);
		buffer.putShort(Y);
		buffer.putShort(Z);
	}
}
