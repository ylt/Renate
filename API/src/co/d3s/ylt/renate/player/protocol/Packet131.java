package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;

public class Packet131 extends PlayerPacket {
	public Packet131(Protocol protocol){
		super(protocol);
	}
	public Packet131(short ID, short Value, byte Length, byte[] text){
		this.ID = ID;
		this.Value = Value;
		this.Length = Length;
		this.text = text;
	}
	
	public short ID = 358;
	public short Value;
	public byte Length;
	public byte[] text;
		
	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.put((byte) 131);
		buffer.putShort(ID);
		buffer.putShort(Value);
		buffer.put(Length);
		buffer.put(text);
	}
}
