package schach.server.figuren;

import schach.server.Brett;

public abstract class Figur {
	int x, y;
	boolean white;
	Brett brett;
	Character symbol;

	public Figur(int x, int y,Brett brett,boolean white) {
		this.white = white;
		this.brett = brett;
		brett.figuren[x][y] = this;
		this.x = x;
		this.y = y;
	}

	public String toString() {
		if (white)
			return Character.toUpperCase(symbol) + "";
		return Character.toLowerCase(symbol) + "";
	}

	public abstract boolean bewegungErlaubt(int x, int y);

	public boolean isWhite() {
		// TODO Auto-generated method stub
		return white;
	}
}
