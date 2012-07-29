package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;

public class Packet023VehicleSpawn extends PlayerPacket {
	public Packet023VehicleSpawn(Protocol protocol) {
		super(protocol);
	}

	public int EID;
	public byte Type;
	public int X;
	public int Y;
	public int Z;
	public int EID_O_SENT; // Id of the trower(only used if its a fireball,
							// ghast only??)
	public short A; // unknown fields only sent if the EID_O_SENT is bigger then
					// 0
	public short B; // unknown field
	public short C; // unknown field

	{
		bytes = type_int + type_byte + type_int + type_int + type_int
				+ type_int;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.putInt(EID);
		buffer.put(Type);
		buffer.putInt(X);
		buffer.putInt(Y);
		buffer.putInt(Z);
		buffer.putInt(EID_O_SENT);
		if (EID_O_SENT > 0) {
			bytes = type_int + type_byte + type_int + type_int + type_int
					+ type_int + type_short + type_short + type_short;
			buffer.putShort(A);
			buffer.putShort(B);
			buffer.putShort(C);
		}
	}
}
