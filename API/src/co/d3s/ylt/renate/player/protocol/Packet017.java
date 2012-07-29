package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;
import co.d3s.ylt.renate.player.PlayerPacketHandler;

public class Packet017 extends PlayerPacket {

	public Packet017(Protocol protocol) {
		super(protocol);
	}

	public Packet017(int EntityID, byte inBed, int X, byte Y, int Z) {
		this.EntityID = EntityID;
		this.inBed = inBed;
		this.X = X;
		this.Y = Y;
		this.Z = Z;
	}

	public int EntityID;
	public byte inBed;
	public int X;
	public byte Y;
	public int Z;

	{
		bytes = type_int + type_byte + type_int + type_byte + type_int;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.put((byte) 17);
		buffer.putInt(EntityID);
		buffer.put(inBed);
		buffer.putInt(X);
		buffer.put(Y);
		buffer.putInt(Z);
	}

	@Override
	public void received(PlayerPacketHandler handler) throws IOException {
		handler.receive(this);
	}
}
