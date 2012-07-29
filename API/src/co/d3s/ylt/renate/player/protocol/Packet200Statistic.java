package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;

public class Packet200Statistic extends PlayerPacket {

	public Packet200Statistic(Protocol protocol) {
		super(protocol);
	}

	public int ID;
	public byte Ammount;

	{
		bytes = type_int + type_byte;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.putInt(ID);
		buffer.put(Ammount);
	}
}
