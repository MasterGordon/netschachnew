package schach.server;

import java.util.UUID;

import schach.Packet;

public class ConnectedClient {
	int port;
	String ip;
	boolean loggedIn;
	int elo;
	String username;
	UUID game;
	SchachServer server;
	String challengeing;
	
	public ConnectedClient(String ip,int port, SchachServer server) {
		this.ip = ip;
		this.port = port;
		this.server = server;
	}
	
	public void send(String s) {
		server.send(ip, port, s);
	}

	public void send(Packet packet) {
		server.send(ip, port, packet.save());
	}
	
	public String getFriends() {
		return "";
	}
}
