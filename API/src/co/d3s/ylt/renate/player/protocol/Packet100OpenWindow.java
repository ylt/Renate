package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;

public class Packet100OpenWindow extends PlayerPacket {
	public Packet100OpenWindow(Protocol protocol) {
		super(protocol);
	}

	public Packet100OpenWindow(byte WindowID, byte WindowType, String Title,
			byte Slots) {
		this.WindowID = WindowID;
		this.WindowType = WindowType;
		this.Title = Title;
		this.Slots = Slots;
	}

	public byte WindowID;
	public byte WindowType;
	private short strlen;
	public String Title;
	public byte Slots;

	{
		bytes = type_byte + type_byte;
	}

	@Override
	public boolean receive(ByteBuffer buffer) throws IOException {
		switch (i) {
		case 0:
			WindowID = buffer.get();
			WindowType = buffer.get();
			strlen = buffer.getShort();
			bytes = strlen * 2 + type_short;
			break;
		case 1:
			Title = getString(buffer, strlen, 16);
			Slots = buffer.get(Slots);
			return true;
		}
		i++;
		return false;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.put((byte) 100);
		buffer.put(WindowID);
		buffer.put(WindowType);
		putString(Title, buffer);
		buffer.put(Slots);
	}
}
