package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.PlayerPacketHandler;

public class Packet011PlayerPosition extends PlayerPacket {
	public Packet011PlayerPosition(Protocol protocol) {
		super(protocol);
	}

	public double X;
	public double Y;
	public double stance;
	public double Z;
	public byte onGround;

	{
		bytes = type_double + type_double + type_double + type_double
				+ type_byte;
	}

	@Override
	public boolean receive(ByteBuffer buffer) throws IOException {
		X = buffer.getDouble();
		Y = buffer.getDouble();
		stance = buffer.getDouble();
		Z = buffer.getDouble();
		onGround = buffer.get();
		return true;
	}

	@Override
	public void received(PlayerPacketHandler handler) throws IOException {
		handler.receive(this);
	}
}
