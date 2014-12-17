/**
 * @author Mark Rustad
 * @version .01
 * @date Nov 1, 2014
 */
package swrpg.gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComponent;
import javax.swing.JLabel;

import swrpg.Settings;

/**
 * @author Mark
 *
 */
public class OneValueDisplay extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5948346855245054577L;

	JLabel valueLabel;
	
	public OneValueDisplay(String name, int value)
	{
		setLayout(new GridBagLayout());
		JLabel title = new JLabel(name);
		add(title);
		
		Font defaultFont = Settings.getLabelFont();
		Font valueFont = defaultFont.deriveFont(Font.BOLD, defaultFont.getSize() + 10);
		JLabel valueLabel = new JLabel(Integer.toString(value));
		valueLabel.setFont(valueFont);
		GridBagConstraints valueConstraint = new GridBagConstraints();
		valueConstraint.gridy =1;
		add(valueLabel, valueConstraint);
	}
	
	public void setValue(String newValue)
	{
		valueLabel.setText(newValue);
	}
}
