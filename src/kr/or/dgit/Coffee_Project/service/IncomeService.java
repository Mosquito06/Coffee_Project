package kr.or.dgit.Coffee_Project.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.dgit.Coffee_Project.dao.IncomeDao;
import kr.or.dgit.Coffee_Project.dto.Income;

public class IncomeService {
	private static final IncomeService instance = new IncomeService();
	private IncomeDao incomedao;
	
	
	public static IncomeService getInstance() {
		return instance;
	}

	private IncomeService() {
		incomedao = new IncomeDao();
	}

	public List<Income> selectItemByAll(){
		try {
			return incomedao.selectItemByAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Income selectItemByNo(Income income){
		try {
			return incomedao.selectItemByNo(income);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
