package co.d3s.ylt.renate.network.socket;

import java.io.IOException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

public abstract class SockManager {
	public Selector selector; 
	{
		try {
			selector = Selector.open();
		}
		catch(Exception e) {
			
		}
	}
	
	public boolean register(Sock sock) {
		if (sock == null) return false;
		
		sock.register(this);
		
		try {
			sock.channel().configureBlocking(false);
			sock.channel().register(selector,
					sock.channel().validOps()
					, sock);
		}
		catch (ClosedChannelException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public void tick() {
		try {
			selector.select();

			Set<SelectionKey> keys = selector.selectedKeys();
			Iterator<SelectionKey> keyIterator = keys.iterator();
			while(keyIterator.hasNext()) {
				SelectionKey key = keyIterator.next();
				try {
					Sock con = (Sock)key.attachment();
					
					if (key.isConnectable())
						con.doConnect();
					if (key.isWritable())
						con.doWrite();
					if (key.isReadable())
						con.doRead();
					if (key.isAcceptable())
						con.doAccept();
					//System.out.println(key);
					if (con.disconnected == true) {
						key.cancel();
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				keyIterator.remove();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
