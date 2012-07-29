package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;

import co.d3s.ylt.renate.network.protocol.Packet;
import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.PlayerPacketHandler;

public class PlayerPacket extends Packet {
	public PlayerPacket() {
	}

	public PlayerPacket(Protocol protocol) {
		super(protocol);
	}

	public void received(PlayerPacketHandler ph) throws IOException {
		ph.receive(this);
	}
}