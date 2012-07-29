package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;
import co.d3s.ylt.renate.player.PlayerPacketHandler;

public class Packet014BlockDig extends PlayerPacket {
	public Packet014BlockDig(Protocol protocol) {
		super(protocol);
	}

	public byte status;
	public int X;
	public byte Y;
	public int Z;
	public byte face;

	{
		bytes = type_byte + type_int + type_byte + type_int + type_byte;
	}

	@Override
	public boolean receive(ByteBuffer buffer) throws IOException {
		status = buffer.get();
		X = buffer.getInt();
		Y = buffer.get();
		Z = buffer.getInt();
		face = buffer.get();
		return true;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.put(status);
		buffer.putInt(X);
		buffer.put(Y);
		buffer.putInt(Z);
		buffer.put(face);
	}

	@Override
	public void received(PlayerPacketHandler handler) throws IOException {
		handler.receive(this);
	}
}
