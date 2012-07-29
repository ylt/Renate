package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.PlayerPacketHandler;

public class Packet007UseEntity extends PlayerPacket {
	public Packet007UseEntity(Protocol protocol) {
		super(protocol);
	}

	public int User;
	public int Target;
	public byte LeftClick;

	{
		bytes = type_int + type_int + type_byte;
	}

	@Override
	public boolean receive(ByteBuffer buffer) throws IOException {
		User = buffer.getInt();
		Target = buffer.getInt();
		LeftClick = buffer.get();
		return true;
	}

	@Override
	public void received(PlayerPacketHandler handler) throws IOException {
		handler.receive(this);
	}
}
