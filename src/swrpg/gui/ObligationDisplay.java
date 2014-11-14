/**
 * @author Mark Rustad
 * @version .01
 * @date Nov 14, 2014
 */
package swrpg.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import swrpg.model.Obligation;

/**
 * @author Mark
 *
 */
public class ObligationDisplay extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8198885947130089239L;

	public ObligationDisplay(Obligation o)
	{
		String magnitude = Integer.toString(o.getMagnitude());
		FieldDisplay type = new FieldDisplay("Type", o.getObligationName());
		FieldDisplay title = new FieldDisplay("Summary", o.getTitle());
		FieldDisplay magDisp = new FieldDisplay("Magnitude", magnitude);
		FieldDisplay complications = new FieldDisplay("Complications", o.getComplications());
		
		setLayout(new GridBagLayout());
		GridBagConstraints typeCon = new GridBagConstraints();
		add(type, typeCon);
		
		GridBagConstraints titleCon = new GridBagConstraints();
		titleCon.gridy = 1;
		add(title, titleCon);
		
		GridBagConstraints magCon = new GridBagConstraints();
		magCon.gridy = 2;
		add(magDisp, magCon);
		
		GridBagConstraints compCon = new GridBagConstraints();
		compCon.gridy = 3;
		add(complications, compCon);
	}
}
