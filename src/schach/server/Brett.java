package schach.server;

import java.util.ArrayList;
import java.util.UUID;

import schach.Packet;
import schach.server.figuren.*;

public class Brett {

	public Figur[][] figuren = new Figur[8][8];
	SchachServer server;
	ConnectedClient clientWhite;
	ConnectedClient clientBlack;
	boolean currentPlayer = true;
	ArrayList<String> replay = new ArrayList<String>();
	public UUID uuid;

	public Brett(SchachServer server, ConnectedClient clientWhite, ConnectedClient clientBlack, UUID uuid) {
		this.uuid = uuid;
		this.clientWhite = clientWhite;
		this.clientBlack = clientBlack;
		this.clientWhite.game = uuid;
		this.clientBlack.game = uuid;
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
		clientWhite.send(Packet.create("boardinit").addData("color", "white").addData("board", toString()));
		clientBlack.send(Packet.create("boardinit").addData("color", "black").addData("board", toString()));
	}

	public void move(String ip, int port, Packet packet) {
		ConnectedClient cc = server.connectionManager.getClientFromIpPort(ip, port);
		if (currentPlayer) {
			if (cc.equals(clientBlack))
				return;
		} else {
			if (cc.equals(clientWhite))
				return;
		}
		int fromX = Integer.parseInt(packet.get("fromX"));
		int fromY = Integer.parseInt(packet.get("fromY"));
		int toX = Integer.parseInt(packet.get("toX"));
		int toY = Integer.parseInt(packet.get("toY"));
		if (figuren[fromX][fromY] == null) {
			cc.send(Packet.create("moveerror"));
			return;
		}
		if (figuren[fromX][fromY].isWhite() == currentPlayer) {
			cc.send(Packet.create("moveerror"));
			return;
		}
		if (figuren[fromX][fromY].bewegungErlaubt(toX, toY)) {
			if (figuren[toX][toY] instanceof King) {
				// CURRENT WON
				Packet result = Packet.create("boardupdate");
				result.addData("board", this.toString());
				result.addData("current", getCurrent());
				result.addData("lastX", toX + "");
				result.addData("lastY", toY + "");
				send(result);
				replay.add(this.toString());
				Packet gameover = Packet.create("gameover");
				gameover.addData("winner", getCurrent());
				gameover.addData("elo", "1000");
				send(gameover);
			} else {
				figuren[toX][toY] = figuren[fromX][fromY];
				figuren[fromX][fromY] = null;
				currentPlayer = !currentPlayer;
				Packet result = Packet.create("boardupdate");
				result.addData("board", this.toString());
				result.addData("current", getCurrent());
				result.addData("lastX", toX + "");
				result.addData("lastY", toY + "");
				send(result);
				replay.add(this.toString());
			}
		}
	}

	public String toString() {
		String string = "";
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				string += figuren[x][y].toString();
			}
		}
		return string;
	}

	public String getCurrent() {
		if (currentPlayer)
			return "black";
		else
			return "white";
	}

	public void send(Packet packet) {
		clientBlack.send(packet);
		clientWhite.send(packet);
	}

}
