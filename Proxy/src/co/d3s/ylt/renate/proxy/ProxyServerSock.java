package co.d3s.ylt.renate.proxy;

import java.io.IOException;

import co.d3s.ylt.renate.network.socket.ServerSock;
import co.d3s.ylt.renate.player.Player;

public class ProxyServerSock extends ServerSock {
	ProxyServer server;
	public ProxyServerSock(ProxyServer server, String ip, int port) throws IOException {
		super(ip, port);
		this.server = server;
	}
	
	@Override
	public void doAccept() {
		try {
			server.sc.register(new Player(this));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
