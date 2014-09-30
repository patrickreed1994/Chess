import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;


public class BoardComponent extends JComponent 
{	
	int x=44, y=44;

	public void paintComponent(Graphics g)
	{
		//x, y, w, h
		Color brownSquare=new Color(177,113,24);
		g.setColor(brownSquare);
		for (int row = 0; row<8; row++)
		{
			for (int column = 0; column<8; column++)
			{
				if ((row % 2 == 1) && (column % 2 == 0))
					g.fillRect(x +(44*row),y + (44*column), 44, 44);
				else if ((row % 2 == 0) && (column % 2 == 1))
					g.fillRect(x +(44*row),y + (44*column), 44, 44);
			}
		}
		Color tanSquare=new Color(233,174,95);
		g.setColor(tanSquare);
		for (int row = 0; row<8; row++)
		{
			for (int column = 0; column<8; column++)
			{
				if ((row % 2 == 0) && (column % 2 == 0))
					g.fillRect(x +(44*row),y + (44*column), 44, 44);
				else if ((row % 2 == 1) && (column % 2 == 1))
					g.fillRect(x +(44*row),y + (44*column), 44, 44);
			}
		}
		for (int p = 1; p < 9; p++)
		{
			for (int q=1; q<9;q++)
			{
				Piece piece = Chess.position[p][q];
				if (piece != null)
				{
					piece.drawPiece(g, p * 44, q * 44);
				}
					
			}
		}
		
	}
}