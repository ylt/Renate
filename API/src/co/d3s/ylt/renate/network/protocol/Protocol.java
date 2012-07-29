package co.d3s.ylt.renate.network.protocol;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.nio.ByteBuffer;
import java.nio.channels.CancelledKeyException;
import java.util.LinkedList;

import co.d3s.ylt.renate.network.socket.ClientSock;
import co.d3s.ylt.renate.player.Player;

public class Protocol {
	ByteBuffer in_buffer = ByteBuffer.allocateDirect(1024 * 10);
	public ByteBuffer out_buffer = ByteBuffer.allocateDirect(1024 * 10);
	LinkedList<Sendable> out_queue = new LinkedList<Sendable>();

	ClientSock user;

	public Protocol(ClientSock user) {
		this.user = user;

		set(Packet.class);
		in_buffer.limit(0);

		out_buffer.flip();
	}

	Packet packet;

	public void set(int id) {
		//System.out.println("Fetching ID: "+id);
		Class<?> packet = user.packettype.get(id);
		//System.out.println("New packet: "+packet);
		if (packet != null)
			set(packet);
		else {
			//disconnect
			user.disconnected = true;
			System.out.println("User disconnected (invalid packet).");
			try {
				user.channel().close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("reading packet "+id+": "+packet);
	}

	@SuppressWarnings("rawtypes")
	public void set(Class packet) {
		try {
			@SuppressWarnings("unchecked")
			Constructor<Packet> construct = packet
					.getConstructor(new Class[] { Protocol.class });
			this.packet = construct.newInstance(new Object[] { this });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void read() {
		try {
			in_buffer.compact();
			if (user.channel.read(in_buffer) < 0) {
				throw new CancelledKeyException(); /* why doesn't Java do this by default? */
			}
			in_buffer.flip();

			while (in_buffer.remaining() >= packet.bytes) {
				if (packet.receive(in_buffer)) {
					//packet.received(user.packethandler);
					user.packetReceived(packet);
					set(Packet.class);
				}
			}
		}
		catch (CancelledKeyException e) {
			user.doDisconnect();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void send(Packet packet) {
		out_queue.addLast(packet);
	}

	public void write() throws IOException {
		if (out_buffer.remaining() <= 0 && !out_queue.isEmpty()) {
			out_buffer.compact();
			//out_queue.removeFirst().send(out_buffer); // possible: IOException
			out_queue.removeFirst().send(user); // possible: IOException //TODO: improve later :/
			out_buffer.flip();
		}
		if (out_buffer.hasRemaining()) {
			user.channel.write(out_buffer); // possible: IOException
		}
	}
}

class IOClosedException extends IOException {}
