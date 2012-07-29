package co.d3s.ylt.renate.server;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import co.d3s.ylt.renate.entity.Entity;
import co.d3s.ylt.renate.network.protocol.Packet;
import co.d3s.ylt.renate.network.protocol.Sendable;
import co.d3s.ylt.renate.network.socket.SockManager;
import co.d3s.ylt.renate.player.Player;
import co.d3s.ylt.renate.world.World;

public class MainServer {
	public static void main(String[] args) throws IOException {
		new MainServer().start();
	}
	
	public MainSockManager sc;
	
	//contains duplicate data, used for different purposes
	//*may* be moved to a "worldmanager" at a later date
	List<World> worlds = new LinkedList<World>();
	HashMap<String,World> worldnames;
	
	//entities are simply stored here for quick iteration
	public List<Player> players = new LinkedList<Player>(); //TODO: consider a different list type later 
	
	public MainServer() {
		//server startup :D
		sc = new MainSockManager();
		
		World world = new World("lolol");
		worlds.add(world);
	}
	
	public void start() throws IOException {
		MainServerSock serversock = new MainServerSock(this, "0.0.0.0", 25565); //TODO: make more dynamic in future
		
		sc.register(serversock);
		
		while(true) {
			tick();
		}
	}
	public void tick() {
		for(World world : worlds) { /*TODO: multithread later*/
			world.tick();
		}
		for(Player player : players){
			player.tick(player.entity);		
		}
		sc.tick(); //will be socket thread
	}
	public void sendToAll(Sendable send) {
		for (Player player : players) {
			try {
				System.out.println("Yay it works :D " + player.username);
				send.send(player);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void sendToAll(Packet packet) {
		for (Player player : players) {
			System.out.println("Yay it works :D " + player.username);
			player.protocol.send(packet);
		}
	}
	
	public void sendToAll(Sendable send, PacketCondition condition) {
		for (Player player : players) {
			if (condition.check(player, send)) {
				try {
					send.send(player);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
