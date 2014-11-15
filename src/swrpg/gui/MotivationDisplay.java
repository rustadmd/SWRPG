/**
 * @author Mark Rustad
 * @version .01
 * @date Nov 14, 2014
 */
package swrpg.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import swrpg.model.Motivation;

/**
 * @author Mark
 *
 */
public class MotivationDisplay extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3523673776100873813L;

	public MotivationDisplay(Motivation m)
	{
		FieldDisplay type = new FieldDisplay("Type", m.getType());
		FieldDisplay title = new FieldDisplay("Summary", m.getTitle());
		FieldDisplay category = new FieldDisplay("Category", m.getGeneralType());
		FieldDisplay description = new FieldDisplay("Description", m.getDescription());
		
		setLayout(new GridBagLayout());
		GridBagConstraints typeCon = new GridBagConstraints();
		add(type, typeCon);
		
		GridBagConstraints titleCon = new GridBagConstraints();
		titleCon.gridy = 1;
		add(title, titleCon);
		
		GridBagConstraints catCon = new GridBagConstraints();
		catCon.gridy = 2;
		add(category, catCon);
		
		GridBagConstraints descripCon = new GridBagConstraints();
		descripCon.gridy = 3;
		add(description, descripCon);
		//System.out.println("Motivation display created");
	}
}
