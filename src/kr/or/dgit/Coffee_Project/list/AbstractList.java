package kr.or.dgit.Coffee_Project.list;

import java.awt.BorderLayout;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

@SuppressWarnings("serial")
public abstract class AbstractList extends JPanel {
	private JTable table;
	private static final String[] COL_NAMES = { "순위", "제품코드", "제품명", "제품단가", 
			"판매수량", "공급가액", "부가세액", "판매금액", "마진율", "마진액" };

	public AbstractList() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);

	}

	public void loadData() {
		DefaultTableModel model = new DefaultTableModel(getData(), getColumnNames());
		table.setModel(model);

		setAlignWidth();

	}

	private void setAlignWidth() {
		setAlign(SwingConstants.CENTER, 0, 1, 2);
		setAlign(SwingConstants.RIGHT, 3, 4, 5, 6, 7, 8, 9);
		setCellWidth(50, 100, 150, 100, 100, 100, 100, 100, 100, 100);
	}

	private void setCellWidth(int... width) {
		TableColumnModel cModel = table.getColumnModel();

		for (int i = 0; i < width.length; i++) {
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}
	}
	
	private void setAlign(int align, int...idx){
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);
		
		TableColumnModel cModel = table.getColumnModel();
		
		for (int i = 0; i < idx.length; i++){
			cModel.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}

	private String[] getColumnNames() {
		return COL_NAMES;
	}

	protected abstract Object[][] getData();
}
