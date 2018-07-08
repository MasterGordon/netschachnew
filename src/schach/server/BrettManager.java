package schach.server;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.UUID;

import schach.Packet;

public class BrettManager {
	SchachServer server;
	HashMap<UUID, Brett> games = new HashMap<UUID, Brett>();

	public BrettManager(SchachServer server) {
		this.server = server;
	}

	public int saveReplay(String replay) {
		int replayID = 0;
		try {
			Statement stat = server.connectionManager.conn.createStatement();
			stat.executeUpdate("INSERT INTO replays values (null, '" + replay + "');");
			ResultSet rs = stat.executeQuery("select * from replays WHERE 'packet' = '" + replay + "';");
			if (rs.next()) {
				replayID = rs.getInt("id");
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return replayID;
	}
	
	public void sendReplay(String ip,int port,Packet packet) {
		if(!packet.getAction().equals("getreplay")) {
			return;
		}
	}
	
	public void challenge(String ip,int port,Packet packet) {
		ConnectedClient cc = server.connectionManager.getClientFromIpPort(ip, port);
		if(server.connectionManager.clientsUsername.containsKey(packet.get("who"))) {
			//PLAYER ONLINE
			ConnectedClient target = server.connectionManager.clientsUsername.get(packet.get("who"));
			cc.challengeing = target.username;
			target.send(Packet.create("challenge").addData("who", cc.username));
		}else {
			//PLAYER OFFLINE
			cc.send(Packet.create("useroffline"));
		}
	}
	
	public void accept(String ip,int port,Packet packet) {
		ConnectedClient cc = server.connectionManager.getClientFromIpPort(ip, port);
		if(server.connectionManager.clientsUsername.containsKey(packet.get("who"))) {
			//PLAYER ONLINE
			ConnectedClient target = server.connectionManager.clientsUsername.get(packet.get("who"));
			cc.challengeing = target.username;
			UUID uuid = UUID.randomUUID();
			games.put(uuid, new Brett(server, target, cc, uuid));
		}else {
			//PLAYER OFFLINE
			cc.send(Packet.create("useroffline"));
		}
	}
	
	public void move(String ip,int port,Packet packet) {
		ConnectedClient cc = server.connectionManager.getClientFromIpPort(ip, port);
		games.get(cc.game).move(ip, port, packet);
	}
}
