package kr.or.dgit.Coffee_Project.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.dgit.Coffee_Project.dao.CoffeeAndIncomeDao;
import kr.or.dgit.Coffee_Project.dto.CoffeeAndIncome;
import kr.or.dgit.Coffee_Project.dto.Total;

public class CoffeeAndIncomeService {
	private static final CoffeeAndIncomeService instance = new CoffeeAndIncomeService();
	private CoffeeAndIncomeDao coffeeandincomedao;

	public static CoffeeAndIncomeService getInstance() {
		return instance;
	}

	public CoffeeAndIncomeService() {
		coffeeandincomedao = new CoffeeAndIncomeDao();
	}
	
	public List<CoffeeAndIncome> selectItemOrderbySprice(){
		try {
			return coffeeandincomedao.selectItemOrderbySprice();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<CoffeeAndIncome> selectItemOrderbySmargin(){
		try {
			return coffeeandincomedao.selectItemOrderbySmargin();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Total> selectTotal(){
		try {
			return coffeeandincomedao.selectTotal();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
