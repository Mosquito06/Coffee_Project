package kr.or.dgit.Coffee_Project.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.dgit.Coffee_Project.dto.CoffeeAndIncome;
import kr.or.dgit.Coffee_Project.dto.Product;
import kr.or.dgit.Coffee_Project.dto.Total;
import kr.or.dgit.Coffee_Project.jdbc.DBCon;

public class CoffeeAndIncomeDao {

	public CoffeeAndIncomeDao() {

	}

	public List<CoffeeAndIncome> selectItemOrderbySprice() throws SQLException {
		String sql = "select (select count(*)+1 from income where sPrice > t.sPrice) as '����', pCode, pName, pPrice, pTotal, oPrice, sTax, sPrice, coffee.pMargin, t.sMargin from income t join coffee using(pCode) order by sPrice desc";
		List<CoffeeAndIncome> lists = new ArrayList<>();

		try (PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				lists.add(getCofeeAndIncome(rs));
			}
			
		}
		return lists;
	}

	public List<CoffeeAndIncome> selectItemOrderbySmargin() throws SQLException {
		String sql = "select (select count(*)+1 from income where sMargin > t.sMargin) as '����', pCode, pName, pPrice, pTotal, oPrice, sTax, sPrice, coffee.pMargin, t.sMargin from income t join coffee using(pCode) order by sMargin desc";
		List<CoffeeAndIncome> lists = new ArrayList<>();

		try (PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				lists.add(getCofeeAndIncome(rs));
			}

		}

		return lists;
	}
	
	public List<Total> selectTotal() throws SQLException{
		String sql = "select sum(oPrice), sum(sTax), sum(sPrice), sum(sMargin) from income";
		List<Total> lists = new ArrayList<>();
		
		try (PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				lists.add(getTotal(rs));
			}

		}

		return lists;
	}

	private Total getTotal(ResultSet rs) throws SQLException {
		int oTprice = rs.getInt("sum(oPrice)");
		int sTtax = rs.getInt("sum(sTax)");
		int sTprice = rs.getInt("sum(sPrice)");
		int sTmargin = rs.getInt("sum(sMargin)");
		return new Total(oTprice, sTtax, sTprice, sTmargin);
	}

	private CoffeeAndIncome getCofeeAndIncome(ResultSet rs) throws SQLException {
		int rank = rs.getInt("����");
		Product pCode = new Product(rs.getString("pCode"), 0);
		Product pName = new Product(rs.getString("pName"), 1);
		int pPrice = rs.getInt("pPrice");
		int pTotal = rs.getInt("pTotal");
		int sPrice = rs.getInt("sPrice");
		int sTax = rs.getInt("sTax");
		int oPrice = rs.getInt("oPrice");
		int pMargin = rs.getInt("pMargin");
		int sMargin = rs.getInt("sMargin");
		return new CoffeeAndIncome(rank, pCode, pName, pPrice, pTotal, pMargin, sPrice, sTax, oPrice, sMargin);
	}

}
