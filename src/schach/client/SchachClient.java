package schach.client;

import schach.Packet;
import schach.api.Client;

public class SchachClient extends Client{

	FrameChallenge frameChallenge;
	FrameChallengeAccept frameChallengeAccept;
	FrameLogin frameLogin;
	FrameRegister frameRegister;
	FrameMainClient frameMainClient;
	
	boolean isLoggedIn = false;
	String username = "";
	
	public SchachClient(String pServerIP, int pServerPort) {
		super(pServerIP, pServerPort);
		if(!isConnected())
			System.exit(0);
		frameChallenge = new FrameChallenge();
		frameChallengeAccept = new FrameChallengeAccept();
		frameLogin = new FrameLogin();
		frameRegister = new FrameRegister();
		frameMainClient = new FrameMainClient(this);
		frameMainClient.setVisible(true);
	}

	@Override
	public void processMessage(String pMessage) {
		Packet packet = Packet.creatFromString(pMessage);
	}

}
