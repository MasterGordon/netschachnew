package schach.server.figuren;

import schach.server.Brett;

public class Knight extends Figur{

	public Knight(int x, int y, Brett brett,boolean white) {
		super(x, y, brett, white);
		symbol = 'N';
	}

	@Override
	public boolean bewegungErlaubt(int x, int y) {
		if (brett.figuren[x][y] != null) {
			if (brett.figuren[x][y].white == white)
				return false;
		}
		int dx = x - this.x;
		int dy = y - this.y;
		if(dx==2||dx==-2) 
			if(dy==1||dy==-1)
				return true;
		if(dx==1||dx==-1) 
			if(dy==2||dy==-2)
				return true;
		return false;
	}

}
