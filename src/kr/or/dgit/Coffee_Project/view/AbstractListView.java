package kr.or.dgit.Coffee_Project.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.Coffee_Project.list.AbstractList;
import kr.or.dgit.Coffee_Project.list.SpriceList;
import kr.or.dgit.Coffee_Project.service.CoffeeAndIncomeService;

public abstract class AbstractListView extends JFrame {

	private JPanel contentPane;
	
	public AbstractListView(String title) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 725, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		
		AbstractList abstractlist = CreatList();
		abstractlist.loadData();
		contentPane.add(abstractlist, BorderLayout.CENTER);
	}

	protected abstract AbstractList CreatList();

}
