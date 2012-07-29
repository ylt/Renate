package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;
import co.d3s.ylt.renate.player.PlayerPacketHandler;

public class Packet008UpdateHealth extends PlayerPacket {
	public Packet008UpdateHealth(Protocol protocol) {
		super(protocol);
	}

	public short Health;
	public short Food;
	public float Food_Saturation;

	{
		bytes = type_short + type_short + type_float;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.putShort(Health);
		buffer.putShort(Food);
		buffer.putFloat(Food_Saturation);
	}

	@Override
	public void received(PlayerPacketHandler handler) throws IOException {
		handler.receive(this);
	}
}
