package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;

public class Packet201PlayerInfo extends PlayerPacket {

	public Packet201PlayerInfo(Protocol protocol) {
		super(protocol);
	}

	public Packet201PlayerInfo(String Player, byte Online, short Ping) {
		this.player = Player;
		this.Online = Online;
		this.Ping = Ping;
	}

	public String player;
	public byte Online;
	public short Ping;

	{
		bytes = type_short + type_byte + type_short;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.put((byte) 201);
		putString(this.player, buffer);
		buffer.put(Online);
		buffer.putShort(Ping);
	}
}
