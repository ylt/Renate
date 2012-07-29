package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;

public class Packet106Transaction extends PlayerPacket {

	public Packet106Transaction(Protocol protocol) {
		super(protocol);
	}

	public byte ID;
	public short Number;
	public byte Accepted;

	{
		bytes = type_byte + type_short + type_byte;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.put(ID);
		buffer.putShort(Number);
		buffer.put(Accepted);
	}
}
