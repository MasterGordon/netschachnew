package schach.server.figuren;

import schach.server.Brett;

public class King extends Figur{

	public King(int x, int y, Brett brett,boolean white) {
		super(x, y, brett, white);
		symbol = 'K';
	}

	@Override
	public boolean bewegungErlaubt(int x, int y) {
		if (brett.figuren[x][y] != null) {
			if (brett.figuren[x][y].white == white)
				return false;
		}
		int dx = x - this.x;
		int dy = y - this.y;
		if(Math.abs(dx)==1&&Math.abs(dy)==1)
			return true;
		return false;
	}

}
