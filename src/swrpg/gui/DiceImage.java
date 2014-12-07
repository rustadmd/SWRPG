/**
 * 
 */
package swrpg.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JComponent;

/**
 * @author Mark
 *
 */
public class DiceImage extends JComponent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -164142795586435523L;

	public static enum Type 
		{PROFICIENCY,CHALLENGE, ABILITY, DIFFICULTY, BOOST, SETBACK}; 
	private Color[] dieColor = {Color.YELLOW, Color.RED , Color.GREEN, Color.MAGENTA, Color.BLUE, Color.BLACK};
	
	private final int BUFFER_SIZE = 3;
	private Type dieType;
	
	public DiceImage(Type dieType)
	{
		super();
		//this.setSize(50, 50);
		this.dieType = dieType;
		this.repaint();
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		switch(dieType)
		{
		case SETBACK :  
			drawSquare(g, dieColor[Type.SETBACK.ordinal()]); 
			break;
		case ABILITY:
			drawDiamond(g, dieColor[Type.ABILITY.ordinal()]);
			break;
		case BOOST:
			drawSquare(g, dieColor[Type.BOOST.ordinal()]);
			break;
		case CHALLENGE:
			drawHexagon(g, dieColor[Type.CHALLENGE.ordinal()]);
			break;
		case DIFFICULTY:
			drawDiamond(g, dieColor[Type.DIFFICULTY.ordinal()]);
			break;
		case PROFICIENCY:
			drawHexagon(g, dieColor[Type.PROFICIENCY.ordinal()]);
			break;
		default:
			break;
		}
		
	}
	
	private void drawSquare(Graphics g, Color c)
	{
		g.setColor(c);
		int width = getWidth();
		int height = getHeight();
		int squareSize;
		boolean isWidthLonger = width > height;
		if(isWidthLonger)
		{
			squareSize = height-(2*BUFFER_SIZE);
		}
		else
		{
			squareSize = width-(2*BUFFER_SIZE);
		}
		g.fillRect(BUFFER_SIZE, BUFFER_SIZE, squareSize, squareSize);
		g.setColor(Color.BLACK);
		g.drawRect(BUFFER_SIZE, BUFFER_SIZE, squareSize, squareSize);
	}

	private void drawDiamond(Graphics g, Color c)
	{
		g.setColor(c);
		int width = getWidth();
		int height = getHeight();
		boolean isWidthLonger = width > height;
		int diamondWidth;
		if(isWidthLonger)
		{
			diamondWidth = (height -(2*BUFFER_SIZE))/2;
		}
		else
		{
			diamondWidth = (width -(2*BUFFER_SIZE))/2;
		}
		int centerX = width/2;
		int centerY = height/2;
		
		//create polygon, points start at top point, work clockwise
		int[] xPoints = {centerX, centerX + (diamondWidth/2), centerX, centerX - (diamondWidth/2)};
		int[] yPoints = {centerY-diamondWidth, centerY, centerY+diamondWidth, centerY};
		g.fillPolygon(xPoints, yPoints, 4);
		g.setColor(Color.BLACK);
		g.drawPolygon(xPoints, yPoints, 4);
	}
	
	private void drawHexagon(Graphics g, Color c)
	{
		g.setColor(c);
		int width = getWidth();
		int height = getHeight();
		boolean isWidthLonger = width > height;
		//System.out.println(isWidthLonger);
		int hexWidth;
		if(isWidthLonger)
		{
			hexWidth = (height -(2*BUFFER_SIZE))/2;
		}
		else
		{
			hexWidth = (width -(2*BUFFER_SIZE))/2;
		}
		int centerX = width/2;
		int centerY = height/2;
		
		Polygon hexagon = new Polygon();
		for(int i=0; i<6; i++) 
		{
		   int x = (int) (centerX + hexWidth*Math.cos(2*Math.PI*i/6));
		   int y = (int) (centerY + hexWidth*Math.sin(2*Math.PI*i/6));
		   hexagon.addPoint(x, y);
		}
		g.fillPolygon(hexagon);
		g.setColor(Color.BLACK);
		g.drawPolygon(hexagon);
		
	}
	
	@Override
	public Dimension getMinimumSize()
	{
		int minSize = 25;
		return new Dimension(minSize, minSize);
	}
	public Dimension getPreferredSize()
	{
		int minSize = 25;
		return new Dimension(minSize, minSize);
	}
	public Dimension getMaximumSize()
	{
		int minSize = 25;
		return new Dimension(minSize, minSize);
	}
}
