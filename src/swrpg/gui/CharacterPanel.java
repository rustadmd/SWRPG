/**
 * @author Mark Rustad
 * @version .01
 * @date Nov 1, 2014
 */
package swrpg.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

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
	private Character c;
	
	public CharacterPanel(Character c)
	{
		setLayout(new GridBagLayout());
		int fullWidth = 2;
		this.c = c;
		
		//add the header
		GridBagConstraints header = new GridBagConstraints();
		header.gridx = 0;
		header.gridy = 0;
		add(new CharHeaderPanel(c), header);
		
		//add description
		GridBagConstraints description = new GridBagConstraints();
		description.fill = GridBagConstraints.HORIZONTAL;
		description.gridx = 1;
		description.gridy = 0;
		add(new CharDescriptionPanel(c), description);
		
		//statistics panel
		GridBagConstraints stats = new GridBagConstraints();
		stats.fill = GridBagConstraints.HORIZONTAL;
		stats.gridx = 0;
		stats.gridy = 1;
		stats.gridwidth = fullWidth;
		add(new StatsPanel(c), stats);
		
		//characteristics panel
		GridBagConstraints charac = new GridBagConstraints();
		charac.fill = GridBagConstraints.HORIZONTAL;
		charac.gridx = 0;
		charac.gridy = 2;
		charac.gridwidth = fullWidth;
		add(new CharacteristicsPanel(c), charac);
		
		//Add the tabbed pane
		JTabbedPane tabs = new JTabbedPane();
		GridBagConstraints tabConstraints = new GridBagConstraints();
		tabConstraints.gridwidth = fullWidth;
		tabConstraints.gridy = 3;
		add(tabs, tabConstraints);
		
		addSkillsTab(tabs);
		
		}
	
	private void addSkillsTab(JTabbedPane p)
	{
		JPanel skillsPanel = new JPanel(new GridBagLayout());
		//general skills panel
		GridBagConstraints genSkills = new GridBagConstraints();
		genSkills.fill = GridBagConstraints.HORIZONTAL;
		genSkills.gridx = 0;
		genSkills.gridy = 0;
		genSkills.gridwidth = 2;
		genSkills.gridheight = 2;
		skillsPanel.add(new SkillsPanel("GENERAL SKILLS", c.getGenSkills()), genSkills);
		
		//combat skills panel
		GridBagConstraints combatSkills = new GridBagConstraints();
		combatSkills.fill = GridBagConstraints.HORIZONTAL;
		combatSkills.gridx = 2;
		combatSkills.gridy = 0;
		skillsPanel.add(new SkillsPanel("COMBAT SKILLS", c.getCombatSkills()), combatSkills);
		
		//knowledge skills panel
		GridBagConstraints knowledgeSkills = new GridBagConstraints();
		knowledgeSkills.fill = GridBagConstraints.HORIZONTAL;
		knowledgeSkills.gridx = 2;
		knowledgeSkills.gridy = 1;
		skillsPanel.add(new SkillsPanel("KNOWLEDGE SKILLS", c.getKnowledgeSkills()), knowledgeSkills);
		
		p.addTab("Skills", skillsPanel);
	}

}
