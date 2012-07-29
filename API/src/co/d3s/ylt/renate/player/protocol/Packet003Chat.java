package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;
import co.d3s.ylt.renate.player.PlayerPacketHandler;

public class Packet003Chat extends PlayerPacket {
	public Packet003Chat(Protocol protocol) {
		super(protocol);
	}

	public Packet003Chat(String message) {
		this.message = message;
	}

	private short strlen;
	public String message; // <username

	{
		bytes = type_short;
	}

	@Override
	public boolean receive(ByteBuffer buffer) throws IOException {
		switch (i) {
		case 0:
			strlen = buffer.getShort();
			bytes = strlen * 2;
		case 1:
			message = getString(buffer, strlen, 100);
			return true;
		}
		i++;
		return false;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.put((byte) 3);
		putString(message, buffer);
	}

	@Override
	public void received(PlayerPacketHandler handler) throws IOException {
		handler.receive(this);
	}
}
