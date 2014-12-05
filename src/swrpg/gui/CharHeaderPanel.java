/**
 * @author Mark Rustad
 * @version .01
 * @date Oct 31, 2014
 */
package swrpg.gui;

import java.awt.GridLayout;
import java.util.Iterator;
import java.util.LinkedList;

import swrpg.model.Character;
import swrpg.model.Specialization;

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
		FieldDisplay career = new FieldDisplay("Career", c.getCareer());
		add(career);
		
		//Process Specializations
		LinkedList<Specialization> specs = c.getSpecializations();
		Iterator<Specialization> i = specs.iterator();
		
		String list = i.next().getName();
		while(i.hasNext())
		{
			list += ", ";
			list += i.next().getName();
		}
		FieldDisplay specDisplay = new FieldDisplay("Special.", list);
		add(specDisplay);
		
	}
}
