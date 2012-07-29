package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;

public class Packet021PickupSpawn extends PlayerPacket {
	public Packet021PickupSpawn(Protocol protocol) {
		super(protocol);
	}

	public int EID;
	public short Item;
	public byte Count;
	public short Data; // can be meta data or damage value
	public int X;
	public int Y;
	public int Z;
	public byte Rotation;
	public byte Pitch;
	public byte Roll;

	{
		bytes = type_int + type_short + type_byte + type_short + type_int
				+ type_int + type_int + type_byte + type_byte + type_byte;
	}

	@Override
	public boolean receive(ByteBuffer buffer) throws IOException {
		EID = buffer.getInt();
		Item = buffer.getShort();
		Count = buffer.get();
		Data = buffer.getShort();
		X = buffer.getInt();
		Y = buffer.getInt();
		Z = buffer.getInt();
		Rotation = buffer.get();
		Pitch = buffer.get();
		Roll = buffer.get();
		return true;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.putInt(EID);
		buffer.putShort(Item);
		buffer.put(Count);
		buffer.putShort(Data);
		buffer.putInt(X);
		buffer.putInt(Y);
		buffer.putInt(Z);
		buffer.put(Rotation);
		buffer.put(Pitch);
		buffer.put(Roll);
	}
}
