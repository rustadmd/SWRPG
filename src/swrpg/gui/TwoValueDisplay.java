/**
 * @author Mark Rustad
 * @version .01
 * @date Nov 8, 2014
 */
package swrpg.gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import swrpg.Settings;

/**
 * @author Mark
 *
 */
public class TwoValueDisplay extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2437433577015589356L;
	private final String DEFAULT_LEFT_MOD = "Threshold";
	private final String DEFAULT_RIGHT_MOD = "Current";
	private final String SPACING = " ";
	
	public TwoValueDisplay(String name, int leftSide, int rightSide)
	{
		//Get font settings
		Font defaultFont = Settings.getLabelFont();
		Font valueFont = defaultFont.deriveFont(Font.BOLD, defaultFont.getSize() + 10);
		Font modifierFont = defaultFont.deriveFont((float)defaultFont.getSize() - 4);
		//System.out.println("Modfied font: " + modifierFont.getSize());
		
		//Add the title
		setLayout(new GridBagLayout());
		JLabel title = new JLabel(name);
		title.setHorizontalTextPosition(SwingConstants.CENTER);
		GridBagConstraints titleConstraint = new GridBagConstraints();
		titleConstraint.gridwidth =2;
		add(title, titleConstraint);
		
		//Add left value
		JLabel leftValueLabel = new JLabel(Integer.toString(leftSide));
		leftValueLabel.setFont(valueFont);
		GridBagConstraints leftSideConstraint = new GridBagConstraints();
		leftSideConstraint.gridx =0;
		leftSideConstraint.gridy =1;
		add(leftValueLabel, leftSideConstraint);
		
		//add right value
		JLabel rightValueLabel = new JLabel(Integer.toString(rightSide));
		rightValueLabel.setFont(valueFont);
		GridBagConstraints rightSideConstraint = new GridBagConstraints();
		rightSideConstraint.gridx =1;
		rightSideConstraint.gridy =1;
		add(rightValueLabel, rightSideConstraint);
		
		//make sure modifiers are the same size
		
		//add left modifier
		JLabel leftModLabel = new JLabel(DEFAULT_LEFT_MOD);
		leftModLabel.setFont(modifierFont);
		GridBagConstraints leftModConstraint = new GridBagConstraints();
		leftModConstraint.gridx =0;
		leftModConstraint.gridy =2;
		add(leftModLabel, leftModConstraint);
		
		//add right modifier
		JLabel rightModLabel = new JLabel(SPACING + DEFAULT_RIGHT_MOD);
		rightModLabel.setFont(modifierFont);
		GridBagConstraints rightModConstraints = new GridBagConstraints();
		rightModConstraints.gridx =1;
		rightModConstraints.gridy =2;
		add(rightModLabel, rightModConstraints);
	}

}
