import javax.swing.ImageIcon;


public class Rook extends Piece 
{
	public Rook(boolean white)
	{
		this.white=white;
		String piecetype = null;
		if (white == true)
			piecetype = "wrook.gif";
		else if (white == false)
			piecetype = "brook.gif";
		String source = "resources/" + piecetype;
		this.icon = new ImageIcon(getClass().getResource(source));
	}
	
	public boolean canMove(int xfirst, int yfirst, int xnext, int ynext)
	{
		if (xnext == 0 || ynext == 0 || xnext == 9 || ynext == 9)
			return false;
		else if ((Math.abs(yfirst - ynext) == 0 || Math.abs(xfirst - xnext) == 0))
			if (Chess.position[xnext][ynext] == null || Chess.position[xnext][ynext].white != this.white)
				return true;
			else
				return false;
		else
			return false;
	}
	
	public boolean notBlocked(int xfirst, int yfirst, int xnext, int ynext)
	{
		if (xnext - xfirst < 0 && ynext - yfirst == 0)
		{
			for (int i = 1; i < Math.abs(xnext - xfirst); i++)
			{
				if (Chess.position[xfirst - i][yfirst] != null)
					return false;
			}
			return true;
		}
		else if (xnext - xfirst > 0 && ynext - yfirst == 0)
		{
			for (int i = 1; i < Math.abs(xnext - xfirst); i++)
			{
				if (Chess.position[xfirst + i][yfirst] != null)
					return false;
			}
			return true;
		}
		else if (xnext - xfirst == 0 && ynext - yfirst > 0)
		{
			for (int i = 1; i < Math.abs(ynext - yfirst); i++)
			{
				if (Chess.position[xfirst][yfirst + i] != null)
					return false;
			}
			return true;
		}
		else if (xnext - xfirst == 0 && ynext - yfirst < 0)
		{
			for (int i = 1; i < Math.abs(ynext - yfirst); i++)
			{
				if (Chess.position[xfirst][yfirst - i] != null)
					return false;
			}
			return true;
		}
			
		return true;
	}
}
