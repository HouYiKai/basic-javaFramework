package view;
import java.util.Vector;

import javax.swing.table.*;
public class stumodel extends AbstractTableModel {

	Sqlhelper sh=new Sqlhelper();
	Vector rowData=sh.getRowData();
	Vector columnNames=sh.getColumnNames();
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rowData.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return sh.columnNames.size();
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String)columnNames.get(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return ((Vector)rowData.get(rowIndex)).get(columnIndex);
	}

}
