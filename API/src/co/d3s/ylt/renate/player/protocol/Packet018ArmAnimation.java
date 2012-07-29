package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;

public class Packet018ArmAnimation extends PlayerPacket {
	public Packet018ArmAnimation(Protocol protocol) {
		super(protocol);
	}

	public int EID;
	public byte ID;

	{
		bytes = type_int + type_byte;
	}

	@Override
	public boolean receive(ByteBuffer buffer) throws IOException {
		EID = buffer.getInt();
		ID = buffer.get();
		return true;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.put((byte) 18);
		buffer.putInt(EID);
		buffer.put(ID);
	}

}
