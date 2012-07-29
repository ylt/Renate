package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;

public class Packet022Collect extends PlayerPacket {
	public Packet022Collect(Protocol protocol) {
		super(protocol);
	}

	public int EID; // id of collected entity
	public int EIDC; // id of collector entity

	{
		bytes = type_int + type_int;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.putInt(EID);
		buffer.putInt(EIDC);
	}
}
