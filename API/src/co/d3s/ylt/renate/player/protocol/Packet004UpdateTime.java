package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;
import co.d3s.ylt.renate.player.PlayerPacketHandler;

public class Packet004UpdateTime extends PlayerPacket {
	public Packet004UpdateTime(Protocol protocol) {
		super(protocol);
	}

	public long time;

	{
		bytes = type_long;
	}

	@Override
	public boolean receive(ByteBuffer buffer) throws IOException {
		time = buffer.getLong();
		return true;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.putLong(time);
	}

	@Override
	public void received(PlayerPacketHandler handler) throws IOException {
		handler.receive(this);
	}
}