/**
 * @author Mark Rustad
 * @version .01
 * @date Nov 8, 2014
 */
package swrpg.gui;

import java.awt.GridLayout;

import swrpg.model.Character;

/**
 * @author Mark
 *
 */
public class StatsPanel extends TitledBorderPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5300895143011441604L;

	public StatsPanel(Character c)
	{
		super("STATS");
		int numRows = 1;
		int numCols = 6;
		setLayout(new GridLayout(numRows, numCols));
		
		TwoValueDisplay wounds = new TwoValueDisplay("Wounds", c.getWoundMax(), c.getWound());
		add(wounds);
		TwoValueDisplay strain = new TwoValueDisplay("Strain", c.getStrainMax(), c.getStrain());
		add(strain);
		TwoValueDisplay encumb = new TwoValueDisplay("Encumberance", c.getEncumbMax(), c.getEncumb());
		add(encumb);
		OneValueDisplay soak = new OneValueDisplay("Soak", c.getSoak());
		add(soak);
		OneValueDisplay def_melee = new OneValueDisplay("Melee Def", c.getDef_melee());
		add(def_melee);
		OneValueDisplay def_range = new OneValueDisplay("Ranged Def", c.getDef_range());
		add(def_range);
	}

}
