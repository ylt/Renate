package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;

public class Packet043SetExperience extends PlayerPacket {
	public Packet043SetExperience(Protocol protocol) {
		super(protocol);
	}

	public float ExperienceBar;
	public short Level;
	public short TotalXP;

	{
		bytes = type_float + type_short + type_short;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.putFloat(ExperienceBar);
		buffer.putShort(Level);
		buffer.putShort(TotalXP);
	}
}
