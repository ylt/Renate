package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.PlayerPacketHandler;

public class Packet012PlayerLook extends PlayerPacket {
	public Packet012PlayerLook(Protocol protocol) {
		super(protocol);
	}

	public float yaw;
	public float pitch;
	public byte onGround;

	{
		bytes = type_float + type_float + type_byte;
	}

	@Override
	public boolean receive(ByteBuffer buffer) throws IOException {
		yaw = buffer.getFloat();
		pitch = buffer.getFloat();
		onGround = buffer.get();
		return true;
	}

	@Override
	public void received(PlayerPacketHandler handler) throws IOException {
		handler.receive(this);
	}
}
