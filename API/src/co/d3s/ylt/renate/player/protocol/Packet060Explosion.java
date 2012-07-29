package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;

public class Packet060Explosion extends PlayerPacket {
	public Packet060Explosion(Protocol protocol) {
		super(protocol);
	}

	public double X;
	public double Y;
	public double Z;
	public float Radius;
	public int Count;
	public byte Record1;
	public byte Record2;
	public byte Record3;

	{
		bytes = type_double * 3 + type_float + type_int + type_byte * 3;
	}

	@Override
	public boolean receive(ByteBuffer buffer) throws IOException {
		buffer.getDouble();
		buffer.getDouble();
		buffer.getDouble();
		buffer.getFloat();
		buffer.getInt();
		buffer.get();
		buffer.get();
		buffer.get();
		return true;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.putDouble(X);
		buffer.putDouble(Y);
		buffer.putDouble(Z);
		buffer.putFloat(Radius);
		buffer.putInt(Count);
		buffer.put(Record1);
		buffer.put(Record2);
		buffer.put(Record3);
	}
}
