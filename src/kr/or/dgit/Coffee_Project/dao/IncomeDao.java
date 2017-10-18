package kr.or.dgit.Coffee_Project.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.dgit.Coffee_Project.dto.Income;
import kr.or.dgit.Coffee_Project.dto.Product;
import kr.or.dgit.Coffee_Project.jdbc.DBCon;

public class IncomeDao {
	public IncomeDao() {

	}

	public Income selectItemByNo(Income item) throws SQLException {
		String sql = "select pCode, sPrice, sTax, oPrice, sMargin from income where pCode = ?";
		Income income = null;

		try (PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);) {
			pstmt.setString(1, item.getpCode().getpCode());

			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					income = getIncome(rs);
				}
			}

		}
		return income;
	}
	
	public List<Income> selectItemByAll() throws SQLException{
		String sql = "select pCode, pCode, sPrice, sTax, oPrice, sMargin from income";		
		List<Income> lists = new ArrayList<>();
		try(PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			while(rs.next()){
				lists.add(getIncome(rs));
			}
		}
		return lists;
	}
	

	private Income getIncome(ResultSet rs) throws SQLException {
		Product pCode = new Product(rs.getString("pCode"), 0);
		int sPrice = rs.getInt("sPrice");
		int sTax = rs.getInt("sTax");
		int oPrice = rs.getInt("oPrice");
		int pMargin = rs.getInt("pMargin");
		return new Income(pCode, sPrice, sTax, oPrice, pMargin);
	}

}
