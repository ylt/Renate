package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;

public class Packet029DestroyEntity extends PlayerPacket {
	public Packet029DestroyEntity(Protocol protocol) {
		super(protocol);
	}

	public int EID;

	{
		bytes = type_int;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.putInt(EID);
	}
}
