package schach.server.figuren;

import schach.server.Brett;

public class Queen extends Figur{

	public Queen(int x, int y, Brett brett, boolean white) {
		super(x, y, brett, white);
		symbol = 'Q';
	}

	@Override
	public boolean bewegungErlaubt(int x, int y) {
		if (brett.figuren[x][y] != null) {
			if (brett.figuren[x][y].white == white)
				return false;
		}
		int dx = x - this.x;
		int dy = y - this.y;
		if (Math.abs(dy) == 0 || Math.abs(dx) == 0) {
			dx = dx / Math.abs(dx);
			dy = dy / Math.abs(dy);
			int i = this.x;
			int j = this.y;
			while (i > 0 && i < 7 && j > 0 && j < 7) {
				if (i == x && j == y)
					return true;
				if (brett.figuren[i][j] != null) {
					return false;
				}
				i += dx;
				j += dy;
			}
		}
		dx = x - this.x;
		dy = y - this.y;
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
