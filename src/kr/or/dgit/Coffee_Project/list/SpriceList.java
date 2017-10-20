package kr.or.dgit.Coffee_Project.list;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import kr.or.dgit.Coffee_Project.dto.CoffeeAndIncome;
import kr.or.dgit.Coffee_Project.dto.Total;
import kr.or.dgit.Coffee_Project.service.CoffeeAndIncomeService;

public class SpriceList extends AbstractList{
	private JTable table;
	private CoffeeAndIncomeService service;
	
	
	public SpriceList(CoffeeAndIncomeService service) {
		this.service = service;
	}


	@Override
	protected Object[][] getData() {
		List<CoffeeAndIncome> list = service.selectItemOrderbySprice();
		List<Total> ObjectList = service.selectTotal();
		Total total = ObjectList.get(0);
		
		int i;
		Object[][] datas = new Object[list.size()+1][];
		for( i = 0; i < list.size(); i++){
			CoffeeAndIncome cai = list.get(i);
			datas[i] = cai.toArray();
		}datas[i] = total.toArray();
		
		return datas;
	}

}
