/**
 * 
 */
package swrpg.gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

import swrpg.model.Item;
import swrpg.model.OwnedItem;

/**
 * @author Mark
 *
 */
public class ItemFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8225439854711477544L;
	private OwnedItem ownedItem;
	
	public ItemFrame(OwnedItem oi)
	{
		ownedItem = oi;
		this.setLayout(new BorderLayout());
		
		addBasicPanel();
		pack();
	}
	
	private void addBasicPanel()
	{
		Item item = ownedItem.getItem();
		
		TitledBorderPanel basicPanel = new TitledBorderPanel("Basic Item Information");
		basicPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints con = new GridBagConstraints();
		con.gridy = 0;
		FieldDisplay name = new FieldDisplay("Name", item.getName());
		basicPanel.add(name, con);
		
		FieldDisplay type = new FieldDisplay("Type", item.getType());
		con.gridy = 1;
		basicPanel.add(type, con);
		
		FieldDisplay encumb = new FieldDisplay("Encumberance", Integer.toString(item.getEncumb()));
		con.gridy = 2;
		basicPanel.add(encumb, con);
		
		FieldDisplay hardPoints = new FieldDisplay("Hard Points", Integer.toString(item.getHardPoints()));
		con.gridy = 3;
		basicPanel.add(hardPoints, con);
		
		FieldDisplay rarity = new FieldDisplay("Rarity", Integer.toString(item.getRarity()));
		con.gridy = 4;
		basicPanel.add(rarity, con);
		
		FieldDisplay price = new FieldDisplay("Standard Price", Integer.toString(item.getPrice()));
		con.gridy = 5;
		basicPanel.add(price, con);
		
		
		
		this.add(basicPanel, BorderLayout.NORTH);
	}

}
