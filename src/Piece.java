import java.awt.Graphics;
import javax.swing.ImageIcon;



public abstract class Piece {

	public boolean white;
	public ImageIcon icon;
	
	public void drawPiece(Graphics g, int x, int y)
	{
		g.drawImage(icon.getImage(),x,y,null); 
	}
	
	public abstract boolean canMove(int xfirst, int yfirst, int xnext, int ynext);
	public abstract boolean notBlocked(int xfirst, int yfirst, int xnext, int ynext);
	
}
