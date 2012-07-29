package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;

public class Packet024MobSpawn extends PlayerPacket {
	public Packet024MobSpawn(Protocol protocol) {
		super(protocol);
	}
	public Packet024MobSpawn(int EID, byte Type, int X, int Y, int Z, byte Yaw,
			byte Pitch, byte HeadYaw) {
		this.EID = EID;
		this.Type = Type;
		this.X = X;
		this.Y = Y;
		this.Z = Z;
		this.Yaw = Yaw;
		this.Pitch = Pitch;
		this.HeadYaw = HeadYaw;
	}
	// NOTE: this is an incomplete packet, if you happen to know how to add
	// metadata, go ahead and finish this for me
	public int EID;
	public byte Type;
	public int X;
	public int Y;
	public int Z;
	public byte Yaw;
	public byte Pitch;
	public byte HeadYaw;


	{
		bytes = type_int + type_byte + type_int + type_int + type_int
				+ type_int;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.put((byte) 24);
		buffer.putInt(EID);
		buffer.put(Type);
		buffer.putInt(X);
		buffer.putInt(Y);
		buffer.putInt(Z);
		buffer.put(Yaw);
		buffer.put(Pitch);
		buffer.put(HeadYaw);
	}
}
