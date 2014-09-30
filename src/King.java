import javax.swing.ImageIcon;


public class King extends Piece 
{
	
	public King(boolean white)
	{
		this.white=white;
		String piecetype = null;
		if (white == true)
			piecetype = "wking.gif";
		else if (white == false)
			piecetype = "bking.gif";
		String source = "resources/" + piecetype;
		this.icon = new ImageIcon(getClass().getResource(source));
	}
	
	public boolean canMove(int xfirst, int yfirst, int xnext, int ynext)
	{
		if (xnext == 0 || ynext == 0 || xnext == 9 || ynext == 9)
			return false;
		else if (Math.abs(yfirst - ynext) <= 1 && Math.abs(xfirst - xnext) <= 1)
			if (Chess.position[xnext][ynext] == null || Chess.position[xnext][ynext].white != this.white)
				return true;
			else
				return false;
		else
			return false;
	}
	public boolean notBlocked(int xfirst, int yfirst, int xnext, int ynext)
	{
		return true;
	}
}

