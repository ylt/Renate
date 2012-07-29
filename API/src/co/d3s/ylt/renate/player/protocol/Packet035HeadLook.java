package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;

public class Packet035HeadLook extends PlayerPacket {
	public Packet035HeadLook(Protocol protocol) {
		super(protocol);
	}
	
	public Packet035HeadLook(int EID, int YAW){
		this.EID = EID;
		this.YAW = YAW;
	}
	
	public int EID;
	public int YAW;
	
	{
		bytes = type_int * 2;
	}
	
	public boolean receive(ByteBuffer buffer) throws IOException {
		buffer.getInt(EID);
		buffer.getInt(YAW);
		return true;
	}
	
	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.put((byte) 35);
		buffer.putInt(EID);
		buffer.putInt(YAW);
	}
}
