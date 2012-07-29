package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;
import co.d3s.ylt.renate.player.PlayerPacketHandler;

public class Packet010Flying extends PlayerPacket {
	public Packet010Flying(Protocol protocol) {
		super(protocol);
	}

	public byte Ground;

	{
		bytes = type_byte;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.put(Ground);
	}
	
	@Override
	public boolean receive(ByteBuffer buffer) throws IOException {
		Ground = buffer.get();
		return true;
	}

	@Override
	public void received(PlayerPacketHandler handler) throws IOException {
		handler.receive(this);
	}
}
