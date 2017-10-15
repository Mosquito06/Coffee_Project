package kr.or.dgit.Coffee_Project.dao;

public class CoffeeDao {
	private static final CoffeeDao instance = new CoffeeDao();

	public static CoffeeDao getInstance() {
		return instance;
	}

	public CoffeeDao() {
		super();
	}
	
	
	
}
