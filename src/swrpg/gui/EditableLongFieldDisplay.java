/**
 * 
 */
package swrpg.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;

/**
 * @author Mark
 *
 */
public class EditableLongFieldDisplay extends TitledBorderPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextArea textArea;
	private JButton saveButton;
	private final int DEFAULT_ROWS = 3;
	private final int DEFAULT_WIDTH = 20;
	
	public EditableLongFieldDisplay(String title)
	{
		this(title, "");
	}
	
	public EditableLongFieldDisplay(String title, String text)
	{
		super(title);
		this.setLayout(new BorderLayout());
		
		textArea = new JTextArea();
		textArea.setText(text);
		textArea.setColumns(DEFAULT_WIDTH);
		textArea.setRows(DEFAULT_ROWS);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(true);
		add(textArea, BorderLayout.CENTER);
		
		saveButton = new JButton("Save");
		add(saveButton, BorderLayout.SOUTH);
		
	}
	public String getText()
	{
		return textArea.getText();
	}
	
	public void addActionListener(ActionListener a)
	{
		saveButton.addActionListener(a);
	}
	
	public void setWidth(int width)
	{
		textArea.setColumns(width);
	}
	
	public void setRows(int rows)
	{
		textArea.setRows(rows);
	}

}
