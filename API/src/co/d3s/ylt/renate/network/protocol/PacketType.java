package co.d3s.ylt.renate.network.protocol;

import java.util.HashMap;
import java.util.HashSet;

public class PacketType {

	// private HashMap<Integer,Class<?>> index = new
	// HashMap<Integer,Class<?>>();
	private Class<?>[] index = new Class<?>[256];
	private HashMap<Class<?>, Integer> list = new HashMap<Class<?>, Integer>();
	private HashSet<Integer> client = new HashSet<Integer>();
	private HashSet<Integer> server = new HashSet<Integer>();

	protected void add(int id, boolean flag, boolean flag1, Class<?> packet) {
		// if (index.containsKey(id)) {
		if (index[id] != null) {
			throw new IllegalArgumentException("Duplicate packet id:" + id);
		}
		if (list.containsKey(packet)) { // maybe worth nulling?
			throw new IllegalArgumentException("Duplicate packet class:"
					+ packet);
		}

		// index.put(id, packet);
		index[id] = packet;
		list.put(packet, id);
		if (flag) {
			client.add(id);
		}

		if (flag1) {
			server.add(id);
		}
	}

	public Class<?> get(int id) {
		// return index.get(id);
		return index[id];
	}
}