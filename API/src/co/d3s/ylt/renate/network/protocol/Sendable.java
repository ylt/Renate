package co.d3s.ylt.renate.network.protocol;

import java.io.IOException;

import co.d3s.ylt.renate.network.socket.ClientSock;
import co.d3s.ylt.renate.player.Player;

public interface Sendable {
	public void send(Player player) throws IOException;

	public void send(ClientSock user) throws IOException;
}
