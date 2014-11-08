/**
 * @author Mark Rustad
 * @version .01
 * @date Nov 1, 2014
 */
package swrpg.gui;

import java.awt.GridLayout;

import swrpg.model.Character;

/**
 * @author Mark
 *
 */
public class CharacteristicsPanel extends TitledBorderPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5951263567722364983L;
	
	public CharacteristicsPanel(Character c)
	{
		super("CHARACTERISTICS");
		setLayout(new GridLayout(1, 6));
		//System.out.println("Characteristics panel created...");//debugging
		
		OneValueDisplay brawn = new OneValueDisplay("Brawn", c.getBrawn());
		add(brawn);
		OneValueDisplay agility = new OneValueDisplay("Agility", c.getAgility());
		add(agility);
		OneValueDisplay intellect = new OneValueDisplay("Intellect", c.getIntellect());
		add(intellect);
		OneValueDisplay cunning = new OneValueDisplay("Cunning", c.getCunning());
		add(cunning);
		OneValueDisplay willpower = new OneValueDisplay("Willpower", c.getWillpower());
		add(willpower);
		OneValueDisplay presence = new OneValueDisplay("Presence", c.getPresence());
		add(presence);
	}

}
