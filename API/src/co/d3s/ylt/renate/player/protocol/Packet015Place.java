package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.PlayerPacketHandler;

public class Packet015Place extends PlayerPacket {
	public Packet015Place(Protocol protocol) {
		super(protocol);
	}

	public int X;
	public byte Y;
	public int Z;
	public byte direction;
	public short ID;
	public byte amount;
	public short damage;

	{
		bytes = type_int + type_byte + type_int + type_byte + type_short;
	}

	// has variable length, will come back to this later

	@Override
	public void received(PlayerPacketHandler handler) throws IOException {
		handler.receive(this);
	}
}
