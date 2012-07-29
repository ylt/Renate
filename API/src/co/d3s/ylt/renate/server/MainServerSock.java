package co.d3s.ylt.renate.server;

import java.io.IOException;

import co.d3s.ylt.renate.network.socket.ServerSock;
import co.d3s.ylt.renate.player.Player;

public class MainServerSock extends ServerSock {
	public MainServer server;
	public MainServerSock(MainServer server, String ip, int port) throws IOException {
		super(ip, port);
		this.server = server;
	}
	
	@Override
	public void doAccept() {
		try {
			server.sc.register(new Player(this, server));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
