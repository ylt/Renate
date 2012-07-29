package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;

public class Packet031RelEntityMove extends PlayerPacket {
	public Packet031RelEntityMove(Protocol protocol) {
		super(protocol);
	}

	public int EID;
	public byte DX;
	public byte DY;
	public byte DZ;

	{
		bytes = type_int + type_byte + type_byte + type_byte;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.putInt(EID);
		buffer.put(DX);
		buffer.put(DY);
		buffer.put(DZ);
	}
}
