/**
 * 
 */
package swrpg.gui;

import java.awt.GridLayout;

import javax.swing.JComponent;

/**
 * @author Mark
 *
 */
public class DiceDisplay extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static enum Type { PROFICIENCY,CHALLENGE, ABILITY, DIFFICULTY, BOOST, SETBACK };
	private int[] diceCount = new int[6];
	private GridLayout layout;
	
	public DiceDisplay()
	{
		layout = new GridLayout(1, 2);
		setLayout(layout);
		add(new DiceImage(DiceImage.Type.ABILITY));
		add(new DiceImage(DiceImage.Type.PROFICIENCY));
		add(new DiceImage(DiceImage.Type.PROFICIENCY));
		//add(new DiceImage(DiceImage.Type.PROFICIENCY));
	}
	
	public DiceDisplay(int numProf, int numChal, int numAbil, int numDiff, int numBoost, int numSetBack)
	{
		this();
		setDice( numProf, numChal, numAbil, numDiff, numBoost, numSetBack);
		//this.add(new DiceImage(DiceImage.Type.BOOST));
		displayDice();
	}
	
	public void displayDice()
	{
		this.removeAll();
		
		int totalDice =0;
		for(int count:diceCount)
		{
			totalDice += count;
		}
		layout.setColumns(totalDice);
		for(int dieType=0; dieType < diceCount.length; dieType++)
		{
			int partialDice = diceCount[dieType];
			DiceImage.Type type;
			switch(dieType)
			{
			case 0: type = DiceImage.Type.PROFICIENCY; break;
			case 1: type = DiceImage.Type.CHALLENGE; break;
			case 2: type = DiceImage.Type.ABILITY; break;
			case 3: type = DiceImage.Type.DIFFICULTY; break;
			case 4: type = DiceImage.Type.BOOST; break;
			case 5: type = DiceImage.Type.SETBACK; break;
			default: type = DiceImage.Type.SETBACK;
				throw new IllegalArgumentException("Unexpected die type in DiceDisplay");
			}
			for(int ithDie=0; ithDie < partialDice; ithDie++)
			{
				//System.out.println("Die added");
				this.add(new DiceImage(type));
			}
		}
	}
	
	public void setDice(int numProf, int numChal, int numAbil, int numDiff, int numBoost, int numSetBack)
	{
		diceCount[0]=numProf;
		diceCount[1]=numChal;
		diceCount[2]=numAbil;
		diceCount[3]=numDiff;
		diceCount[4]=numBoost;
		diceCount[5]=numSetBack;
	}
	
	/**
	 * Adds a particular number of dice for the given type.
	 * @param t	Dice type, ex. Proficiency, etc.
	 * @param number Number of dice for that display
	 */
	public void setDice(Type t, int number)
	{
		diceCount[t.ordinal()] = number;
	}

}
