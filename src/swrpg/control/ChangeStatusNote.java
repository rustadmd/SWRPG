/**
 * 
 */
package swrpg.control;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import swrpg.model.Character;
import swrpg.gui.EditableLongFieldDisplay;
/**
 * @author Mark
 *
 */
public class ChangeStatusNote extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4883120117526033675L;

	private Character c;
	private EditableLongFieldDisplay display;
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public ChangeStatusNote(Character c, EditableLongFieldDisplay display)
	{
		this.c = c;
		this.display = display;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String newNote = display.getText();
		c.setStatusNotes(newNote);

	}

}
