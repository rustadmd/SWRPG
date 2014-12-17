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
	
	//Stats
	TwoValueDisplay wounds;
	TwoValueDisplay strain;
	TwoValueDisplay encumb;
	OneValueDisplay soak;
	OneValueDisplay def_melee;
	OneValueDisplay def_range;

	public StatsPanel(Character c)
	{
		super("STATS");
		int numRows = 1;
		int numCols = 6;
		setLayout(new GridLayout(numRows, numCols));
		
		wounds = new TwoValueDisplay("Wounds", c.getWoundMax(), c.getWound());
		add(wounds);
		strain = new TwoValueDisplay("Strain", c.getWoundMax(), c.getWound());
		add(strain);
		encumb = new TwoValueDisplay("Encumberance", c.getEncumbMax(), c.getEncumb());
		add(encumb);
		soak = new OneValueDisplay("Soak", c.getSoak());
		add(soak);
		def_melee = new OneValueDisplay("Melee Def", c.getDef_melee());
		add(def_melee);
		def_range = new OneValueDisplay("Ranged Def", c.getDef_range());
		add(def_range);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public TwoValueDisplay getWounds() {
		return wounds;
	}

	public TwoValueDisplay getStrain() {
		return strain;
	}

	public TwoValueDisplay getEncumb() {
		return encumb;
	}

	public OneValueDisplay getSoak() {
		return soak;
	}

	public OneValueDisplay getDef_melee() {
		return def_melee;
	}

	public OneValueDisplay getDef_range() {
		return def_range;
	}

	/*
	 * Alternative method of update, not currently being used
	 * 
	public void setWounds(String newValue) {
		this.wounds.setRightValue(newValue);
	}
	
	public void setWoundsThreshhold(String newValue) {
		this.wounds.setLeftValue(newValue);
	}

	public void setStrain(String newValue) {
		this.strain.setRightValue(newValue);
	}
	
	public void setStrainThreshhold(String newValue) {
		this.strain.setLeftValue(newValue);
	}

	public void setEncumb(String encumb) {
		this.encumb.setRightValue(encumb);
	}
	
	public void setEncumbThreshhold(String encumb) {
		this.encumb.setLeftValue(encumb);
	}

	public void setSoak(String soak) {
		this.soak.setValue(soak);
	}

	public void setDef_melee(String def_melee) {
		this.def_melee.setValue(def_melee);
	}

	public void setDef_range(String def_range) {
		this.def_range.setValue(def_range);
	}
*/
}
