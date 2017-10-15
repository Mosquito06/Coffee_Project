package kr.or.dgit.Coffee_Project.dto;

public class Product {
	private String pCode;
	private String pName;

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public Product(String pCode) {
		this.pCode = pCode;
	}

	public Product(String pCode, String pName) {
		this.pCode = pCode;
		this.pName = pName;
	}

	@Override
	public String toString() {
		return String.format("力前内靛 : %s, 力前疙 : %s", pCode, pName);
	}

}
