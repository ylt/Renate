package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;
import co.d3s.ylt.renate.player.PlayerPacketHandler;

public class Packet254GetInfo extends PlayerPacket {
	public Packet254GetInfo(Protocol protocol) {
		// super(protocol);
	}

	public String info;

	{
		bytes = 0;
	}

	@Override
	public boolean receive(ByteBuffer buffer) {
		// System.out.println("received, wut do now?");
		return true;
	}

	public void send(Player player) throws IOException { //TODO: Why are we prepared to send it?!
		ByteBuffer buffer = player.protocol.out_buffer;
		putString(info, buffer);
	}

	@Override
	public void received(PlayerPacketHandler handler) throws IOException {
		handler.receive(this);
	}
}