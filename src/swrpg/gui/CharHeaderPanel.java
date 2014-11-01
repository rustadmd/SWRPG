/**
 * @author Mark Rustad
 * @version .01
 * @date Oct 31, 2014
 */
package swrpg.gui;

import java.awt.GridLayout;

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
		super("CHARACTER");
		int numColumns = 1;
		int numRows = 5;
		setLayout(new GridLayout(numRows, numColumns));
		
		//add the header fields
		FieldDisplay player = new FieldDisplay("Player", c.getPlayer());
		add(player);
		FieldDisplay name = new FieldDisplay("Character Name", c.getName());
		add(name);
		FieldDisplay race = new FieldDisplay("Species", c.getRace());
		add(race);
		
	}
}
