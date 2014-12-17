/**
 * @author Mark Rustad
 * @version .01
 * @date Nov 1, 2014
 */
package swrpg.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import swrpg.control.ChangeStrain;
import swrpg.control.ChangeWounds;
import swrpg.model.Character;
import swrpg.model.Motivation;
import swrpg.model.Obligation;

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
	
	//Various panels
	StatsPanel statsPanel;
	
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
		statsPanel = new StatsPanel(c);
		add(statsPanel, stats);
		
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
		addItemsTab(tabs);
		addMiscTab(tabs);
		
		//Add status box
		GridBagConstraints statusCon = new GridBagConstraints();
		statusCon.gridx = 3;
		statusCon.gridy = 0;
		statusCon.gridheight = 3;
		StatusPanel status = new StatusPanel(c);
		add(status, statusCon);
		
		addControlsPanel();
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

	private void addItemsTab(JTabbedPane p)
	{
		CharItemPanel itemsPanel = new CharItemPanel(c);
		p.addTab("Items", itemsPanel);
	}
	
	private void addMiscTab(JTabbedPane p)
	{
		//Create mini panel for xp (doesn't need separate panel)//
		TitledBorderPanel xpPanel = new TitledBorderPanel("XP");
		xpPanel.setLayout(new GridLayout (2, 1));
		String totalXp = Integer.toString(c.getXpTotal());
		FieldDisplay totalXpDisp = new FieldDisplay("Total", totalXp);
		String availXp = Integer.toString(c.getXpAvailable());
		FieldDisplay availXpDisp = new FieldDisplay("Available", availXp);
		xpPanel.add(totalXpDisp);
		xpPanel.add(availXpDisp);
		
		//create obligations panel
		TitledBorderPanel obligationPanel = new TitledBorderPanel("OBLIGATIONS");
		ArrayList<Obligation> obligations = c.getObligationList();
		int numObligations = obligations.size();
		obligationPanel.setLayout(new GridLayout(1, numObligations));
		
		Iterator<Obligation> i = obligations.iterator();
		while(i.hasNext())
		{
			obligationPanel.add(new ObligationDisplay(i.next()));
		}
		
		//create motivations panel
		TitledBorderPanel motivationPanel = new TitledBorderPanel("MOTIVATIONS");
		ArrayList<Motivation> motivations = c.getMotivationList();
		int numMotivations = motivations.size();
		//System.out.println("Number of motivations: " + numMotivations);
		motivationPanel.setLayout(new GridLayout(1, numMotivations));
		
		Iterator<Motivation> im = motivations.iterator();
		while(im.hasNext())
		{
			motivationPanel.add(new MotivationDisplay(im.next()));
			//System.out.println("Motivation display executed");
		}
		
		
		//put all panels together
		JPanel miscPanel = new JPanel();
		miscPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints xpCon = new GridBagConstraints();
		xpCon.gridx = 0;
		xpCon.gridx = 0;
		miscPanel.add(xpPanel);
		
		GridBagConstraints obCon = new GridBagConstraints();
		obCon.fill = GridBagConstraints.BOTH;
		obCon.gridx = 0;
		obCon.gridy = 1;
		miscPanel.add(obligationPanel, obCon);
		
		
		GridBagConstraints movCon = new GridBagConstraints();
		//movCon.fill = GridBagConstraints.BOTH;
		movCon.gridx = 0;
		movCon.gridy = 2;
		miscPanel.add(motivationPanel, movCon);
		p.addTab("Misc", miscPanel);
	}
	
	private void addControlsPanel()
	{
		TitledBorderPanel controlPanel = new TitledBorderPanel("CONTROLS");
		GridBagConstraints conCon = new GridBagConstraints();
		conCon.gridx = 3; conCon.gridy = 3;
		controlPanel.setLayout(new GridBagLayout());
		
		JTextField input = new JTextField("1");
		input.setColumns(5);
		GridBagConstraints inputCon = new GridBagConstraints();
		inputCon.gridx = 0; inputCon.gridy = 0; inputCon.gridwidth = 2;
		controlPanel.add(input, inputCon);
		
		JButton takeStrain = new JButton("Take Strain");
		GridBagConstraints takeStrainCon = new GridBagConstraints();
		takeStrainCon.gridy = 1;
		ChangeStrain takeStrainAction 
			= new ChangeStrain(c, ChangeStrain.Action.TAKE_CURRENT, statsPanel.getStrain(), input);
		takeStrain.addActionListener(takeStrainAction);
		controlPanel.add(takeStrain, takeStrainCon);
		
		JButton recoverStrain = new JButton("Recover Strain");
		GridBagConstraints recoverStrainCon = new GridBagConstraints();
		recoverStrainCon.gridx = 1; recoverStrainCon.gridy = 1;
		ChangeStrain recoverStrainAction 
			= new ChangeStrain(c, ChangeStrain.Action.RECOVER_CURRENT, statsPanel.getStrain(), input);
		recoverStrain.addActionListener(recoverStrainAction);
		controlPanel.add(recoverStrain, recoverStrainCon);
		
		JButton takeWound = new JButton("Take Wounds");
		GridBagConstraints takeWoundCon = new GridBagConstraints();
		takeWoundCon.gridx = 0; takeWoundCon.gridy = 2;
		ChangeWounds takeWoundsAction 
			= new ChangeWounds(c, ChangeWounds.Action.TAKE_CURRENT, statsPanel.getWounds(), input);
		takeWound.addActionListener(takeWoundsAction);
		controlPanel.add(takeWound, takeWoundCon);
		
		JButton recoverWounds = new JButton("Recover Wounds");
		GridBagConstraints recoverWoundsCon = new GridBagConstraints();
		recoverWoundsCon.gridx = 1; recoverWoundsCon.gridy = 2;
		ChangeWounds recoverWoundsAction 
			= new ChangeWounds(c, ChangeWounds.Action.RECOVER_CURRENT, statsPanel.getWounds(), input);
		recoverWounds.addActionListener(recoverWoundsAction);
		controlPanel.add(recoverWounds, recoverWoundsCon);
		
		add(controlPanel, conCon);
	}
}
