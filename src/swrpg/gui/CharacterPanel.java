/**
 * @author Mark Rustad
 * @version .01
 * @date Nov 1, 2014
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
public class CharacterPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4984603624626444246L;

	public CharacterPanel(Character c)
	{
		setLayout(new GridBagLayout());
		
		//add the header
		GridBagConstraints header = new GridBagConstraints();
		header.gridx = 0;
		header.gridy = 0;
		add(new CharHeaderPanel(c), header);
		
		//ad description
		GridBagConstraints description = new GridBagConstraints();
		description.fill = GridBagConstraints.HORIZONTAL;
		description.gridx = 1;
		description.gridy = 0;
		add(new CharDescriptionPanel(c), description);
		
		//characteristics panel
		GridBagConstraints charac = new GridBagConstraints();
		charac.fill = GridBagConstraints.HORIZONTAL;
		charac.gridx = 0;
		charac.gridy = 1;
		charac.gridwidth = 2;
		add(new CharacteristicsPanel(c), charac);
		
		//general skills panel
		GridBagConstraints genSkills = new GridBagConstraints();
		genSkills.fill = GridBagConstraints.HORIZONTAL;
		genSkills.gridx = 0;
		genSkills.gridy = 2;
		genSkills.gridheight = 2;
		add(new SkillsPanel("GENERAL SKILLS", c.getGenSkills()), genSkills);
		
		//combat skills panel
		GridBagConstraints combatSkills = new GridBagConstraints();
		combatSkills.fill = GridBagConstraints.HORIZONTAL;
		combatSkills.gridx = 1;
		combatSkills.gridy = 2;
		add(new SkillsPanel("COMBAT SKILLS", c.getCombatSkills()), combatSkills);
		
		//knowledge skills panel
		GridBagConstraints knowledgeSkills = new GridBagConstraints();
		knowledgeSkills.fill = GridBagConstraints.HORIZONTAL;
		knowledgeSkills.gridx = 1;
		knowledgeSkills.gridy = 3;
		add(new SkillsPanel("KNOWLEDGE SKILLS", c.getKnowledgeSkills()), knowledgeSkills);
	}

}
