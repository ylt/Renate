package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;

public class Packet107SetCreativeSlot extends PlayerPacket {

	public Packet107SetCreativeSlot(Protocol protocol) {
		super(protocol);
	}

	public short Slot;
	public short ID;
	public byte Ammount;
	public short Damage;

	{
		bytes = type_short * 4;
	}

	@Override
	public boolean receive(ByteBuffer buffer) throws IOException {
		buffer.put((byte) 107);
		buffer.getShort(Slot);
		buffer.getShort(ID);
		if (ID > -1) {
			buffer.get(Ammount);
			buffer.getShort(Damage);
		}
		return true;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.putShort(Slot);
		buffer.putShort(ID);
		buffer.put(Ammount);
		buffer.putShort(Damage);
	}
}
