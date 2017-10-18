package kr.or.dgit.Coffee_Project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.dgit.Coffee_Project.dto.Coffee;
import kr.or.dgit.Coffee_Project.dto.Product;
import kr.or.dgit.Coffee_Project.jdbc.DBCon;

public class CoffeeDao {
	public CoffeeDao() {

	}

	public void updateItem(Coffee item) throws SQLException{
		String sql = "update coffee set pName = ?, pPrice = ?, pTotal =?, pMargin = ? where pCode = ?";
		try(PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);){
			pstmt.setString(1, item.getpName().getpName());
			pstmt.setInt(2, item.getpPrice());
			pstmt.setInt(3, item.getpTotal());
			pstmt.setInt(4, item.getpMargin());
			pstmt.setString(5, item.getpCode().getpCode());
			pstmt.executeUpdate();
		}
	}
	
	
	public void deleteItem(Coffee item) throws SQLException{
		String sql = "delete from coffee where pCode = ?";
		Connection con = DBCon.getInstance().getConnection();
		
		try(PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setString(1, item.getpCode().getpCode());
			pstmt.executeUpdate();
		}
	}
	
	
	public void insertItem(Coffee item) throws SQLException {
		String sql = "insert into coffee values(?, ?, ?, ?, ?)";
		Connection con = DBCon.getInstance().getConnection();

		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, item.getpCode().getpCode());
			pstmt.setString(2, item.getpName().getpName());
			pstmt.setInt(3, item.getpPrice());
			pstmt.setInt(4, item.getpTotal());
			pstmt.setInt(5, item.getpMargin());
			pstmt.executeUpdate();
		}

	}

	public List<Coffee> selectItemAll() throws SQLException {
		String sql = "select pCode, pName, pPrice, pTotal, pMargin from coffee";
		List<Coffee> lists = new ArrayList<>();
		try (PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				lists.add(getCoffee(rs));
			}
		}

		return lists;
	}

	private Coffee getCoffee(ResultSet rs) throws SQLException {
		Product pCode = new Product(rs.getString("pCode"), 0);
		Product pName = new Product(rs.getString("pName"), 1);
		int pPrice = rs.getInt("pPrice");
		int pTotal = rs.getInt("pTotal");
		int pMargin = rs.getInt("pMargin");
		return new Coffee(pCode, pName, pPrice, pTotal, pMargin);
	}

}
