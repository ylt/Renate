package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;

public class Packet020NamedEntitySpawn extends PlayerPacket {
	public Packet020NamedEntitySpawn(Protocol protocol) {
		super(protocol);
	}

	public int EID;
	private short strlen;
	public String Player_Name;
	public int X;
	public int Y;
	public int Z;
	public byte Yaw;
	public byte Pitch;
	public short Item;

	public Packet020NamedEntitySpawn(int EID, String Player_Name, int X, int Y,
			int Z, byte Yaw, byte Pitch, short Item) {
		this.EID = EID;
		this.Player_Name = Player_Name;
		this.X = X;
		this.Y = Y;
		this.Z = Z;
		this.Yaw = Yaw;
		this.Pitch = Pitch;
		this.Item = Item;
	}

	{
		bytes = type_int + (strlen * 2) + type_int + type_int + type_int
				+ type_byte + type_byte + type_short;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.putInt(EID);
		putString(Player_Name, buffer);
		buffer.putInt(X);
		buffer.putInt(Y);
		buffer.putInt(Z);
		buffer.put(Yaw);
		buffer.put(Pitch);
		buffer.putShort(Item);
	}
}
