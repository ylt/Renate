package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;

public class Packet130UpdateSign extends PlayerPacket {

	public Packet130UpdateSign(Protocol protocol) {
		super(protocol);
	}

	public int X;
	public short Y;
	public int Z;
	private short strlen;
	public String a;
	public String b;
	public String c;
	public String d;

	{
		bytes = type_short;
	}

	@Override
	public boolean receive(ByteBuffer buffer) throws IOException {
		switch (i) {
		case 0:
			strlen = buffer.getShort();
			bytes = strlen * 2 + type_short;
			break;
		case 1:
			a = getString(buffer, strlen, 16);
			strlen = buffer.getShort();
			bytes = strlen * 2 + type_short;
			break;
		case 2:
			b = getString(buffer, strlen, 16);
			strlen = buffer.getShort();
			bytes = strlen * 2 + type_short;
			break;
		case 3:
			c = getString(buffer, strlen, 16);
			strlen = buffer.getShort();
			bytes = strlen * 2 + type_short;
			break;
		case 4:
			d = getString(buffer, strlen, 100);
			return true;
		}
		i++;
		return false;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.put((byte) 130);
		putString(a, buffer);
		putString(b, buffer);
		putString(c, buffer);
		putString(d, buffer);
	}
}
