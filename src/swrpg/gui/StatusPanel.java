/**
 * 
 */
package swrpg.gui;

import java.awt.BorderLayout;

import javax.swing.JButton;

import swrpg.control.ChangeBoost;
import swrpg.control.ChangeSetback;
import swrpg.control.ChangeSetback.Action;
import swrpg.control.ChangeStatusNote;
import swrpg.model.Character;

/**
 * @author Mark
 *
 */
public class StatusPanel extends TitledBorderPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 854875224015304949L;

	private Character c;
	
	public StatusPanel(Character c)
	{
		super("STATUS");
		this.c = c;
		this.setLayout(new BorderLayout());
		addSetbackPanel();
		addBoostPanel();
		addStatusNotePanel();
	}
	
	private void addSetbackPanel()
	{
		TitledBorderPanel setbackPanel = new TitledBorderPanel("Setback");
		setbackPanel.setLayout(new BorderLayout());
		
		//Add the dice to the display
		int numSetback = c.getNumSetback();
		DiceDisplay dd = new DiceDisplay(0,0,0,0,0, numSetback);
		setbackPanel.add(dd, BorderLayout.NORTH);
		
		//Add the controlst to the display
		JButton add = new JButton("Add Setback");
		setbackPanel.add(add, BorderLayout.WEST);
		add.addActionListener(new ChangeSetback(c, dd, Action.ADD));
		JButton remove = new JButton("Remove Setback");
		remove.addActionListener(new ChangeSetback(c, dd, Action.REMOVE));
		setbackPanel.add(remove, BorderLayout.EAST);
		JButton clear = new JButton("Clear Setback");
		clear.addActionListener(new ChangeSetback(c, dd, Action.CLEAR));
		setbackPanel.add(clear, BorderLayout.SOUTH);
		
		
		this.add(setbackPanel, BorderLayout.NORTH);
	}
	
	private void addBoostPanel()
	{
		TitledBorderPanel boostPanel = new TitledBorderPanel("Setback");
		boostPanel.setLayout(new BorderLayout());
		
		//Add the dice to the display
		int numBoost = c.getNumBoost();
		DiceDisplay dd = new DiceDisplay(0,0,0,0,numBoost, 0);
		boostPanel.add(dd, BorderLayout.NORTH);
		
		//Add the controlst to the display
		JButton add = new JButton("Add Boost");
		boostPanel.add(add, BorderLayout.WEST);
		add.addActionListener(new ChangeBoost(c, dd, ChangeBoost.Action.ADD));
		JButton remove = new JButton("Remove Boost");
		remove.addActionListener(new ChangeBoost(c, dd, ChangeBoost.Action.REMOVE));
		boostPanel.add(remove, BorderLayout.EAST);
		JButton clear = new JButton("Clear Boost");
		clear.addActionListener(new ChangeBoost(c, dd, ChangeBoost.Action.CLEAR));
		boostPanel.add(clear, BorderLayout.SOUTH);
		
		
		this.add(boostPanel, BorderLayout.CENTER);
	}
	
	private void addStatusNotePanel()
	{
		EditableLongFieldDisplay statusNotesDisplay = new EditableLongFieldDisplay("Status Notes", c.getStatusNotes());
		//statusNotesDisplay.setRows(4);
		ChangeStatusNote action = new ChangeStatusNote(c, statusNotesDisplay);
		statusNotesDisplay.addActionListener(action);
		add(statusNotesDisplay, BorderLayout.SOUTH);
	}
}
