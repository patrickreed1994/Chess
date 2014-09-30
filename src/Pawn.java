import javax.swing.ImageIcon;


public class Pawn extends Piece 
{
	
	public Pawn(boolean white)
	{
		this.white=white;
		String piecetype = null;
		if (white == true)
			piecetype = "wpawn.gif";
		else if (white == false)
			piecetype = "bpawn.gif";
		String source = "resources/" + piecetype;
		this.icon = new ImageIcon(getClass().getResource(source));
	}
	
	public boolean canMove(int xfirst, int yfirst, int xnext, int ynext)
	{
		if (xnext == 0 || ynext == 0 || xnext == 9 || ynext == 9)
			return false;
		else if (this.white == true)
		{
			if (yfirst - ynext == 2 && yfirst == 7)
				return true;
			else if (yfirst - ynext == 1 && Math.abs(xfirst - xnext) == 0)
			{
				if (Chess.position[xnext][ynext] == null)
					return true;
				else
					return false;
			}
			else if (yfirst - ynext == 1 && Math.abs(xfirst - xnext) == 1)
			{
				if (Chess.position[xnext][ynext].white != this.white)
					return true;
				else
					return false;
			}	
			else
				return false;
		}
		else if (this.white == false)
		{
			if (yfirst - ynext == -1 && Math.abs(xfirst - xnext) == 0)
			{
				if (Chess.position[xnext][ynext] == null)
					return true;
				else
					return false;
			}
			if (Chess.position[xnext][ynext] != null)
			{
				if (ynext - yfirst == 1 && (Math.abs(xfirst - xnext) == 1) && Chess.position[xnext][ynext].white)
					return true;
			}
			else
				return false;
		}
		return false;
	}
	
	public boolean notBlocked(int xfirst, int yfirst, int xnext, int ynext)
	{
		return true;
	}
}
