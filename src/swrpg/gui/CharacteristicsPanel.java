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
		
		CharacteristicDisplay brawn = new CharacteristicDisplay("Brawn", c.getBrawn());
		add(brawn);
		CharacteristicDisplay agility = new CharacteristicDisplay("Agility", c.getAgility());
		add(agility);
		CharacteristicDisplay intellect = new CharacteristicDisplay("Intellect", c.getIntellect());
		add(intellect);
		CharacteristicDisplay cunning = new CharacteristicDisplay("Cunning", c.getCunning());
		add(cunning);
		CharacteristicDisplay willpower = new CharacteristicDisplay("Willpower", c.getWillpower());
		add(willpower);
		CharacteristicDisplay presence = new CharacteristicDisplay("Presence", c.getPresence());
		add(presence);
	}

}
