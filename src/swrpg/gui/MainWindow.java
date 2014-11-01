/**
 * @author Mark Rustad
 * @version .01
 * @date Oct 31, 2014
 */
package swrpg.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import swrpg.model.Character;

/**
 * @author Mark
 *
 */
public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7267067423345689638L;

	public MainWindow() {
		super("SWRPG");
		setLayout(new BorderLayout());
		setVisible(true);
		
		//testing
		Character mark = new Character(1000);
		CharacterPanel charPanel = new CharacterPanel(mark);
		add(charPanel);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}

}
