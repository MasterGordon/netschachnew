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
	public void processMessage(String ip, int port, String pMessage) {
		Packet packet = Packet.creatFromString(pMessage);
		if(packet.getAction().equals("login")) {
			connectionManager.login(ip, port, packet);
		} else if(packet.getAction().equals("register")) {
			connectionManager.register(ip, port, packet);
		} else if(packet.getAction().equals("logout")) {
			connectionManager.logout(ip, port);
		} else if(packet.getAction().equals("move")) {
			brettManager.move(ip, port, packet);
		} else if(packet.getAction().equals("acceptchallenge")) {
			brettManager.accept(ip, port, packet);
		} else if(packet.getAction().equals("challenge")) {
			brettManager.challenge(ip, port, packet);
		}
	}

	@Override
	public void processClosingConnection(String ip, int port) {
		connectionManager.disconnect(ip, port);
	}
	
}
