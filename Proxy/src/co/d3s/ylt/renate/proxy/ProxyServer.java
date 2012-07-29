package co.d3s.ylt.renate.proxy;

import java.io.IOException;

public class ProxyServer {
	public static void main(String[] args) throws IOException {
		new ProxyServer().start();
	}
	
	public ProxySockManager sc;

	public ProxyServer() {
		//server startup :D
		sc = new ProxySockManager();

	}
	
	public void start() throws IOException {
		ProxyServerSock serversock = new ProxyServerSock(this, "0.0.0.0", 25565); //TODO: make more dynamic in future
		
		sc.register(serversock);
		
		while(true) {
			tick();
		}
	}
	public void tick() {
		sc.tick(); //will be socket thread
	}
}