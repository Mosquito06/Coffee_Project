package kr.or.dgit.Coffee_Project.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.dgit.Coffee_Project.dto.Product;
import kr.or.dgit.Coffee_Project.jdbc.DBCon;

public class ProductDao {
	public ProductDao() {

	}

	public Product selectItemByNo(Product item) throws SQLException {
		String sql = "select pCode, pName from product where pCode = ?";
		Product product = null;

		try (PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);) {
			pstmt.setString(1, item.getpCode());

			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					product = getProduct(rs);
				}
			}

		}
		return product;
	}
	
	public List<Product> selectItemByAll() throws SQLException{
		String sql = "select pCode, pName from product";		
		List<Product> lists = new ArrayList<>();
		try(PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			while(rs.next()){
				lists.add(getProduct(rs));
			}
		}
		return lists;
	}
	

	private Product getProduct(ResultSet rs) throws SQLException {
		String pCode = rs.getString("pCode");
		String pName = rs.getString("pName");
		return new Product(pCode, pName);
	}

}
