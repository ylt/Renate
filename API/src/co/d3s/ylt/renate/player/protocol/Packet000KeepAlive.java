package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;
import co.d3s.ylt.renate.player.PlayerPacketHandler;

public class Packet000KeepAlive extends PlayerPacket {
	public Packet000KeepAlive(Protocol protocol) {
		super(protocol);

	}

	public Packet000KeepAlive(int Num) {
		this.Num = Num;
	}

	public int Num;

	// public int ;
	{
		bytes = type_int;
	}

	@Override
	public boolean receive(ByteBuffer buffer) throws IOException {
		Num = buffer.getInt();
		return true;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.put((byte) 0);
		buffer.putInt(Num);
	}

	@Override
	public void received(PlayerPacketHandler handler) throws IOException {
		handler.receive(this);
	}
}
