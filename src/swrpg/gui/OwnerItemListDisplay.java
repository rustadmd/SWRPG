/**
 * @author Mark Rustad
 * @version .01
 * @date Nov 8, 2014
 */
package swrpg.gui;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import swrpg.model.OwnedItem;
import swrpg.model.UnEditableTableModel;

/**
 * @author Mark
 *
 */
public class OwnerItemListDisplay extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2752539691315991690L;
	private UnEditableTableModel model;
	private JTable table;
	
	public OwnerItemListDisplay(ArrayList<OwnedItem> list)
	{
		model = new UnEditableTableModel();
		table = new JTable(model);
		
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
		Iterator<OwnedItem> i = list.iterator();
		while (i.hasNext())
		{
			OwnedItem ci = i.next();
			Object[] row = {ci, ci.getCount()};
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
		
		addRowSelectedAction();
		

		//System.out.println(table.getPreferredScrollableViewportSize().getHeight());
		//System.out.println(table.getPreferredScrollableViewportSize().getWidth());
		
		//JScrollBar bar = new JScrollBar();
		//bar.setVisible(true);
		//scrollpane.setVerticalScrollBar(bar);
	}
	
	private void addRowSelectedAction()
	{
		table.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent me) {
		        JTable table =(JTable) me.getSource();
		        //Point p = me.getPoint();
		        //int row = table.rowAtPoint(p);
		        if (me.getClickCount() == 2) {
		            // your valueChanged overridden method 
		        	int selectedRow = table.getSelectedRow();
		        	TableModel model = table.getModel();
		        	ItemFrame frame = new ItemFrame((OwnedItem) model.getValueAt(selectedRow, 0));
		        	frame.setVisible(true);
		        	System.out.println(model.getValueAt(selectedRow, 0));
		        	
		        }
		    }
		});
	}

}
