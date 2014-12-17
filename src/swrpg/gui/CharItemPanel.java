/**
 * 
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
public class CharItemPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1686788950120055539L;
	private Character c;
	private FieldDisplay creditDisplay;

	public CharItemPanel(Character charac)
	{
		this.c = charac;
		setLayout(new GridBagLayout());
		
		int credits = c.getCredits();
		creditDisplay = new FieldDisplay("Credits", Integer.toString(credits));
		GridBagConstraints creditConstraints = new GridBagConstraints();
		creditConstraints.gridx = 0;
		creditConstraints.gridy = 0;
		add(creditDisplay, creditConstraints);
		
		//add the item list
		OwnerItemListDisplay itemList = new OwnerItemListDisplay(c.getItemList());
		GridBagConstraints itemListConstraints = new GridBagConstraints();
		itemListConstraints.fill = GridBagConstraints.BOTH;
		itemListConstraints.gridx = 0;
		itemListConstraints.gridy = 1;
		add(itemList, itemListConstraints);
	}

}
