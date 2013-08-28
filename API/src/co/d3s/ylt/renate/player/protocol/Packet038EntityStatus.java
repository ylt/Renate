package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;

public class Packet038EntityStatus extends PlayerPacket {
	public Packet038EntityStatus(Protocol protocol) {
		super(protocol);
	}

	public int EID;
	public byte Status;

	{
		bytes = type_int + type_byte;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.putInt(EID);
		buffer.put(Status);
	}
}
