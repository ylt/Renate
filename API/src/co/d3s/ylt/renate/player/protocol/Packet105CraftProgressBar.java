package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;

public class Packet105CraftProgressBar extends PlayerPacket {

	public Packet105CraftProgressBar(Protocol protocol) {
		super(protocol);
	}

	public byte ID;
	public short Progress;
	public short Value;

	{
		bytes = type_byte + type_short + type_short;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.put(ID);
		buffer.putShort(Progress);
		buffer.putShort(Value);
	}
}
