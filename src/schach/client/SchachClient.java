package schach.client;

import java.awt.Color;

import schach.Packet;
import schach.api.Client;

public class SchachClient extends Client{
	
	public static SchachClient instance;

	FrameChallenge frameChallenge;
	FrameLogin frameLogin;
	FrameRegister frameRegister;
	FrameMainClient frameMainClient;
	
	boolean isLoggedIn = false;
	String username = "";
	
	public SchachClient(String pServerIP, int pServerPort) {
		super(pServerIP, pServerPort);
		instance = this;
		if(!isConnected())
			System.exit(0);
		frameChallenge = new FrameChallenge();
		frameLogin = new FrameLogin();
		frameRegister = new FrameRegister();
		frameMainClient = new FrameMainClient(this);
		frameMainClient.setVisible(true);
		frameMainClient.mnPlay.setVisible(false);
		frameMainClient.mntmLogout.setVisible(false);
		frameMainClient.mnElo.setVisible(false);
	}

	@Override
	public void processMessage(String pMessage) {
		Packet packet = Packet.creatFromString(pMessage);
		if(packet.getAction().equals("registersuccess")) {
			frameRegister.setVisible(false);
			frameMainClient.setVisible(true);
		}
		if(packet.getAction().equals("loginsuccess")) {
			isLoggedIn = true;
			frameMainClient.mnPlay.setVisible(true);
			frameMainClient.mntmLogout.setVisible(true);
			frameMainClient.mnElo.setVisible(true);
			frameMainClient.mntmRegister.setVisible(false);
			frameMainClient.mntmLogin.setVisible(false);
			frameLogin.setVisible(false);
			frameMainClient.setVisible(true);
			frameMainClient.username.setText(username);
		}
		if(packet.getAction().equals("registererror")) {
			frameRegister.getContentPane().setBackground(Color.RED);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			frameRegister.getContentPane().setBackground(null);
		}
		if(packet.getAction().equals("challenge")) {
			
		}
	}

}
