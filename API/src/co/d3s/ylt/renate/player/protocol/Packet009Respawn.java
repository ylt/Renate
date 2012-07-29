package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;
import co.d3s.ylt.renate.player.PlayerPacketHandler;

public class Packet009Respawn extends PlayerPacket {
	public Packet009Respawn(Protocol protocol) {
		super(protocol);
	}

	public int Atmosphere;
	public byte difficulty;
	public byte mode;
	public short world_height;
	private short strlen;
	public String type;

	{
		bytes = type_byte + type_byte + type_byte + type_short + type_long;
	}

	@Override
	public boolean receive(ByteBuffer buffer) throws IOException {
		switch (i) {
		case 0:
			Atmosphere = buffer.getInt();
			difficulty = buffer.get();
			mode = buffer.get();
			world_height = buffer.getShort();
			bytes = (strlen * 2);
			break;
		case 1:
			type = getString(buffer, strlen, 16);
			return true;
		}
		i++;
		return false;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.put((byte) 9);
		buffer.putInt(Atmosphere);
		buffer.put(difficulty);
		buffer.put(mode);
		buffer.putShort(world_height);
		putString(type, buffer);
	}

	@Override
	public void received(PlayerPacketHandler handler) throws IOException {
		handler.receive(this);
	}
}
