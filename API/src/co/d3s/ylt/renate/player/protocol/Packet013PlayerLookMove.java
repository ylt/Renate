package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;
import co.d3s.ylt.renate.player.PlayerPacketHandler;

public class Packet013PlayerLookMove extends PlayerPacket {
	public Packet013PlayerLookMove(Protocol protocol) {
		super(protocol);
	}

	public Packet013PlayerLookMove(double X, double Y, double stance, double Z,
			float yaw, float pitch, byte onGround) {
		this.X = X;
		this.Y = Y;
		this.stance = stance;
		this.Z = Z;
		this.yaw = yaw;
		this.pitch = pitch;
		this.onGround = onGround;
	}

	public double X;
	public double Y;
	public double stance;
	public double Z;
	public float yaw;
	public float pitch;
	public byte onGround;

	{
		bytes = type_double + type_double + type_double + type_double
				+ type_float + type_float + type_byte;
	}

	@Override
	public boolean receive(ByteBuffer buffer) throws IOException {
		X = buffer.getDouble();
		Y = buffer.getDouble();
		stance = buffer.getDouble();
		Z = buffer.getDouble();
		yaw = buffer.getFloat();
		pitch = buffer.getFloat();
		onGround = buffer.get();
		return true;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.put((byte) 13);
		buffer.putDouble(X);
		buffer.putDouble(Y);
		buffer.putDouble(stance);
		buffer.putDouble(Z);
		buffer.putFloat(yaw);
		buffer.putFloat(pitch);
		buffer.put(onGround);
	}

	@Override
	public void received(PlayerPacketHandler handler) throws IOException {
		handler.receive(this);
	}
}
