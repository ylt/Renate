package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.PlayerPacketHandler;

public class Packet204Settings extends PlayerPacket {
	public Packet204Settings(Protocol protocol) {
		super(protocol);
	}
	
	private int msglen;
	public String lang;
	public int view;
	public byte chat;
	
	{
		bytes = type_short;
	}
	public boolean receive(ByteBuffer buffer) throws IOException {
		switch (i) {
		case 0:
			msglen = buffer.getShort();
			bytes = msglen * 2 + type_int + type_byte;
			break;
		case 1:
			lang = getString(buffer, msglen, 100); //TODO: Check if this is a big enough max length
			return true;
		}
		i++;
		return false;
	}
	
	@Override
	public void received(PlayerPacketHandler handler) throws IOException {
		handler.receive(this);
	}
}
