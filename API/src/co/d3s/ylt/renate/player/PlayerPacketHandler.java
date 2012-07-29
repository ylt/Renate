package co.d3s.ylt.renate.player;

import co.d3s.ylt.renate.network.socket.PacketHandler;
import co.d3s.ylt.renate.player.protocol.Packet000KeepAlive;
import co.d3s.ylt.renate.player.protocol.Packet001Login;
import co.d3s.ylt.renate.player.protocol.Packet002Handshake;
import co.d3s.ylt.renate.player.protocol.Packet003Chat;
import co.d3s.ylt.renate.player.protocol.Packet004UpdateTime;
import co.d3s.ylt.renate.player.protocol.Packet005EntityEquipment;
import co.d3s.ylt.renate.player.protocol.Packet006SpawnPosition;
import co.d3s.ylt.renate.player.protocol.Packet007UseEntity;
import co.d3s.ylt.renate.player.protocol.Packet008UpdateHealth;
import co.d3s.ylt.renate.player.protocol.Packet009Respawn;
import co.d3s.ylt.renate.player.protocol.Packet010Flying;
import co.d3s.ylt.renate.player.protocol.Packet011PlayerPosition;
import co.d3s.ylt.renate.player.protocol.Packet012PlayerLook;
import co.d3s.ylt.renate.player.protocol.Packet013PlayerLookMove;
import co.d3s.ylt.renate.player.protocol.Packet014BlockDig;
import co.d3s.ylt.renate.player.protocol.Packet015Place;
import co.d3s.ylt.renate.player.protocol.Packet016BlockItemSwitch;
import co.d3s.ylt.renate.player.protocol.Packet017;
import co.d3s.ylt.renate.player.protocol.Packet018ArmAnimation;
import co.d3s.ylt.renate.player.protocol.Packet019EntityAction;
import co.d3s.ylt.renate.player.protocol.Packet020NamedEntitySpawn;
import co.d3s.ylt.renate.player.protocol.Packet021PickupSpawn;
import co.d3s.ylt.renate.player.protocol.Packet022Collect;
import co.d3s.ylt.renate.player.protocol.Packet023VehicleSpawn;
import co.d3s.ylt.renate.player.protocol.Packet024MobSpawn;
import co.d3s.ylt.renate.player.protocol.Packet025EntityPainting;
import co.d3s.ylt.renate.player.protocol.Packet026AddExpOrb;
import co.d3s.ylt.renate.player.protocol.Packet028EntityVelocity;
import co.d3s.ylt.renate.player.protocol.Packet029DestroyEntity;
import co.d3s.ylt.renate.player.protocol.Packet030Entity;
import co.d3s.ylt.renate.player.protocol.Packet031RelEntityMove;
import co.d3s.ylt.renate.player.protocol.Packet032EntityLook;
import co.d3s.ylt.renate.player.protocol.Packet033RelEntityMoveLook;
import co.d3s.ylt.renate.player.protocol.Packet034EntityTeleport;
import co.d3s.ylt.renate.player.protocol.Packet035HeadLook;
import co.d3s.ylt.renate.player.protocol.Packet038EntityStatus;
import co.d3s.ylt.renate.player.protocol.Packet039AttachEntity;
import co.d3s.ylt.renate.player.protocol.Packet040EntityMetadata;
import co.d3s.ylt.renate.player.protocol.Packet041MobEffect;
import co.d3s.ylt.renate.player.protocol.Packet042RemoveMobEffect;
import co.d3s.ylt.renate.player.protocol.Packet043SetExperience;
import co.d3s.ylt.renate.player.protocol.Packet050PreChunk;
import co.d3s.ylt.renate.player.protocol.Packet051MapChunk;
import co.d3s.ylt.renate.player.protocol.Packet052MultiBlockChange;
import co.d3s.ylt.renate.player.protocol.Packet053BlockChange;
import co.d3s.ylt.renate.player.protocol.Packet054PlayNoteBlock;
import co.d3s.ylt.renate.player.protocol.Packet060Explosion;
import co.d3s.ylt.renate.player.protocol.Packet061;
import co.d3s.ylt.renate.player.protocol.Packet070Bed;
import co.d3s.ylt.renate.player.protocol.Packet071Weather;
import co.d3s.ylt.renate.player.protocol.Packet100OpenWindow;
import co.d3s.ylt.renate.player.protocol.Packet101CloseWindow;
import co.d3s.ylt.renate.player.protocol.Packet102WindowClick;
import co.d3s.ylt.renate.player.protocol.Packet103SetSlot;
import co.d3s.ylt.renate.player.protocol.Packet104WindowItems;
import co.d3s.ylt.renate.player.protocol.Packet105CraftProgressBar;
import co.d3s.ylt.renate.player.protocol.Packet106Transaction;
import co.d3s.ylt.renate.player.protocol.Packet107SetCreativeSlot;
import co.d3s.ylt.renate.player.protocol.Packet108Enchantment;
import co.d3s.ylt.renate.player.protocol.Packet130UpdateSign;
import co.d3s.ylt.renate.player.protocol.Packet131;
import co.d3s.ylt.renate.player.protocol.Packet195Spout;
import co.d3s.ylt.renate.player.protocol.Packet200Statistic;
import co.d3s.ylt.renate.player.protocol.Packet201PlayerInfo;
import co.d3s.ylt.renate.player.protocol.Packet202Abilities;
import co.d3s.ylt.renate.player.protocol.Packet254GetInfo;
import co.d3s.ylt.renate.player.protocol.Packet255KickDisconnect;
import co.d3s.ylt.renate.player.protocol.PlayerPacket;

public abstract class PlayerPacketHandler extends PacketHandler {
	public void receive(Packet000KeepAlive packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet001Login packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet002Handshake packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet003Chat packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet004UpdateTime packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet005EntityEquipment packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet006SpawnPosition packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet007UseEntity packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet008UpdateHealth packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet009Respawn packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet010Flying packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet011PlayerPosition packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet012PlayerLook packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet013PlayerLookMove packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet014BlockDig packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet015Place packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet016BlockItemSwitch packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet017 packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet018ArmAnimation packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet019EntityAction packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet020NamedEntitySpawn packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet021PickupSpawn packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet022Collect packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet023VehicleSpawn packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet024MobSpawn packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet025EntityPainting packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet026AddExpOrb packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet028EntityVelocity packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet029DestroyEntity packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet030Entity packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet031RelEntityMove packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet032EntityLook packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet033RelEntityMoveLook packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet034EntityTeleport packet) {
		receive((PlayerPacket) packet);
	}
	public void receive(Packet035HeadLook packet){
		receive((PlayerPacket) packet);
	}

	public void receive(Packet038EntityStatus packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet039AttachEntity packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet040EntityMetadata packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet041MobEffect packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet042RemoveMobEffect packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet043SetExperience packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet050PreChunk packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet051MapChunk packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet052MultiBlockChange packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet053BlockChange packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet054PlayNoteBlock packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet060Explosion packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet061 packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet070Bed packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet071Weather packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet100OpenWindow packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet101CloseWindow packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet102WindowClick packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet103SetSlot packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet104WindowItems packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet105CraftProgressBar packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet106Transaction packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet107SetCreativeSlot packet) {
		receive((PlayerPacket) packet);
	}
	
	public void receive(Packet108Enchantment packet){
		receive((PlayerPacket) packet);
	}

	public void receive(Packet130UpdateSign packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet131 packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet195Spout packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet200Statistic packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet201PlayerInfo packet) {
		receive((PlayerPacket) packet);
	}
	
	public void receive(Packet202Abilities packet){
		receive((PlayerPacket) packet);
	}

	public void receive(Packet254GetInfo packet) {
		receive((PlayerPacket) packet);
	}

	public void receive(Packet255KickDisconnect packet) {
		receive((PlayerPacket) packet);
	}
}
