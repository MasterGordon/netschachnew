package schach.server;

import java.util.ArrayList;

import schach.Packet;
import schach.server.figuren.*;

public class Brett {

	public Figur[][] figuren = new Figur[8][8];
	SchachServer server;
	ConnectedClient clientWhite;
	ConnectedClient clientBlack;
	boolean currentPlayer = true;
	ArrayList<String> replay = new ArrayList<String>();

	public Brett(SchachServer server) {
		this.server = server;
		figuren[0][0] = new Rook(0, 0, this, false);
		figuren[1][0] = new Knight(1, 0, this, false);
		figuren[2][0] = new Bishop(2, 0, this, false);
		figuren[3][0] = new Queen(3, 0, this, false);
		figuren[4][0] = new King(4, 0, this, false);
		figuren[5][0] = new Bishop(5, 0, this, false);
		figuren[6][0] = new Knight(6, 0, this, false);
		figuren[7][0] = new Rook(7, 0, this, false);
		figuren[0][1] = new Pawn(0, 1, this, false);
		figuren[1][1] = new Pawn(1, 1, this, false);
		figuren[2][1] = new Pawn(2, 1, this, false);
		figuren[3][1] = new Pawn(3, 1, this, false);
		figuren[4][1] = new Pawn(4, 1, this, false);
		figuren[5][1] = new Pawn(5, 1, this, false);
		figuren[6][1] = new Pawn(6, 1, this, false);
		figuren[7][1] = new Pawn(7, 1, this, false);

		figuren[0][7] = new Rook(0, 7, this, true);
		figuren[1][7] = new Knight(1, 7, this, true);
		figuren[2][7] = new Bishop(2, 7, this, true);
		figuren[3][7] = new Queen(3, 7, this, true);
		figuren[4][7] = new King(4, 7, this, true);
		figuren[5][7] = new Bishop(5, 7, this, true);
		figuren[6][7] = new Knight(6, 7, this, true);
		figuren[7][7] = new Rook(7, 6, this, true);
		figuren[0][6] = new Pawn(0, 6, this, true);
		figuren[1][6] = new Pawn(1, 6, this, true);
		figuren[2][6] = new Pawn(2, 6, this, true);
		figuren[3][6] = new Pawn(3, 6, this, true);
		figuren[4][6] = new Pawn(4, 6, this, true);
		figuren[5][6] = new Pawn(5, 6, this, true);
		figuren[6][6] = new Pawn(6, 6, this, true);
		figuren[7][6] = new Pawn(7, 6, this, true);
	}
	
	public void move(String ip,int port,Packet packet) {
		ConnectedClient cc = server.connectionManager.getClientFromIpPort(ip, port);
		if(currentPlayer) {
			if(cc.equals(clientBlack))
				return;
		}else {
			if(cc.equals(clientWhite))
				return;
		}
		int fromX = Integer.parseInt(packet.get("fromX"));
		int fromY = Integer.parseInt(packet.get("fromY"));
		int toX = Integer.parseInt(packet.get("toX"));
		int toY = Integer.parseInt(packet.get("toY"));
		
		
	}
}
