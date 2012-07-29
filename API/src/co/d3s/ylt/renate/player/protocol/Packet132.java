package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;

public class Packet132 extends PlayerPacket  {

	public Packet132(Protocol protocol){
		super(protocol);
	}
	public Packet132(int X, short Y, int Z, byte Action, int Custom1, int Custom2, int Custom3){
		this.X = X;
		this.Y = Y;
		this.Z = Z;
		this.Action = Action;
		this.Custom1 = Custom1;
		this.Custom2 = Custom2;
		this.Custom3 = Custom3;
	}
	
	public int X;
	public short Y;
	public int Z;
	public byte Action;
	public int Custom1;
	public int Custom2;
	public int Custom3;
	
	{
		bytes = type_int + type_short + type_int + type_byte + (type_int * 3);
	}
	public boolean receive(ByteBuffer buffer) throws IOException {
		X = buffer.getInt();
		Y = buffer.getShort();
		Z = buffer.getInt();
		Action = buffer.get();
		Custom1 = buffer.getInt();
		Custom2 = buffer.getInt();
		Custom3 = buffer.getInt();
		return true;
	}
	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.put((byte) 132);
		buffer.putInt(X);
		buffer.putShort(Y);
		buffer.putInt(Z);
		buffer.put(Action);
		buffer.putInt(Custom1);
		buffer.putInt(Custom2);
		buffer.putInt(Custom3);
	}

}
