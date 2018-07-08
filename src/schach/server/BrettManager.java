package schach.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.UUID;

public class BrettManager {
	SchachServer server;
	HashMap<UUID,Brett> games = new HashMap<UUID,Brett>();
	private Connection conn;
	
	public BrettManager(SchachServer server) {
		try {
			String path = System.getenv("USERPROFILE");
			conn = DriverManager.getConnection("jdbc:sqlite:" + path + "/Documents/schachuser.db");
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		this.server = server;
	}
}
