package schach.server.figuren;

import schach.server.Brett;

public abstract class Figur {
	int x,y;
	boolean white;
	Brett brett;
	Character symbol;
	
	public Figur(int x, int y) {
		brett.figuren[x][y] = this;
		this.x = x;
		this.y = y;
	}

	public abstract boolean bewegungErlaubt(int x, int y);
}
