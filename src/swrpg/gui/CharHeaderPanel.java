/**
 * @author Mark Rustad
 * @version .01
 * @date Oct 31, 2014
 */
package swrpg.gui;

import javax.swing.JLabel;

import swrpg.model.Character;

/**
 * @author Mark
 *
 */
public class CharHeaderPanel extends TitledBorderPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2664252689837936193L;

	public CharHeaderPanel (Character c)
	{
		super("Character:");
		String header = "Character Name:\t" + c.getName() + "\nSpecies:\t" + c.getRace();
		JLabel name = new JLabel(header);
		add(name);
	}
}
