package co.d3s.ylt.renate.player;

import co.d3s.ylt.renate.network.protocol.PacketType;
import co.d3s.ylt.renate.player.protocol.*;

public class Player_PacketType extends PacketType {
	public Player_PacketType() {
		add(0, true, true, Packet000KeepAlive.class);
		add(1, true, true, Packet001Login.class);
		add(2, true, true, Packet002Handshake.class);
		add(3, true, true, Packet003Chat.class);
		add(4, true, false, Packet004UpdateTime.class);
		add(5, true, false, Packet005EntityEquipment.class);
		add(6, true, false, Packet006SpawnPosition.class);
		add(7, false, true, Packet007UseEntity.class);
		add(8, true, false, Packet008UpdateHealth.class);
		add(9, true, true, Packet009Respawn.class);
		add(10, true, true, Packet010Flying.class);
		add(11, true, true, Packet011PlayerPosition.class);
		add(12, true, true, Packet012PlayerLook.class);
		add(13, true, true, Packet013PlayerLookMove.class);
		add(14, false, true, Packet014BlockDig.class);
		add(15, false, true, Packet015Place.class);
		add(16, false, true, Packet016BlockItemSwitch.class);
		add(17, true, false, Packet017.class);
		add(18, true, true, Packet018ArmAnimation.class);
		add(19, false, true, Packet019EntityAction.class);
		add(20, true, false, Packet020NamedEntitySpawn.class);
		add(21, true, false, Packet021PickupSpawn.class);
		add(22, true, false, Packet022Collect.class);
		add(23, true, false, Packet023VehicleSpawn.class);
		add(24, true, false, Packet024MobSpawn.class);
		add(25, true, false, Packet025EntityPainting.class);
		add(26, true, false, Packet026AddExpOrb.class);
		add(28, true, false, Packet028EntityVelocity.class);
		add(29, true, false, Packet029DestroyEntity.class);
		add(30, true, false, Packet030Entity.class);
		add(31, true, false, Packet031RelEntityMove.class);
		add(32, true, false, Packet032EntityLook.class);
		add(33, true, false, Packet033RelEntityMoveLook.class);
		add(34, true, false, Packet034EntityTeleport.class);
		add(38, true, false, Packet038EntityStatus.class);
		add(39, true, false, Packet039AttachEntity.class);
		add(40, true, false, Packet040EntityMetadata.class);
		add(41, true, false, Packet041MobEffect.class);
		add(42, true, false, Packet042RemoveMobEffect.class);
		add(43, true, false, Packet043SetExperience.class);
		add(50, true, false, Packet050PreChunk.class);
		add(51, true, false, Packet051MapChunk.class);
		add(52, true, false, Packet052MultiBlockChange.class);
		add(53, true, false, Packet053BlockChange.class);
		add(54, true, false, Packet054PlayNoteBlock.class);
		add(60, true, false, Packet060Explosion.class);
		add(61, true, false, Packet061.class);
		add(70, true, false, Packet070Bed.class);
		add(71, true, false, Packet071Weather.class);
		add(100, true, false, Packet100OpenWindow.class);
		add(101, true, true, Packet101CloseWindow.class);
		add(102, false, true, Packet102WindowClick.class);
		add(103, true, false, Packet103SetSlot.class);
		add(104, true, false, Packet104WindowItems.class);
		add(105, true, false, Packet105CraftProgressBar.class);
		add(106, true, true, Packet106Transaction.class);
		add(107, true, true, Packet107SetCreativeSlot.class);
		add(108, true, false, Packet108Enchantment.class);
		add(130, true, true, Packet130UpdateSign.class);
		add(131, true, false, Packet131.class);
		add(200, true, false, Packet200Statistic.class);
		add(201, true, false, Packet201PlayerInfo.class);
		add(202, true, true, Packet202Abilities.class);
		add(250, true, true, Packet250PluginChannel.class);
		add(254, false, true, Packet254GetInfo.class);
		add(255, true, true, Packet255KickDisconnect.class);

		add(195, true, true, Packet195Spout.class);
	}
}
