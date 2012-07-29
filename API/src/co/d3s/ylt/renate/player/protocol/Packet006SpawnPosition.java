package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;
import co.d3s.ylt.renate.player.PlayerPacketHandler;

public class Packet006SpawnPosition extends PlayerPacket {
	public Packet006SpawnPosition(Protocol protocol) {
		super(protocol);
	}

	public Packet006SpawnPosition(int X, int Y, int Z) {
		this.X = X;
		this.Y = Y;
		this.Z = Z;
	}

	public int X;
	public int Y;
	public int Z;

	{
		bytes = type_int * 3;
	}

	@Override
	public boolean receive(ByteBuffer buffer) throws IOException {
		X = buffer.getInt();
		Y = buffer.getInt();
		Z = buffer.getInt();
		return true;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.put((byte) 6);
		buffer.putInt(X);
		buffer.putInt(Y);
		buffer.putInt(Z);
	}

	@Override
	public void received(PlayerPacketHandler handler) throws IOException {
		handler.receive(this);
	}
}
