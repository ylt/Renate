package co.d3s.ylt.renate.player;

import co.d3s.ylt.renate.entity.Human;
import co.d3s.ylt.renate.network.protocol.Packet;
import co.d3s.ylt.renate.player.protocol.Packet000KeepAlive;
import co.d3s.ylt.renate.player.protocol.Packet003Chat;
import co.d3s.ylt.renate.player.protocol.Packet010Flying;
import co.d3s.ylt.renate.player.protocol.Packet013PlayerLookMove;
import co.d3s.ylt.renate.player.protocol.Packet050PreChunk;
import co.d3s.ylt.renate.player.protocol.Packet051MapChunk;
import co.d3s.ylt.renate.player.protocol.Packet053BlockChange;
import co.d3s.ylt.renate.player.protocol.Packet201PlayerInfo;
import co.d3s.ylt.renate.player.protocol.Packet202Abilities;
import co.d3s.ylt.renate.player.protocol.Packet255KickDisconnect;

import java.io.IOException;
import java.util.*;
import java.util.zip.Deflater;

public class PlayerGameHandler extends PlayerPacketHandler {
	Player connection;

	public PlayerGameHandler(Player connection) {
		this.connection = connection;
		//Chunk
		/*byte[] mapInfo = null;
		mapInfo[0] = 1;
		mapInfo[1] = 1;
		mapInfo[2] = 1;
		byte[] chunk = new byte[100];
	    Deflater compresser = new Deflater();
	    compresser.setInput(mapInfo);
	    compresser.finish();
	    int compressedSize = compresser.deflate(chunk);*/
	    //end Chunk  
	     
		//connection.kick("\u00A7" + "eThere aint no map, sorry 'bout that");
		Random generator = new Random();
		this.connection.protocol.send(new Packet000KeepAlive(generator.nextInt()));
		this.connection.protocol.send(new Packet050PreChunk(0,0,(byte)0));
		this.connection.protocol.send(new Packet202Abilities((byte)0x1,(byte)0x1,(byte)0x1,(byte)0x1));
		//this.connection.protocol.send(new Packet051MapChunk(0, 0, (byte) 0x1, (short) 1, (short) 0, compressedSize, 0, chunk));
        this.connection.protocol.send(new Packet013PlayerLookMove(0,0,0, 0, 0, 0, (byte) 0));
        this.connection.server.sendToAll(new Packet003Chat("\u00A7" + "e" + this.connection.username + " joined the game."));
	}

	public void receive(Packet packet) {
		System.out.println("[Player] unhandled: " + packet);
	}
	
	public void receive(Packet013PlayerLookMove packet){
		System.out.println("Received a lookmove!");
	}
	
	public void receive(Packet003Chat packet) {
		if (packet.message.startsWith("/")){
			connection.command(packet.message);
		}else {
			System.out.println(this.connection.username + ": " + packet.message);
			this.connection.server.sendToAll(new Packet003Chat(this.connection.username + ": " + packet.message));
		}
	}
    

	// https://github.com/Bukkit/mc-dev/blob/master/net/minecraft/server/NetServerHandler.java

	public void receive(Packet000KeepAlive packet) {
		 connection.protocol.send(new Packet000KeepAlive(packet.Num));
	}

	// public void
}
