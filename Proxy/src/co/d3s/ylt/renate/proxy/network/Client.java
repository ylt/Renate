package co.d3s.ylt.renate.proxy.network;

import java.io.IOException;

import co.d3s.ylt.renate.network.protocol.Packet;
import co.d3s.ylt.renate.network.socket.ClientSock;
import co.d3s.ylt.renate.network.socket.ServerSock;

public class Client extends ClientSock {
	public Client(ServerSock ss) throws IOException {
		super(ss);
	}

	@Override
	public void packetReceived(Packet packet) {
		
	}

	@Override
	public void doDisconnect() {
		
	}

}
