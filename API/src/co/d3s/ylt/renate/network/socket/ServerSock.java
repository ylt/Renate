package co.d3s.ylt.renate.network.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;

public abstract class ServerSock extends Sock {
	ServerSocketChannel channel;
	public ServerSocketChannel channel() {
		return this.channel;
	}
	
	//protected ServerSock() { }
	
	public ServerSock(int port) throws IOException {
		this("0.0.0.0", port);
	}
	public ServerSock(String addr, int port) throws IOException {
		channel = ServerSocketChannel.open();
		channel.socket().bind(new InetSocketAddress(addr, port));
		channel.configureBlocking(false);
	}
}
