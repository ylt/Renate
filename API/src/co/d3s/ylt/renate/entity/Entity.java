package co.d3s.ylt.renate.entity;

import java.io.IOException;
import java.util.List;

import co.d3s.ylt.renate.entity.behaviour.Behaviour;
import co.d3s.ylt.renate.network.protocol.Sendable;
import co.d3s.ylt.renate.network.socket.ClientSock;
import co.d3s.ylt.renate.player.Player;

/*
  	Entities are simply skins, contained within them are the behaviours which alter their containing entity.
  	They're directly sendable, so packets don't need to be pre-generated, at time of sending fields
  	 will be pre-filled at time of sending.
 */
public abstract class Entity implements Sendable {
	public int EID;
	public int X;
	public int Y;
	public int Z;
	public byte Yaw;
	public byte Pitch;
	public byte HeadYaw;
	public String world;
	//public byte HeadYaw;
	public List<Behaviour> behaviours;
	public void tick() {
		for (Behaviour behaviour : behaviours) {
			behaviour.tick(this);
		}
	}
	
	public void send(ClientSock user) throws IOException {
		if (user instanceof Player)
			send((Player)user);
	}

	public String getWorld() {
		return world;
	}

	public void setWorld(String world) {
		this.world = world;
	}
	
	
}
