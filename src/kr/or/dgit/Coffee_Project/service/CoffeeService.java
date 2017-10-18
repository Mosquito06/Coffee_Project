package kr.or.dgit.Coffee_Project.service;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import kr.or.dgit.Coffee_Project.dao.CoffeeDao;
import kr.or.dgit.Coffee_Project.dto.Coffee;

public class CoffeeService {
	private static final CoffeeService instance = new CoffeeService();
	private CoffeeDao coffeedao;
	
	public static CoffeeService getInstance() {
		return instance;
	}

	private CoffeeService() {
		coffeedao = new CoffeeDao();
		
	}
	
	public void updateItem(Coffee coffee){
		try {
			coffeedao.updateItem(coffee);
			JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteItem(Coffee coffee){
		try {
			coffeedao.deleteItem(coffee);
			JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�.");
		} catch (SQLException e) {
			System.err.printf("%s - %s%n", e.getMessage(), e.getErrorCode());
			e.printStackTrace();
		}
	}
	
	public void insertItem(Coffee coffee){
			try {
				coffeedao.insertItem(coffee);
				JOptionPane.showMessageDialog(null, "�߰� �Ǿ����ϴ�.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public List<Coffee> selectItembyAll(){
		try {
			return coffeedao.selectItemAll();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
		
	}

}
