package schach.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import schach.Packet;
import schach.SchachUtil;



public class ConnnectionManager {
	HashMap<String, ConnectedClient> clientsIP = new HashMap<String, ConnectedClient>();
	HashMap<String, ConnectedClient> clientsUsername = new HashMap<String, ConnectedClient>();
	SchachServer server;
	Connection conn;

	public ConnnectionManager(SchachServer server) {
		try {
			String path = System.getenv("USERPROFILE");
			conn = DriverManager.getConnection("jdbc:sqlite:" + path + "/Documents/schachuser.db");
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		this.server = server;
		initDB();
	}

	public void connect(String ip, int port) {
		ConnectedClient cc = new ConnectedClient(ip, port, server);
		clientsIP.put(ip + ":" + "port", cc);
	}

	public void logout(String ip,int port) {
		ConnectedClient cc = getClientFromIpPort(ip, port);
		if (cc != null) {
			try {
				Statement stat = conn.createStatement();
				stat.executeUpdate("update users SET elo = " + cc.elo + ", friends = '" + cc.getFriends()
						+ "' WHERE username = '" + cc.username + "';");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			for (String s : clientsIP.keySet()) {
				if (clientsIP.get(s).equals(cc))
					clientsIP.remove(s);
			}
			for (String s : clientsUsername.keySet()) {
				if (clientsUsername.get(s).equals(cc))
					clientsUsername.remove(s);
			}
		}
		connect(ip, port);
	}
	
	public void disconnect(String ip, int port) {
		ConnectedClient cc = getClientFromIpPort(ip, port);
		if (cc != null) {
			try {
				Statement stat = conn.createStatement();
				stat.executeUpdate("update users SET elo = " + cc.elo + ", friends = '" + cc.getFriends()
						+ "' WHERE username = '" + cc.username + "';");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			for (String s : clientsIP.keySet()) {
				if (clientsIP.get(s).equals(cc))
					clientsIP.remove(s);
			}
			for (String s : clientsUsername.keySet()) {
				if (clientsUsername.get(s).equals(cc))
					clientsUsername.remove(s);
			}
		}
		if(server.isConnectedTo(ip, port))
			server.closeConnection(ip, port);
	}

	public void login(String ip, int port, Packet packet) {
		if (!packet.getAction().equals("login"))
			return;
		ConnectedClient cc = getClientFromIpPort(ip, port);
		String username = packet.get("username");
		String password = packet.get("password");
		String hashedPassword = SchachUtil.hash(password);
		Statement stat;
		String dbPasswordHash = "error";
		int dbElo = 0;
		@SuppressWarnings("unused")
		String dbFriends = "";
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select * from users WHERE 'username' = '" + username + "';");
			while (rs.next()) {
				dbPasswordHash = rs.getString("password");
				dbElo = rs.getInt("elo");
				dbFriends = rs.getString("elo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (dbPasswordHash.equals("error")) {
			Packet error = Packet.create("loginerror");
			error.addData("type", "invalidusername");
			cc.send(error);
		}
		if (dbPasswordHash.equals(hashedPassword)) {
			// LOGIN
			cc.elo = dbElo;
			cc.username = username;
			cc.loggedIn = true;
			clientsUsername.put(username, cc);
			Packet loginpacket = Packet.create("loginsuccess");
			cc.send(loginpacket);
		} else {
			Packet error = Packet.create("loginerror");
			error.addData("type", "invalidpassword");
			cc.send(error);
		}
	}

	public void register(String ip, int port, Packet packet) {
		if (!packet.getAction().equals("register"))
			return;
		ConnectedClient cc = getClientFromIpPort(ip, port);
		String username = packet.get("username");
		String password = packet.get("password");
		String hashedPassword = SchachUtil.hash(password);
		if (username.length() > 15) {
			Packet error = Packet.create("registererror");
			error.addData("type", "invalidusername");
			cc.send(error.save());
			return;
		}
		Statement stat;
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select * from users WHERE 'username' = '" + username + "';");
			if (rs.next()) {
				Packet error = Packet.create("registererror");
				error.addData("type", "usernametaken");
				cc.send(error);
				rs.close();
				return;
			}
			rs.close();
			// Nutzername kürzer 16 und verfügbar
			stat.executeUpdate(
					"insert into users values ('" + username + "', '" + hashedPassword + "', " + 1000 + ",'');");
			Packet registerpacket = Packet.create("registersuccess");
			cc.send(registerpacket);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ConnectedClient getClientFromIpPort(String ip, int port) {
		return clientsIP.get(ip + ":" + port);
	}

	public void initDB() {
		String createUsers = "create table if not exists users ( `username` TEXT NOT NULL , `password` TEXT NOT NULL , `elo` INT NOT NULL , `friends` TEXT NOT NULL);";
		String createReplays = "CREATE TABLE replays ( `id` INT NOT NULL , `packet` MEDIUMTEXT NOT NULL );";
		Statement stat;
		try {
			stat = conn.createStatement();
			stat.executeUpdate(createUsers);
			stat.executeUpdate(createReplays);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
