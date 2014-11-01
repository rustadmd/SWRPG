/**
 * @author Mark Rustad
 * @version .01
 * @date Nov 1, 2014
 */
package swrpg.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import swrpg.model.Character;

/**
 * @author Mark
 *
 */
public class CharacterPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4984603624626444246L;

	public CharacterPanel(Character c)
	{
		setLayout(new GridBagLayout());
		
		//add the header
		GridBagConstraints header = new GridBagConstraints();
		header.fill = GridBagConstraints.HORIZONTAL;
		header.gridx = 0;
		header.gridy = 0;
		add(new CharHeaderPanel(c), header);
		
		//ad description
		GridBagConstraints description = new GridBagConstraints();
		description.fill = GridBagConstraints.HORIZONTAL;
		description.gridx = 1;
		description.gridy = 0;
		add(new CharDescriptionPanel(c), description);
	}

}
