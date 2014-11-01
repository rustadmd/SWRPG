/**
 * @author Mark Rustad
 * @version .01
 * @date Nov 1, 2014
 */
package swrpg.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComponent;

import swrpg.model.Character;
/**
 * @author Mark
 *
 */
public class CharDescriptionPanel extends TitledBorderPanel {

	private static final long serialVersionUID = -630344356644817136L;

	public CharDescriptionPanel(Character c)
	{
		super("CHARACTER DESCRIPTION");
		setLayout(new GridBagLayout());
		
		FieldDisplay gender = new FieldDisplay("Gender", c.getGender());
		addField(gender, 0 , 0);
		FieldDisplay age = new FieldDisplay("Age", c.getAge());
		addField(age, 1 , 0);
		FieldDisplay height = new FieldDisplay("Height", c.getHeight());
		addField(height, 2 , 0);
		FieldDisplay build = new FieldDisplay("Build", c.getBuild());
		addField(build, 0 , 1);
		FieldDisplay hair = new FieldDisplay("Hair", c.getHair());
		addField(hair, 1 , 1);
		FieldDisplay eyes = new FieldDisplay("Eyes", c.getEyes());
		addField(eyes, 2 , 1);
		
		//the remaining should span the length of the field
		FieldDisplay features = new FieldDisplay("Noteable Features", c.getNoteableFeatures());
		GridBagConstraints constraint = new GridBagConstraints();
		//constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.gridx = 0;
		constraint.gridy = 2;
		constraint.gridwidth = 3;
		add(features, constraint);
		FieldDisplay history = new FieldDisplay("History", c.getHistory());
		constraint.gridy = 3;
		add(history, constraint);
	}
	
	private void addField(JComponent component, int xIndex, int yIndex)
	{
		GridBagConstraints constraint = new GridBagConstraints();
		//constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.gridx = xIndex;
		constraint.gridy = yIndex;
		add(component, constraint);
	}
}
