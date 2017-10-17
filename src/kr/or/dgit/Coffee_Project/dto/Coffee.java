package kr.or.dgit.Coffee_Project.dto;

public class Coffee {
	private Product pCode;
	private Product pName;
	private int pPrice;
	private int pTotal;
	private int pMargin;

	public Product getpCode() {
		return pCode;
	}

	public void setpCode(Product pCode) {
		this.pCode = pCode;
	}

	public Product getpName() {
		return pName;
	}

	public void setpName(Product pName) {
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

	public Coffee(Product pCode, Product pName, int pPrice, int pTotal, int pMargin) {
		this.pCode = pCode;
		this.pName = pName;
		this.pPrice = pPrice;
		this.pTotal = pTotal;
		this.pMargin = pMargin;
	}

	@Override
	public String toString() {
		return String.format("제품코드 : %s, 제품명 : %s, 제품단가 : %s,  판매수량 : %s, 마진율 : %s", pCode.getpCode(), pName.getpName(), pPrice,
				pTotal, pMargin);
	}

}
