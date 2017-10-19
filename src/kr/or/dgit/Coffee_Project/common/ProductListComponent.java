package kr.or.dgit.Coffee_Project.common;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import kr.or.dgit.Coffee_Project.dto.Product;
import kr.or.dgit.Coffee_Project.service.ProductService;

public class ProductListComponent extends AbstactListComponent<Product> {

	public ProductListComponent() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		DefaultListModel<Product> model = createModel();
		JList<Product> list = new JList<>(model);
		
		scrollPane.setViewportView(list);
	}

	protected DefaultListModel<Product> createModel() {
		DefaultListModel<Product> model = new DefaultListModel<>();
		
		List<Product> list = ProductService.getInstance().selectItemByAll();
		for(Product p : list){
			model.addElement(p);
		}
		return model;
	}

		
	
}
