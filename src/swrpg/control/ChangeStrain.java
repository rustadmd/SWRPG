/**
 * 
 */
package swrpg.control;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
//import javax.swing.JOptionPane;
import javax.swing.JTextField;

import swrpg.gui.TwoValueDisplay;
import swrpg.model.Character;;


/**
 * @author Mark
 *
 */
public class ChangeStrain extends AbstractAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 264925770765885124L;
	
	private Character c;
	private TwoValueDisplay disp;
	private Action a;
	private JTextField input;
	
	public enum Action { TAKE_CURRENT, RECOVER_CURRENT, INC_THRESHHOLD };
	
	public ChangeStrain(Character c, Action a, TwoValueDisplay d, JTextField input)
	{
		this.c = c;
		this.a = a;
		this.disp = d;
		this.input = input;
	}
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int oldValue, newValue, change;
		change = 0;
		try{
			change = Integer.parseInt(input.getText());
			if(change < 0)
			{
				throw new IllegalArgumentException("Number must be positive");
			}
		}
		catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog
				(null, "Input is invalid, please enter positive integer"
						, "Invalid Input", JOptionPane.WARNING_MESSAGE);
			return;
		}
		switch (a)
		{
		case INC_THRESHHOLD:
			oldValue = c.getWoundMax();
			newValue = oldValue + change;
			disp.setLeftValue(Integer.toString(newValue));
			c.setStrainMax(newValue);
			break;
		case RECOVER_CURRENT:
			oldValue = c.getWound();
			newValue = oldValue + change;
			
			//make sure you cannot surpass threshhold
			int max = c.getWoundMax();
			if(newValue > max)
			{
				newValue = max;
			}
			disp.setRightValue(Integer.toString(newValue));
			c.setStrain(newValue);
			break;
		case TAKE_CURRENT:
			oldValue = c.getWound();
			newValue = oldValue - change;
			if(newValue < 0)
			{
				newValue = 0;
			}
			disp.setRightValue(Integer.toString(newValue));
			c.setStrain(newValue);
			break;
		default:
			throw new IllegalArgumentException("Character strain changed: Unknown action type");
		}

	}

}
