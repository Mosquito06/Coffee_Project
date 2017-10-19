package kr.or.dgit.Coffee_Project.common;

import java.util.List;

import javax.swing.DefaultListModel;

import kr.or.dgit.Coffee_Project.dto.Coffee;
import kr.or.dgit.Coffee_Project.service.CoffeeService;

public class SaleListComponent extends AbstactListComponent<Coffee> {

	public SaleListComponent() {

	}

	@Override
	protected DefaultListModel<Coffee> createModel() {
		DefaultListModel<Coffee> model = new DefaultListModel<>();
		
		List<Coffee> list = CoffeeService.getInstance().selectItembyAll();
		for(Coffee c : list){
			model.addElement(c);
		}
		return model;
	}

	@Override
	protected List<Coffee> setListAll() {
		return CoffeeService.getInstance().selectItembyAll();
	}

}
