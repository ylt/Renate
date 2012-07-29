package co.d3s.ylt.renate.network.socket;

import java.nio.channels.spi.AbstractSelectableChannel;

public abstract class Sock {
	public abstract AbstractSelectableChannel channel();
	public SockManager sockman;
	public boolean disconnected;
	
	protected Sock() { }
	
	/*public void register(SockManager sockman) {
		this.sockman = sockman;
		sockman.register(this);
	}*/
	
	protected void register(SockManager sockman) {
		this.sockman = sockman;
	}
	
	/*Client Sock - override what is needed */
	public void doConnect() {
		
	}
	public void doRead() {
		
	}
	public void doWrite() {
		
	}
	
	/*Server Sock - override what is needed*/ //This is actually only used for the client's  side of this
	public void doAccept() {
	}
}
