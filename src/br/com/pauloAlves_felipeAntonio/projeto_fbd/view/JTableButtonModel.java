package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

public class JTableButtonModel extends AbstractTableModel {
	  /**
	 * 
	 */
	private static final long serialVersionUID = -3690399213001062049L;

	private Object[][] __rows ;

	  private String[] __columns ;

	  public String getColumnName(int column) { 
	    return __columns[column];
	  }

	  public int getRowCount() {
	    return __rows.length;
	  }

	  public int getColumnCount() {
	    return __columns.length;
	  }

	  public Object getValueAt(int row, int column) { 
	      return __rows[row][column];
	  }

	  public boolean isCellEditable(int row, int column) {
	    return false;
	  }

	  public Class getColumnClass(int column) {
	    return getValueAt(0, column).getClass();
	  }
	  
	  public void adcionar(Object[][] obj,String [] s){
		  this.__rows=null;
		  this.__columns=null;
		  this.__rows=obj;
		  this.__columns = s;
	  }
	}
