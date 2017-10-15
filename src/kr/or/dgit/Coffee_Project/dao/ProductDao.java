package kr.or.dgit.Coffee_Project.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.dgit.Coffee_Project.dto.Product;
import kr.or.dgit.Coffee_Project.jdbc.DBCon;

public class ProductDao {
	private static final ProductDao instance = new ProductDao();

	public static ProductDao getInstance() {
		return instance;
	}

	private ProductDao() {
		super();

	}

	public Product SelectNameByNo(Product item) throws SQLException {
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

	private Product getProduct(ResultSet rs) throws SQLException {
		String pCode = rs.getString(1);
		String pName = rs.getString(2);
		return new Product(pCode, pName);
	}

}
