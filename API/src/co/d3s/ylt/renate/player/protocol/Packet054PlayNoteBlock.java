package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;

public class Packet054PlayNoteBlock extends PlayerPacket {
	public Packet054PlayNoteBlock(Protocol protocol) {
		super(protocol);
	}

	public int X;
	public short Y;
	public int Z;
	public byte Byte1;
	public byte Byte2;

	{
		bytes = type_int + type_short + type_int + type_byte * 2;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.putInt(X);
		buffer.putShort(Y);
		buffer.putInt(Z);
		buffer.put(Byte1);
		buffer.put(Byte2);
	}
}
