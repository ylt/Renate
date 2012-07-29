package co.d3s.ylt.renate.player.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.player.Player;
import co.d3s.ylt.renate.player.PlayerPacketHandler;

public class Packet202Abilities extends PlayerPacket {

	public Packet202Abilities(Protocol protocol){
		super(protocol);
	}
	public Packet202Abilities(byte canInvulnerability, byte isFlying, byte canFly, byte canInstantDestroy) {
		this.canInvulnerability = canInvulnerability;
		this.isFlying = isFlying;
		this.canFly = canFly;
		this.canInstantDestroy = canInstantDestroy;
	}
	
	public byte canInvulnerability;
	public byte isFlying;
	public byte canFly;
	public byte canInstantDestroy;
	
	{
		bytes = type_byte * 4;
	}
	
	public boolean receive(ByteBuffer buffer) throws IOException {
		buffer.get(canInvulnerability);
		buffer.get(isFlying);
		buffer.get(canFly);
		buffer.get(canInstantDestroy);
		return true;
	}

	public void send(Player player) throws IOException {
		ByteBuffer buffer = player.protocol.out_buffer;
		buffer.put((byte) 202);
		buffer.put(canInvulnerability);
		buffer.put(isFlying);
		buffer.put(canFly);
		buffer.put(canInstantDestroy);
	}
	
	public void received(PlayerPacketHandler handler) throws IOException {
		handler.receive(this);
	}
}
