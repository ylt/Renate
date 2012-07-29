package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;

public class Packet103SetSlot extends PlayerPacket {
	public Packet103SetSlot(Protocol protocol) {
		super(protocol);
	}

	public Packet103SetSlot(byte WindowID, short Slot, short ID, byte Ammount,
			short Damage) {
		this.WindowID = WindowID;
		this.Slot = Slot;
		this.ID = ID;
		this.Ammount = Ammount;
		this.Damage = Damage;
	}

	public byte WindowID;
	public short Slot;
	// Slot Datatype
	public short ID = -1;
	public byte Ammount;
	public short Damage;

	{
		bytes = type_byte + type_short + type_short;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.put((byte) 103);
		buffer.put(WindowID);
		buffer.putShort(Slot);
		// Slot Datatype
		buffer.putShort(ID);
		if (ID > -1) {
			bytes = type_byte + type_short;
			buffer.put(Ammount);
			buffer.putShort(Damage);
		}
	}
}
