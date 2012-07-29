package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;

public class Packet104WindowItems extends PlayerPacket {
	public Packet104WindowItems(Protocol protocol) {
		super(protocol);
	}

	public Packet104WindowItems(byte WindowID, short count) {
		this.WindowID = WindowID;
		this.count = count;
	}

	public byte WindowID;
	public short count;
	{
		bytes = type_byte + type_short + count
				* (type_short + type_byte + type_short);
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.put((byte) 104);
		buffer.put(WindowID);
		buffer.putShort(count);
		// FIXME: Send Slot ARRAY
	}
}
