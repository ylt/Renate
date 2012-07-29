package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;

public class Packet039AttachEntity extends PlayerPacket {
	public Packet039AttachEntity(Protocol protocol) {
		super(protocol);
	}

	public int EID; // id of player getting in the vehicle
	public int EIDV; // is the id of the vehicle

	{
		bytes = type_int + type_int;
	}

	@Override
	public boolean receive(ByteBuffer buffer) throws IOException {
		EID = buffer.getInt();
		EIDV = buffer.getInt();
		return true;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.putInt(EID);
		buffer.putInt(EIDV);
	}
}
