package kr.or.dgit.Coffee_Project.service;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import kr.or.dgit.Coffee_Project.dao.ProductDao;
import kr.or.dgit.Coffee_Project.dto.Product;

public class ProductService {
	private static final ProductService instance = new ProductService();
	private ProductDao productdao;

	public static ProductService getInstance() {
		return instance;
	}

	private ProductService() {
		productdao = new ProductDao();
	}

	
	public void insertItem(Product product){
		try {
			productdao.insertItem(product);
			JOptionPane.showMessageDialog(null, "추가가 완료되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Product selectItemByno(Product product){
		try {
			return productdao.selectItemByNo(product);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Product> selectItemByAll(){
		try {
			return productdao.selectItemByAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
}
