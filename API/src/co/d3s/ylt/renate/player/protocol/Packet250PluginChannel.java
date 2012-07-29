package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;

public class Packet250PluginChannel extends PlayerPacket {
	public Packet250PluginChannel(Protocol protocol) {
		super(protocol);
	}

	public Packet250PluginChannel(String Channel, int count, byte[] Payload) {
		this.Channel = Channel;
		this.count = count;
		this.Payload = Payload;
	}

	private short strlen;
	public String Channel;
	public int count;
	public byte[] Payload;

	{
		bytes = type_short;
	}

	@Override
	public boolean receive(ByteBuffer buffer) throws IOException {
		switch (i) {
		case 0:
			strlen = buffer.getShort();
			bytes = strlen * 2 + type_int;
			break;
		case 1:
			Channel = getString(buffer, strlen, 16);
			count = buffer.getInt();
			bytes = count;
			break;
		case 2:
			buffer.get(Payload, 0, count);
		}
		i++;
		return false;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.put((byte) 250);
		putString(Channel, buffer);
		buffer.putInt(count);
		buffer.put(Payload);
	}
}
