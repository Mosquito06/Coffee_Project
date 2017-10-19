package kr.or.dgit.Coffee_Project.view;

import javax.swing.JPanel;

import kr.or.dgit.Coffee_Project.list.AbstractList;
import kr.or.dgit.Coffee_Project.list.SmarginList;
import kr.or.dgit.Coffee_Project.service.CoffeeAndIncomeService;

public class SmarginView extends AbstractListView {

	private JPanel contentPane;
	
	public SmarginView(String title) {
		super(title);
		
	}
	
	@Override
	protected AbstractList CreatList() {
		return new SmarginList(new CoffeeAndIncomeService());
	}

}
