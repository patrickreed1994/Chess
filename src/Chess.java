import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Chess extends JComponent
{
	
	public static Piece[][] position;
	public static JFrame window = new JFrame("Chess");
	public static boolean turn; 
	

	public Chess()
	{
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(500,500);
		window.add(this);
		
		placePieces();
		turn = true;
		
		
		BoardComponent bc = new BoardComponent();
		BoardMouseListener bml = new BoardMouseListener(this);
		bc.addMouseListener(bml);
		bc.setBounds(0, 0, 400, 400);
		window.add(bc);
	
		
		window.setVisible(true);
		
		
	}
	
	public static void placePieces()
	{
		position = new Piece[9][9];
		for (int h = 1; h<9; h++)
		{
			if (h == 1)
			{
				for (int i = 1; i < 9; i++)
				{
					if (i == 1 || i == 8)
						position[i][h] = new Rook(false);
					else if (i == 2 || i == 7)
						position[i][h] = new Knight(false);
					else if (i == 3 || i == 6)
						position[i][h] = new Bishop(false);
					else if (i == 5)
						position[i][h] = new King(false);
					else if (i == 4)
						position[i][h] = new Queen(false);
				}
			}	
			else if (h == 2)
				for (int i = 1; i < 9; i++)
					position[i][h] = new Pawn(false);
			else if (h == 7)
				for (int i = 1; i < 9; i++)
					position[i][h] = new Pawn(true);	
			else if (h == 8)
			{
				for (int i = 1; i < 9; i++)
				{
					if (i == 1 || i == 8)
						position[i][h] = new Rook(true);
					else if (i == 2 || i == 7)
						position[i][h] = new Knight(true);
					else if (i == 3 || i == 6)
						position[i][h] = new Bishop(true);
					else if (i == 5)
						position[i][h] = new King(true);
					else if (i == 4)
						position[i][h] = new Queen(true);
				}
			}
		}
	}

	public static void playAI()
	{
		
		while(turn == false)
		{
			Random generator = new Random();
			int randxfirst = generator.nextInt(8) + 1;
			int randyfirst = generator.nextInt(8) + 1;
		
			if (position[randxfirst][randyfirst] != null)
			{
				if (!position[randxfirst][randyfirst].white)
					{
						int randendx = generator.nextInt(8) + 1;
						int randendy = generator.nextInt(8) + 1;
						if (position[randxfirst][randyfirst].canMove(randxfirst, randyfirst, randendx, randendy) && position[randxfirst][randyfirst].notBlocked(randxfirst, randyfirst, randendx, randendy))
						{
							Piece intermediate = position[randxfirst][randyfirst];
							position[randxfirst][randyfirst] = null;
							position[randendx][randendy] = intermediate;
							turn = true;
						}
					}
					
			}
			
		}
			
	}
	
	public static void main(String[] args) 
	{
	
		new Chess();

	}

}
