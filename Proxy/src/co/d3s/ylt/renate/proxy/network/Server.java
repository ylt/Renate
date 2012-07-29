package co.d3s.ylt.renate.proxy.network;

import java.io.IOException;

import co.d3s.ylt.renate.network.protocol.Packet;
import co.d3s.ylt.renate.network.socket.ClientSock;
import co.d3s.ylt.renate.network.socket.ServerSock;

public class Server extends ClientSock {
	public Server(ServerSock ss) throws IOException {
		super(ss);
	}

	@Override
	public void packetReceived(Packet packet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doDisconnect() {
		// TODO Auto-generated method stub
		
	}

}
