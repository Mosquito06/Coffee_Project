package kr.or.dgit.Coffee_Project.dto;

public class Coffee {
	private String pCode;
	private String pName;
	private int pPrice;
	private int pTotal;
	private int pMargin;

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

	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}

	public int getpTotal() {
		return pTotal;
	}

	public void setpTotal(int pTotal) {
		this.pTotal = pTotal;
	}

	public int getpMargin() {
		return pMargin;
	}

	public void setpMargin(int pMargin) {
		this.pMargin = pMargin;
	}

	public Coffee(String pCode, String pName, int pPrice, int pTotal, int pMargin) {
		this.pCode = pCode;
		this.pName = pName;
		this.pPrice = pPrice;
		this.pTotal = pTotal;
		this.pMargin = pMargin;
	}

	@Override
	public String toString() {
		return String.format("��ǰ�ڵ� : %s, ��ǰ�� : %s, ��ǰ�ܰ� : %s,  �Ǹż��� : %s, ������ : %s", pCode, pName, pPrice,
				pTotal, pMargin);
	}

}
