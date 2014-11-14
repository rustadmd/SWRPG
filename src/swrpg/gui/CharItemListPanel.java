/**
 * @author Mark Rustad
 * @version .01
 * @date Nov 8, 2014
 */
package swrpg.gui;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import swrpg.model.CharItem;

/**
 * @author Mark
 *
 */
public class CharItemListPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2752539691315991690L;
	
	public CharItemListPanel(ArrayList<CharItem> list)
	{
		DefaultTableModel model = new DefaultTableModel();
		JTable table = new JTable(model);
		
		//set up columns
		//model.setColumnIdentifiers(columnNames);
		model.addColumn("Item");
		model.addColumn("Count");
		TableColumnModel columns = table.getColumnModel();
		TableColumn nameColumn = columns.getColumn(0);
		//nameColumn.setHeaderValue("Item");
		nameColumn.setMinWidth(150);
		
		TableColumn countColumn = columns.getColumn(1);
		//countColumn.setHeaderValue("Amount");
		countColumn.setPreferredWidth(20);
		
	
		//fill the table
		Iterator<CharItem> i = list.iterator();
		while (i.hasNext())
		{
			CharItem ci = i.next();
			Object[] row = {ci.getItem().getName(), ci.getCount()};
			model.addRow(row);
		}
		JScrollPane scrollpane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(scrollpane);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//Size issues
		Dimension d = new Dimension();
		d.height = 200;
		d.width = 300;
		table.setPreferredScrollableViewportSize(d);

		//System.out.println(table.getPreferredScrollableViewportSize().getHeight());
		//System.out.println(table.getPreferredScrollableViewportSize().getWidth());
		
		//JScrollBar bar = new JScrollBar();
		//bar.setVisible(true);
		//scrollpane.setVerticalScrollBar(bar);
	}

}
