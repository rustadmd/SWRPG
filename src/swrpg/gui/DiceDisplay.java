/**
 * 
 */
package swrpg.gui;

import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JLabel;

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
	}
	
	/**
	 * Adds the number of dice and prepares the DiceDisplay immediately for adding
	 * @param numProf
	 * @param numChal
	 * @param numAbil
	 * @param numDiff
	 * @param numBoost
	 * @param numSetBack
	 */
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
		//System.out.println("displayDice() executed...");
		//count the total dice
		int totalDice =0;
		for(int count:diceCount)
		{
			totalDice += count;
		}
		//System.out.println("Total dice: " + totalDice);
		//If there are no dice, add label saying so
		if(totalDice == 0)
		{
			layout.setColumns(1);
			JLabel none = new JLabel("None");
			none.setFont(none.getFont().deriveFont((float)15));
			none.setHorizontalAlignment(JLabel.CENTER);
			add(none);
		}
		else{
			
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
		this.validate();
	}
	/**
	 * Adds all of the appropriate dice.
	 * Automatically calls displayDice when finished;
	 * @param numProf
	 * @param numChal
	 * @param numAbil
	 * @param numDiff
	 * @param numBoost
	 * @param numSetBack
	 */
	public void setDice(int numProf, int numChal, int numAbil, int numDiff, int numBoost, int numSetBack)
	{
		diceCount[0]=numProf;
		diceCount[1]=numChal;
		diceCount[2]=numAbil;
		diceCount[3]=numDiff;
		diceCount[4]=numBoost;
		diceCount[5]=numSetBack;
		displayDice();
	}
	
	/**
	 * Adds a particular number of dice for the given type.
	 * Need to call displayDice() in order to display changes
	 * 
	 * @param t	Dice type, ex. Proficiency, etc.
	 * @param number Number of dice for that display
	 */
	public void setDice(Type t, int number)
	{
		diceCount[t.ordinal()] = number;
	}

}
