package co.d3s.ylt.renate.entity;

import java.io.IOException;

import co.d3s.ylt.renate.entity.behaviour.Behaviour;
import co.d3s.ylt.renate.network.socket.ClientSock;
import co.d3s.ylt.renate.player.Player;
import co.d3s.ylt.renate.player.protocol.Packet020NamedEntitySpawn;
import co.d3s.ylt.renate.player.protocol.Packet024MobSpawn;

public class Human extends Entity {
	String name;
	short item = 0;
	public Human(String name, Behaviour[] behaviour, double x, double y, double z) {
		this.name = name;
		this.X = (int) x;
		this.Y = (int) y;
		this.Z = (int) z;
	}
	public Human(Behaviour[] behaviour, double x, double y, double z) {
		
	}
	
	@SuppressWarnings("unused")
	public void send(Player player) throws IOException {
		if (true) { //check if we've already sent to player - somehow
			if (name == null) { //avoid empty nametag
				//spawn "Monster" - 49
				//new Packet024MobSpawn(EID, (byte)49 /*TODO: use external reference later*/, X, Y, Z, Yaw, Pitch, HeadYaw).send(player);
			}
			else {
				//spawn player
				new Packet020NamedEntitySpawn(EID, name, X, Y, Z, Yaw, Pitch, item).send(player);
			}
		}
		else { //send movement then
			
		}
	}
}
