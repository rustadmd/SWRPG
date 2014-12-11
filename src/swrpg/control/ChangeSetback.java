/**
 * 
 */
package swrpg.control;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import swrpg.model.Character;
import swrpg.gui.DiceDisplay;
import swrpg.gui.DiceDisplay.Type;
/**
 * @author Mark
 *
 */
public class ChangeSetback extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4883120117526033675L;

	private Character c;
	private DiceDisplay dd;
	private Action a;
	
	public enum Action { ADD, REMOVE, CLEAR };
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public ChangeSetback(Character c, DiceDisplay dd, Action actionType)
	{
		this.c = c;
		this.dd = dd;
		this.a = actionType;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int newDice;
		switch(a)
		{
		case ADD:
			newDice = c.getNumSetback();
			newDice++;
			break;
		case CLEAR:
			newDice = 0;
			break;
		case REMOVE:
			newDice = c.getNumSetback();
			newDice --;
			break;
		default:
			newDice = 0;
			throw new IllegalArgumentException("Character setback dice changed: Unknown action type");
		}
		
		c.setNumSetback(newDice);
		dd.setDice(Type.SETBACK, newDice);
		dd.displayDice();
		//System.out.println("Dice changed: " + c.getNumSetback());

	}

}
