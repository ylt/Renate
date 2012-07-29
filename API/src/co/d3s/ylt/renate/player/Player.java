package co.d3s.ylt.renate.player;

import java.io.IOException;

import co.d3s.ylt.renate.Location;
import co.d3s.ylt.renate.entity.Entity;
import co.d3s.ylt.renate.entity.Human;
import co.d3s.ylt.renate.world.World;
import co.d3s.ylt.renate.entity.behaviour.Behaviour;
import co.d3s.ylt.renate.network.protocol.Packet;
import co.d3s.ylt.renate.network.protocol.Protocol;
import co.d3s.ylt.renate.network.socket.ClientSock;
import co.d3s.ylt.renate.network.socket.ServerSock;
import co.d3s.ylt.renate.player.protocol.Packet003Chat;
import co.d3s.ylt.renate.player.protocol.Packet255KickDisconnect;
import co.d3s.ylt.renate.player.protocol.PlayerPacket;
import co.d3s.ylt.renate.server.MainServer;
import co.d3s.ylt.renate.server.MainServerSock;

public class Player extends ClientSock implements Behaviour {
	public PlayerPacketHandler packethandler = new PlayerLoginHandler(this);
	{
		packettype = new PlayerPacketType();
	}
	public Protocol protocol =  new Protocol(this);
	public String username;
	public Entity entity;
	int X;
	int Y;
	int Z;
	public byte Yaw;
	public byte Pitch;
	public World world;
	public int chunkradius;
	public MainServer server;
	public Player(ServerSock ss, MainServer server) throws IOException {
		super(ss);
		this.server = server; 
		server.players.add(this);
		System.out.println("Client connected");
	}
	@Override
	public void doConnect() {
		//no purpose *yet*
	}
	
	@Override
	public void doWrite() {
		try {
			protocol.write();
		} catch (IOException e) { //handle exceptions some *better* way later
			e.printStackTrace();
		}
	}
	
	@Override
	public void doRead() {
		//System.out.println("Read..."); //STOP SPAMING MY SCREEN!!!!
		protocol.read(); //this directly results in calls to packetReceived(Packet)
	}
	
	@Override
	public void packetReceived(Packet packet) {
		try {
			((PlayerPacket)packet).received(packethandler);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void kick() {
		kick("\u00A7" + "eYou have been kicked.");
	}

	public void kick(String message) {
		protocol.send(new Packet255KickDisconnect(message));
	}
	
	public boolean isOnground(){
		return false;
	}
	
	public void command(String message) {
		String[] args = message.split(" ");
		String command = args[0].substring(1); //TODO: Must be a better way then turning it into array just to put it back to string
		System.out.println("Recieved command: " + command);
		if (command.equalsIgnoreCase("helloworld")) {
			protocol.send(new Packet003Chat("Hello World."));
		}else if(command.equalsIgnoreCase("me")) {
			server.sendToAll(new Packet003Chat("\u00A7" + "e*" + this.username + message.substring(3)));
			//protocol.send(new Packet003Chat("\u00A7" + "e*" + this.username + message.substring(3)));
		}else if(command.equalsIgnoreCase("players")){
			String online = "";
			for(Player player : server.players){
				online = online + player.username + ", ";
			}
			protocol.send(new Packet003Chat("\u00A7" + "e" + online));
		}else{
			protocol.send(new Packet003Chat("\u00A7" + "cUnknown command. Type \"help\" for help."));
		}
	}
	
	
	//behaviour implementation

	/* @Override override broken? wtf? */
	public void tick(Entity entity) {
		/*entity.X = X;
		entity.Y = Y;
		entity.Z = Z;
		entity.Yaw = Yaw;
		entity.Pitch = Pitch;*/
		Location o = new Location(world, X, Y, Z);
		for(Player player : server.players){
			if(o.distance(new Location(world, player.X, player.Y, player.Z)) < 200){
				Human entityplayer = new Human(player.username, null, (double)player.X, (double)player.Y, (double)player.Z);
		        /*try {
					entityplayer.send(player);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			}
		}
		//should be using some move method later
	}
	
	@Override
	public void doDisconnect() {
		this.disconnected = true;
		server.players.remove(this);
		System.out.println(username + " has quit.");
		server.sendToAll(new Packet003Chat("\u00A7" + "e" + username + " left the game."));
	}
}
