package kr.or.dgit.Coffee_Project.list;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import kr.or.dgit.Coffee_Project.dto.CoffeeAndIncome;
import kr.or.dgit.Coffee_Project.service.CoffeeAndIncomeService;

public class SmarginList extends AbstractList{
	private JTable table;
	private CoffeeAndIncomeService service;
	
	
	public SmarginList(CoffeeAndIncomeService service) {
		this.service = service;
	}


	@Override
	protected Object[][] getData() {
		List<CoffeeAndIncome> list = service.selectItemOrderbySmargin();
		
		Object[][] datas = new Object[list.size()][];
		for(int i = 0; i < list.size(); i++){
			CoffeeAndIncome cai = list.get(i);
			datas[i] = cai.toArray();
		}
		
		return datas;
	}

}
