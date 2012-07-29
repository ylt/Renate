package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;

public class Packet101CloseWindow extends PlayerPacket {
	public Packet101CloseWindow(Protocol protocol) {
		super(protocol);
	}

	public byte ID;

	{
		bytes = type_byte;
	}

	@Override
	public boolean receive(ByteBuffer buffer) throws IOException {
		buffer.get();
		return true;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.put((byte) 101);
		buffer.put(ID);
	}
}
