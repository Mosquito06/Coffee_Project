package kr.or.dgit.Coffee_Project.dto;

public class Income {
	private Product pCode;
	private int sPrice;
	private int sTax;
	private int oPrice;
	private int pMargin;

	public Product getpCode() {
		return pCode;
	}

	public void setpCode(Product pCode) {
		this.pCode = pCode;
	}

	public int getsPrice() {
		return sPrice;
	}

	public void setsPrice(int sPrice) {
		this.sPrice = sPrice;
	}

	public int getsTax() {
		return sTax;
	}

	public void setsTax(int sTax) {
		this.sTax = sTax;
	}

	public int getoPrice() {
		return oPrice;
	}

	public void setoPrice(int oPrice) {
		this.oPrice = oPrice;
	}

	public int getpMargin() {
		return pMargin;
	}

	public void setpMargin(int pMargin) {
		this.pMargin = pMargin;
	}

	public Income(Product pCode) {
		this.pCode = pCode;
	}

	public Income(Product pCode, int sPrice, int sTax, int oPrice, int pMargin) {
		this.pCode = pCode;
		this.sPrice = sPrice;
		this.sTax = sTax;
		this.oPrice = oPrice;
		this.pMargin = pMargin;
	}

	@Override
	public String toString() {
		return String.format("��ǰ�ڵ� : %s, �Ǹűݾ� : %s, �ΰ����� : %s, ���ް��� : %s, ������ : %s", pCode.getpCode(), sPrice, sTax,
				oPrice, pMargin);
	}

}
