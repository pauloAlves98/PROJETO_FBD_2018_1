package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;




public  class JTableButton{
	  private JTable table;
	  private JScrollPane scrollPane;

	  public JTableButton(JTableButtonModel jTableButtonModel) {
	   // super("JTableButton Demo");
	    TableCellRenderer defaultRenderer;
	    
	    table = new JTable(jTableButtonModel);
	    defaultRenderer = table.getDefaultRenderer(JButton.class);
	    table.setDefaultRenderer(JButton.class,new JTableButtonRenderer(defaultRenderer));
	    //table.setPreferredScrollableViewportSize(new Dimension(400, 200));
	    

	    scrollPane = new JScrollPane(table);
	   // setContentPane(scrollPane);
	  }
	  	
	  private class JTableButtonRenderer implements TableCellRenderer {
			  private TableCellRenderer __defaultRenderer;
	
			  public JTableButtonRenderer(TableCellRenderer renderer) {
			    __defaultRenderer = renderer;
			  }
	
			  public Component getTableCellRendererComponent(JTable table, Object value,
									 boolean isSelected,
									 boolean hasFocus,
									 int row, int column)
			  {
			    if(value instanceof Component)
			      return (Component)value;
			    return __defaultRenderer.getTableCellRendererComponent(
				   table, value, isSelected, hasFocus, row, column);
			  }
	  }
	  
	 
	public JTable getTable() {
		return table;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	  
}
	
