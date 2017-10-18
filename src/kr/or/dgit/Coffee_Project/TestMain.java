package kr.or.dgit.Coffee_Project;

import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import kr.or.dgit.Coffee_Project.dao.CoffeeAndIncomeDao;
import kr.or.dgit.Coffee_Project.dao.CoffeeDao;
import kr.or.dgit.Coffee_Project.dao.IncomeDao;
import kr.or.dgit.Coffee_Project.dao.ProductDao;
import kr.or.dgit.Coffee_Project.dto.Coffee;
import kr.or.dgit.Coffee_Project.dto.Income;
import kr.or.dgit.Coffee_Project.dto.Product;
import kr.or.dgit.Coffee_Project.jdbc.DBCon;
import kr.or.dgit.Coffee_Project.list.AbstractList;
import kr.or.dgit.Coffee_Project.list.SpriceList;
import kr.or.dgit.Coffee_Project.service.CoffeeAndIncomeService;

public class TestMain {

	public static void main(String[] args) {
		DBCon db = DBCon.getInstance();
		
		Connection connection = db.getConnection();
		System.out.println(connection);
				
		CoffeeDao cd = new CoffeeDao();
		Coffee cf = new Coffee(new Product("B003", 0), new Product("ÆÏºù¼ö", 1), 8000, 50, 5);
		Coffee cf2 = new Coffee(new Product("B003", 0), new Product("ÆÏºù¼ö", 1), 9500, 100, 5);
		Income ic = new Income(new Product("A002", 0));
		CoffeeAndIncomeDao  dffd = new CoffeeAndIncomeDao();
		Product pr = new Product("A001", 0);
		
		ProductDao pd = new ProductDao();
		IncomeDao id = new IncomeDao();
		// Product product = new Product("A001");
		
			/*try {
				//cd.insertItem(cf);
				//cd.updateItem(cf2);
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
		
		
		System.out.println(CoffeeAndIncomeService.getInstance().selectItemOrderbySprice());
		
		JFrame jf = new JFrame();
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setBounds(10, 10, 500, 500);
		
		CoffeeAndIncomeService cai = new CoffeeAndIncomeService();
		AbstractList al = new SpriceList(cai);
		al.loadData();
		jf.add(al);
		jf.setVisible(true);
		
	}

}
