package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;

public class Packet108Enchantment extends PlayerPacket {
	public Packet108Enchantment(Protocol protocol) {
		super(protocol);
	}

	public byte WindowID;
	public byte Enchantment;

	{
		bytes = type_byte + type_byte;
	}

	@Override
	public boolean receive(ByteBuffer buffer) throws IOException {
		WindowID = buffer.get();
		Enchantment = buffer.get();
		return true;

	}
}
