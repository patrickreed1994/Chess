import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

public class BoardMouseListener implements MouseListener, MouseMotionListener 
{
	Chess chess;
	public BoardMouseListener(Chess chessObject)
	{
		chess=chessObject;
	}
	int xfirst;
	int yfirst;
	
	
	@Override
	public void mouseClicked(MouseEvent i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent i) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void mousePressed(MouseEvent i) {
		// gets x and y coordinates
		this.xfirst = i.getX();
		this.yfirst = i.getY();
		
	}

	@Override
	public void mouseReleased(MouseEvent i) {
		// gets x and y coordinates and translates them into appropriate squares
		
		int xnext = i.getX();
		int ynext = i.getY();
		int xfirst = this.xfirst;
		int yfirst = this.yfirst;
		
		xfirst = (int) Math.floor(xfirst / 44);
		yfirst = (int) Math.floor(yfirst / 44);
		xnext = (int) Math.floor(xnext / 44);
		ynext = (int) Math.floor(ynext / 44);
		
		// checks if it can move
		// if it can, move piece to next square, set original square to null
		// changes turn from white to black after piece moves
		if (Chess.turn == true && Chess.position[xfirst][yfirst].white == true && Chess.position[xfirst][yfirst].canMove(xfirst, yfirst, xnext, ynext) && Chess.position[xfirst][yfirst].notBlocked(xfirst,yfirst,xnext,ynext))
		{
			Piece intermediate = Chess.position[xfirst][yfirst];
			Chess.position[xfirst][yfirst] = null;
			Chess.position[xnext][ynext] = intermediate;
			Chess.turn = false;
		}
		
		Chess.playAI();
		//repaint window with moves shown
		Chess.window.repaint();
	}
	
	
			

	@Override
	public void mouseDragged(MouseEvent i) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent i) {
		// TODO Auto-generated method stub

	}

}
