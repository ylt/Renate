package co.d3s.ylt.renate.player;

import co.d3s.ylt.renate.network.protocol.Packet;
import co.d3s.ylt.renate.player.protocol.Packet001Login;
import co.d3s.ylt.renate.player.protocol.Packet002Handshake;
import co.d3s.ylt.renate.player.protocol.Packet254GetInfo;
import co.d3s.ylt.renate.player.protocol.Packet255KickDisconnect;

public class PlayerLoginHandler extends PlayerPacketHandler {
	Player connection;

	public PlayerLoginHandler(Player connection) {
		this.connection = connection;
	}

	// https://github.com/Bukkit/mc-dev/blob/master/net/minecraft/server/NetLoginHandler.java

	public String user;

	public void receive(Packet packet) {
		System.out.print("Other: "+packet);
		// unhandled packet.
		connection.kick("You must be logged in to use that packet.");
		System.out.println("[Login] unhandled: " + packet);
	}

	public void receive(Packet002Handshake packet) {
		System.out.println("Handshake: "+packet+", "+packet.hash);
		connection.protocol.send(new Packet002Handshake("-"));
		this.user = packet.getDetails().user;
	}

	public void receive(Packet001Login packet) {
		System.out.println("Login: "+packet+", "+packet.username+" = "+user);
		if (!packet.username.equals(user)) { // a security check minecraft
												// server doesn't have!
			connection.kick("Unmatching username.");
			return;
		}  
		if (packet.version != 29) {
			if (packet.version > 29) {
				connection.kick("Outdated server!");
			} else {
				connection.kick("Outgamed client(game)!");
			}
		}

		connection.protocol.send(new Packet001Login(1337, "DEFAULT", 1, (byte) 0,
				(byte) 0, (byte) -128, (byte) 1337));
		connection.username = packet.username;
		connection.packethandler = new PlayerGameHandler(connection);
		
	}

	public void receive(Packet254GetInfo packet) {
		System.out.println("Info: "+packet);
		connection.protocol.send(new Packet255KickDisconnect("a" + "\u00A7"
				+ 10 + "\u00A7" + 1337));
	}
}