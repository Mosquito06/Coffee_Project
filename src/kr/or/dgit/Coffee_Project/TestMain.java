package kr.or.dgit.Coffee_Project;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import kr.or.dgit.Coffee_Project.dao.CoffeeDao;
import kr.or.dgit.Coffee_Project.dto.Coffee;
import kr.or.dgit.Coffee_Project.dto.Product;
import kr.or.dgit.Coffee_Project.jdbc.DBCon;

public class TestMain {

	public static void main(String[] args) {
		DBCon db = DBCon.getInstance();
		
		Connection connection = db.getConnection();
		System.out.println(connection);
		
		
		CoffeeDao cd = new CoffeeDao();
		
		// Product product = new Product("A001");
		
			List<Coffee> result;
			try {
				result = cd.selectItemAll();
				System.out.println(result);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		

	}

}
