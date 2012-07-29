package co.d3s.ylt.renate.network.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

import co.d3s.ylt.renate.network.socket.ClientSock;
import co.d3s.ylt.renate.player.Player;

public class Packet implements Sendable {
	Protocol protocol;

	public static final int type_bool = 1;
	public static final int type_byte = 1;
	public static final int type_short = 2;
	public static final int type_int = 4;
	public static final int type_long = 8;
	public static final int type_float = 4;
	public static final int type_double = 8;
	public static final int type_char = 2;

	public Packet() {
	}

	public Packet(Protocol protocol) {
		this.protocol = protocol;
	}

	public int bytes = 1;

	public int i = 0;

	public boolean receive(ByteBuffer in_buffer) throws IOException {
		int id = in_buffer.get() & 255;
		protocol.set(id);
		return false;
	}

	public void send(Player player) throws IOException {
		return;
	}

	public static void putString(String string, ByteBuffer buffer)
			throws IOException {
		if (string.length() > 32767)
			throw new IOException("String too big");

		buffer.putShort((short) string.length());

		/*
		 * CharBuffer cbuffer = buffer.asCharBuffer(); cbuffer.put(string);
		 */
		CharBuffer cbuffer = CharBuffer.wrap(string);
		while (cbuffer.hasRemaining()) {
			buffer.putChar(cbuffer.get());
		}
	}

	public static String getString(ByteBuffer datainputstream, int length,
			int max) throws IOException {
		if (length > max)
			throw new IOException(
					"Received string length longer than maximum allowed ("
							+ length + " > " + max + ")");
		if (length < 0) {
			throw new IOException(
					"Received string length is less than zero! Weird string!");
		}
		StringBuilder stringbuilder = new StringBuilder();

		for (int j = 0; j < length; j++) {
			stringbuilder.append(datainputstream.getChar());
		}

		return stringbuilder.toString();
	}

	public void send(ClientSock user) throws IOException {
		if (user instanceof Player)
			send((Player)user);
	}
}
