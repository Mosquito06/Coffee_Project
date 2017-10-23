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

	public Product(String pCode, int Difference) {
		if (Difference == 0) {
			this.pCode = pCode;
		} else {
			this.pName = pCode;
		}

	}

	public Product(String pCode, String pName) {
		this.pCode = pCode;
		this.pName = pName;
	}

	@Override
	public String toString() {
		return String.format("%s", createTostring());
	}

	private Object createTostring() {
		if(pCode == null || pName == null){
			if(pCode == null){
				return pName;
			}else if(pName == null){
				return pCode;
			}
		}else{
			return pName+"("+pCode+")";
		}
		return null;
	}

}
