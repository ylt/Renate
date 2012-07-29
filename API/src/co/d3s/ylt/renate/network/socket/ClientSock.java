package co.d3s.ylt.renate.network.socket;

import java.io.IOException;
import java.nio.channels.SocketChannel;

import co.d3s.ylt.renate.network.protocol.Packet;
import co.d3s.ylt.renate.network.protocol.PacketType;

public abstract class ClientSock extends Sock {
	public SocketChannel channel;
	public PacketType packettype;
	//public PlayerPacketHandler packethandler;
	public SocketChannel channel() {
		return this.channel;
	}
	
	//protected ClientSock() { }
	
	public ClientSock(ServerSock ss) throws IOException {
		channel = ss.channel().accept();
		if (channel != null)
		channel.finishConnect(); //is this even needed?
	}

	public abstract void packetReceived(Packet packet);

	public abstract void doDisconnect();
}
