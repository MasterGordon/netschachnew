package schach.server;

import java.util.HashMap;
import java.util.UUID;

public class BrettManager {
	SchachServer server;
	HashMap<UUID,Brett> games = new HashMap<UUID,Brett>();
	
	public BrettManager(SchachServer server) {
		this.server = server;
	}
}
