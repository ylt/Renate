package co.d3s.ylt.renate;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;
import java.util.Set;

import co.d3s.ylt.renate.protocol.Connection;
import co.d3s.ylt.renate.socket.SockManager;

public class NodeServer extends SockManager {
	public String addr;
	public int port = 25565;
	public ServerSocketChannel server = null;
	LinkedList<Connection> users = new LinkedList<Connection>();
	
	public NodeServer(int port) throws IOException {
		this("0.0.0.0", port);
	}
	public NodeServer(String addr, int port) throws IOException {
		this.addr = addr;
		this.port = port;
		
		server = ServerSocketChannel.open();
		server.socket().bind(new InetSocketAddress(addr, port));
		server.configureBlocking(false);
		
		selector = Selector.open();
	}
	public void tick() throws IOException {
		//used for receiving network data, parallelising threads, etc
		while(true) {
			SocketChannel sock = server.accept();
			if (sock == null) break;
			
			System.out.println("Accepted connection: "+sock);
			sock.configureBlocking(false);
			
			//new player
			Connection conn = new Connection(this, sock);
			users.add(conn);

			sock.register(selector, SelectionKey.OP_READ|SelectionKey.OP_WRITE, conn);
			
			sock.finishConnect();
		}
		

		//selector.selectNow();
		selector.select(1);
		Set<SelectionKey> keys = selector.selectedKeys();
		for(SelectionKey key: keys) {
			Connection con = (Connection)key.attachment();
			
			if (key.isWritable()) {
				con.protocol.write();
			}
			if (key.isReadable()) {
				con.protocol.read();
			}
		}
	}
	public static void main(String[] args) throws IOException {
		NodeServer server = new NodeServer("127.0.0.1",25565);
		while(true) {
			//System.out.println("tick.");
			server.tick();
		}
	}
}

