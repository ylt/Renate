package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;
import co.d3s.ylt.renate.player.PlayerPacketHandler;

public class Packet001Login extends PlayerPacket {
	public Packet001Login(Protocol protocol) {
		super(protocol);
	}

	public Packet001Login(int entityid, String level, int servermode,
			byte atmosphere, byte difficulty, byte height, byte maxplayers) {

		this.version = entityid;
		this.leveltype = level;
		this.mode = servermode;
		this.atmosphere = atmosphere;
		this.difficulty = difficulty;
		this.height = height;
		this.maxplayer = maxplayers; //TODO: Limit to <=60 so usernames dont overlap on TAB
	}

	{
		bytes = type_int + type_short;
	}

	public int version; // <version >entity-id
	private short strlen;
	public String username = ""; // <username
	public String leveltype = "";
	public int mode; // >server mode
	public int atmosphere; // >dimension
	public byte difficulty; // >difficulty
	public short height; // >world height
	public short maxplayer; // >max players

	@Override
	public boolean receive(ByteBuffer buffer) throws IOException {
		switch (i) {
		case 0:
			version = buffer.getInt();
			strlen = buffer.getShort();
			bytes = (strlen * 2);
			break;
		case 1:
			username = getString(buffer, strlen, 16);
			strlen = buffer.getShort();
			bytes = (strlen * 2) + type_int + type_int + type_byte + type_byte + type_byte;
			break;
		case 2:
			leveltype = getString(buffer, strlen, 9);
			
			mode = buffer.getInt();
			atmosphere = buffer.getInt();
			difficulty = buffer.get();
			height = (short) (buffer.get() & 0xff);
			maxplayer = (short) (buffer.get() & 0xff);
			return true;

		}
		i++;
		return false;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.put((byte) 1);
		buffer.putInt(version);
		putString(username, buffer);
		putString(leveltype, buffer);
		buffer.putInt(mode);
		buffer.putInt(atmosphere);
		buffer.put(difficulty);
		buffer.put((byte) height);
		buffer.put((byte) maxplayer);
	}

	@Override
	public void received(PlayerPacketHandler handler) throws IOException {
		handler.receive(this);
	}
}