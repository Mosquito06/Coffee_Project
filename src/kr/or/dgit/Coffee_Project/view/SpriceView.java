package kr.or.dgit.Coffee_Project.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.Coffee_Project.list.AbstractList;
import kr.or.dgit.Coffee_Project.list.SpriceList;
import kr.or.dgit.Coffee_Project.service.CoffeeAndIncomeService;

public class SpriceView extends AbstractListView {

	private JPanel contentPane;
	
	public SpriceView(String title) {
		super(title);
		
	}
	
	@Override
	protected AbstractList CreatList() {
		return new SpriceList(new CoffeeAndIncomeService());
	}

}
