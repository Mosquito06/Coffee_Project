package kr.or.dgit.Coffee_Project.common;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import kr.or.dgit.Coffee_Project.dto.Product;
import kr.or.dgit.Coffee_Project.service.ProductService;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public abstract class AbstactListComponent<T> extends JPanel {

	public AbstactListComponent() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		DefaultListModel<T> model = createModel();
		JList<T> list = new JList<>(model);
		
		scrollPane.setViewportView(list);
	}

	protected abstract DefaultListModel<T> createModel();

		
	
}
