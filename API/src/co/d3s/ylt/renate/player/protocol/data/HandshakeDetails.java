package co.d3s.ylt.renate.player.protocol.data;

import java.net.InetSocketAddress;

public class HandshakeDetails {
	public String user;
	public InetSocketAddress host;
	public HandshakeDetails(String user, String host) {
		this.user = user;
		String hostsplit[] = host.split(":"); //not suitable for IPV6
		this.host = new InetSocketAddress(hostsplit[0], Short.parseShort(hostsplit[1])); 
	}
}