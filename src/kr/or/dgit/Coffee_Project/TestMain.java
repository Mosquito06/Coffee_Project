package kr.or.dgit.Coffee_Project;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import kr.or.dgit.Coffee_Project.dao.CoffeeDao;
import kr.or.dgit.Coffee_Project.dao.IncomeDao;
import kr.or.dgit.Coffee_Project.dao.ProductDao;
import kr.or.dgit.Coffee_Project.dto.Coffee;
import kr.or.dgit.Coffee_Project.dto.Income;
import kr.or.dgit.Coffee_Project.dto.Product;
import kr.or.dgit.Coffee_Project.jdbc.DBCon;

public class TestMain {

	public static void main(String[] args) {
		DBCon db = DBCon.getInstance();
		
		Connection connection = db.getConnection();
		System.out.println(connection);
		
		
		CoffeeDao cd = new CoffeeDao();
		//Coffee cf = new Coffee(new Product("B003", 0), new Product("�Ϻ���", 1), 8000, 50, 5);
		Coffee cf2 = new Coffee(new Product("B003", 0), new Product("�Ϻ���", 1), 9500, 100, 5);
		Income ic = new Income(new Product("A002", 0));
		
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
		
			List<Product> result;
			try {
				result = pd.selectItemByAll();
				System.out.println(result);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		

	}

}
