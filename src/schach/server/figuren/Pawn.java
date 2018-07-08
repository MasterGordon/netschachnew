package schach.server.figuren;

import schach.server.Brett;

public class Pawn extends Figur {

	public Pawn(int x, int y, Brett brett,boolean white) {
		super(x, y, brett, white);
		symbol = 'P';
	}

	@Override
	public boolean bewegungErlaubt(int x, int y) {
		if(brett.figuren[x][y]!=null) {
			if(brett.figuren[x][y].white==white)
				return false;
		}
		if (white) {
			if (y - this.y == 1 && brett.figuren[x][y] == null && this.x - x == 0)// 1 Schritt nach vorne
				return true;
			if (y - this.y == 2 && brett.figuren[x][y] == null && this.y == 1 && this.x - x == 0)// 2er Schritt nach
																									// vorne
				return true;
			if (y - this.y == 1 && brett.figuren[x][y] != null && this.x - x == 1)// Schlagen
				return true;
			if (y - this.y == 1 && brett.figuren[x][y] != null && this.x - x == -1)// Schlagen
				return true;
		} else {
			if (y - this.y == -1 && brett.figuren[x][y] == null && this.x - x == 0)// 1 Schritt nach vorne
				return true;
			if (y - this.y == -2 && brett.figuren[x][y] == null && this.y == 6 && this.x - x == 0)// 2er Schritt nach
																									// vorne
				return true;
			if (y - this.y == -1 && brett.figuren[x][y] != null && this.x - x == 1)// Schlagen
				return true;
			if (y - this.y == -1 && brett.figuren[x][y] != null && this.x - x == -1)// Schlagen
				return true;
		}
		return false;
	}

}
