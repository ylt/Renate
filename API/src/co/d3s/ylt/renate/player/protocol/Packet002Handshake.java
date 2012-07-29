package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;
import co.d3s.ylt.renate.player.PlayerPacketHandler;
import co.d3s.ylt.renate.player.protocol.data.HandshakeDetails;

public class Packet002Handshake extends PlayerPacket {
	public Packet002Handshake(Protocol protocol) {
		super(protocol);
	}

	public Packet002Handshake(String hash) {
		this.hash = hash;
	}

	private short strlen;
	public String hash;

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
			hash = getString(buffer, strlen, 278);
			return true;
		}
		i++;
		return false;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.put((byte) 2);
		putString(hash, buffer);
		System.out.println("Sent handshake");
	}
	
	public HandshakeDetails getDetails() {
		String handshake[] = hash.split(";");
		return new HandshakeDetails(handshake[0], handshake[1]);
	}

	@Override
	public void received(PlayerPacketHandler handler) throws IOException {
		handler.receive(this);
	}
}


