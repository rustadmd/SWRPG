/**
 * @author Mark Rustad
 * @version .01
 * @date Nov 1, 2014
 */
package swrpg.gui;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import swrpg.model.Character;
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
		addItemsTab(tabs);
		addMiscTab(tabs);
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
		JPanel itemsPanel = new JPanel();
		itemsPanel.setLayout(new GridBagLayout());
		
		int credits = c.getCredits();
		FieldDisplay creditDisplay = new FieldDisplay("Credits", Integer.toString(credits));
		GridBagConstraints creditConstraints = new GridBagConstraints();
		creditConstraints.gridx = 0;
		creditConstraints.gridy = 0;
		itemsPanel.add(creditDisplay, creditConstraints);
		
		//add the item list
		CharItemListPanel itemList = new CharItemListPanel(c.getItemList());
		GridBagConstraints itemListConstraints = new GridBagConstraints();
		itemListConstraints.fill = GridBagConstraints.BOTH;
		itemListConstraints.gridx = 0;
		itemListConstraints.gridy = 1;
		itemsPanel.add(itemList, itemListConstraints);
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
		
		p.addTab("Misc", miscPanel);
	}
}
