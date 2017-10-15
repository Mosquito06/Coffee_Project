package kr.or.dgit.Coffee_Project;

import java.sql.Connection;
import java.sql.SQLException;

import kr.or.dgit.Coffee_Project.dao.ProductDao;
import kr.or.dgit.Coffee_Project.dto.Product;
import kr.or.dgit.Coffee_Project.jdbc.DBCon;

public class TestMain {

	public static void main(String[] args) {
		DBCon db = DBCon.getInstance();
		
		Connection connection = db.getConnection();
		System.out.println(connection);
		
		
		ProductDao pd = ProductDao.getInstance();
		
		Product product = new Product("A001");
		try {
			Product result = pd.SelectNameByNo(product);
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
