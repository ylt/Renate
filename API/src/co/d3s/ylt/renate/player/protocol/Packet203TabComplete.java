package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;

public class Packet203TabComplete extends PlayerPacket {
	public Packet203TabComplete(Protocol protocol) {
		super(protocol);
	}

	public Packet203TabComplete(String msg) {
		this.msg = msg;
	}

	private int msglen;
	public String msg;

	{
		bytes = type_short;
	}

	@Override
	public boolean receive(ByteBuffer buffer) throws IOException {
		switch (i) {
		case 0:
			msglen = buffer.getShort();
			bytes = msglen * 2;
			break;
		case 1:
			msg = getString(buffer, msglen, 100); //TODO: Check if this is a big enough max length
			return true;
		}
		i++;
		return false;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.put((byte) 255);
		putString(msg, buffer);
	}
}
