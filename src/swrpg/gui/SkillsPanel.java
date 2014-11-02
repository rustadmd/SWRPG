/**
 * @author Mark Rustad
 * @version .01
 * @date Nov 1, 2014
 */
package swrpg.gui;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

import swrpg.model.Skill;

/**
 * @author Mark
 *
 */
public class SkillsPanel extends TitledBorderPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6333750874853760045L;
	
	public SkillsPanel(String title, ArrayList<Skill> skills)
	{
		super(title);
		int numSkills = skills.size();
		int numRows = numSkills;
		int numColumns = 1;
		if (numSkills > 10)
		{
			numRows = numSkills/2;
			numColumns = 2;
		}
		//System.out.println("Number of Skills: " + numSkills);
		GridLayout gl = new GridLayout(numRows, numColumns);
		setLayout(gl);
		//setLayout(new FlowLayout());
		//add(new JLabel("Testing..."));
		Iterator<Skill> i = skills.iterator();
		while(i.hasNext())
		{
			this.add(new SkillDisplay(i.next()));
		}
	}

}
