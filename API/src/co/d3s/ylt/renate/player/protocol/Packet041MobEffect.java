package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;

public class Packet041MobEffect extends PlayerPacket {
	public Packet041MobEffect(Protocol protocol) {
		super(protocol);
	}

	public int EID;
	public byte Effect_ID;
	public byte Amplifier;
	public short Duration;

	{
		bytes = type_int + type_byte + type_byte + type_short;
	}

	@Override
	public boolean receive(ByteBuffer buffer) throws IOException {
		EID = buffer.getInt();
		Effect_ID = buffer.get();
		Amplifier = buffer.get();
		Duration = buffer.getShort();
		return true;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.putInt(EID);
		buffer.put(Effect_ID);
		buffer.put(Amplifier);
		buffer.putShort(Duration);
	}
}
