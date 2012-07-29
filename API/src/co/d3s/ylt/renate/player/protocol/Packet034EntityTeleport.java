package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;

public class Packet034EntityTeleport extends PlayerPacket {
	public Packet034EntityTeleport(Protocol protocol) {
		super(protocol);
	}

	public int EID;
	public int X;
	public int Y;
	public int Z;
	public byte Yaw;
	public byte Pitch;

	{
		bytes = type_int + type_int + type_int + type_int + type_byte
				+ type_byte;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.putInt(EID);
		buffer.putInt(X);
		buffer.putInt(Y);
		buffer.putInt(Z);
		buffer.put(Yaw);
		buffer.put(Pitch);
	}
}
