package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;

public class Packet070Bed extends PlayerPacket {
	public Packet070Bed(Protocol protocol) {
		super(protocol);
	}

	public byte Reason;
	public byte Gamemode;

	{
		bytes = type_byte * 2;
	}

	@Override
	public boolean receive(ByteBuffer buffer) throws IOException {
		buffer.get();
		buffer.get();
		return true;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.put(Reason);
		buffer.put(Gamemode);
	}
}
