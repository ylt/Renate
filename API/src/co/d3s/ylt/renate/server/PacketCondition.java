package co.d3s.ylt.renate.server;

import co.d3s.ylt.renate.network.protocol.Sendable;
import co.d3s.ylt.renate.player.Player;

public interface PacketCondition {
	public boolean check(Player player, Sendable send);
}
