/**
 * @author Mark Rustad
 * @version .01
 * @date Nov 1, 2014
 */
package swrpg.gui;

import java.awt.FlowLayout;

import javax.swing.JComponent;
import javax.swing.JLabel;

import swrpg.model.Skill;

/**
 * @author Mark
 *
 */
public class SkillDisplay extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 991843977755288817L;
	
	public SkillDisplay(Skill s)
	{
		setLayout(new FlowLayout());
		String skillString = String.format(" %s (%s) - %d", s.getName(), s.getBaseCharacteristic(), s.getRank());
		JLabel display = new JLabel(skillString);
		add(display);
		//System.out.println(skillString);
	}

}
