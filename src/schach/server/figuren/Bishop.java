package schach.server.figuren;

import schach.server.Brett;

public class Bishop extends Figur{

	public Bishop(int x, int y, Brett brett) {
		super(x, y, brett);
		symbol = 'B';
	}
	
	@Override
	public boolean bewegungErlaubt(int x, int y) {
		if (brett.figuren[x][y] != null) {
			if (brett.figuren[x][y].white == white)
				return false;
		}
		int dx = x - this.x;
		int dy = y - this.y;
		if (Math.abs(dy) == Math.abs(dx)) {
			dx = dx / Math.abs(dx);
			dy = dy / Math.abs(dy);
			int i = this.x;
			int j = this.y;
			while(i > 0 && i < 7&&j > 0 && j < 7) {
				if(i==x&&j==y)
					return true;
				if(brett.figuren[i][j]!=null) {
					return false;
				}
				i += dx;
				j += dy;
			}
		}

		return false;
	}

}
