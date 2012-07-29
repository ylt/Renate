package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;
import co.d3s.ylt.renate.player.PlayerPacketHandler;

public class Packet005EntityEquipment extends PlayerPacket {
	public Packet005EntityEquipment(Protocol protocol) {
		super(protocol);
	}

	public int entityID;
	public short slot;
	public short itemID;
	public short damage;

	{
		bytes = type_int + type_short + type_short + type_short;
	}

	@Override
	public boolean receive(ByteBuffer buffer) throws IOException {
		entityID = buffer.getInt();
		slot = buffer.getShort();
		itemID = buffer.getShort();
		damage = buffer.getShort();
		return true;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.putInt(entityID);
		buffer.putShort(slot);
		buffer.putShort(itemID);
		buffer.putShort(damage);
	}

	@Override
	public void received(PlayerPacketHandler handler) throws IOException {
		handler.receive(this);
	}
}