package schach.server;

import schach.Packet;
import schach.api.Server;

public class SchachServer extends Server{

	BrettManager brettManager;
	ConnnectionManager connectionManager;
	
	public SchachServer(int pPort) {
		super(pPort);
		brettManager = new BrettManager(this);
		connectionManager = new ConnnectionManager(this);
	}

	@Override
	public void processNewConnection(String ip, int port) {
		connectionManager.connect(ip, port);
	}

	@Override
	public void processMessage(String pClientIP, int pClientPort, String pMessage) {
		Packet packet = Packet.creatFromString(pClientIP);
		if(packet.getAction().equals("login")) {
			
		}
	}

	@Override
	public void processClosingConnection(String ip, int port) {
		connectionManager.disconnect(ip, port);
	}
	
}
