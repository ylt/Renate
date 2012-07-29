package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;

public class Packet102WindowClick extends PlayerPacket {
	public Packet102WindowClick(Protocol protocol) {
		super(protocol);
	}

	public Packet102WindowClick(byte ID, short Slot, byte RightClick,
			short Transaction, byte Shift, short SlotID, byte Ammount,
			short Damage) {
		this.ID = ID;
		this.Slot = Slot;
		this.RightClick = RightClick;
		this.Transaction = Transaction;
		this.Shift = Shift;
		this.SlotID = SlotID;
		this.Ammount = Ammount;
		this.Damage = Damage;
	}

	public byte ID;
	public short Slot;
	public byte RightClick;
	public short Transaction;
	public byte Shift;
	// Slot datatype
	public short SlotID;
	public byte Ammount;
	public short Damage;

	{
		bytes = type_byte + type_short + type_byte + type_short + type_byte
				+ type_short;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.put((byte) 102);
		buffer.put(ID);
		buffer.putShort(Slot);
		buffer.put(RightClick);
		buffer.putShort(Transaction);
		buffer.put(Shift);
		// Slot datatype
		buffer.putShort(SlotID);
		if (SlotID > -1) {
			bytes = type_byte + type_short;
			buffer.put(Ammount);
			buffer.putShort(Damage);
		}
	}
}
