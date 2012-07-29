package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;

public class Packet025EntityPainting extends PlayerPacket {
	public Packet025EntityPainting(Protocol protocol) {
		super(protocol);
	}

	public int EID;
	private short strlen;
	public String Title;
	public int X;
	public int Y;
	public int Z;
	public int Direction;

	{
		bytes = type_int + type_short;
	}

	@Override
	public boolean receive(ByteBuffer buffer) throws IOException {
		switch (i) {
		case 0:
			EID = buffer.getInt();
			strlen = buffer.getShort();
			bytes = (strlen * 2) + type_int + type_int + type_int + type_int;
		case 1:
			Title = getString(buffer, strlen, 13);
			X = buffer.getInt();
			Y = buffer.getInt();
			Z = buffer.getInt();
			Direction = buffer.getInt();
			return true;
		}
		i++;
		return false;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.putInt(EID);
		putString(Title, buffer);
		buffer.putInt(X);
		buffer.putInt(Y);
		buffer.putInt(Z);
		buffer.putInt(Direction);
	}
}
