package kr.or.dgit.Coffee_Project;

import kr.or.dgit.Coffee_Project.jdbc.DBCon;

public class TestMain {

	public static void main(String[] args) {
		DBCon db = DBCon.getInstance();
		System.out.println(db);

	}

}
