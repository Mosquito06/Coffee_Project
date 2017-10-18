package kr.or.dgit.Coffee_Project.dto;

public class CoffeeAndIncome {
	private int rank;
	private Product pCode;
	private Product pName;
	private int pPrice;
	private int pTotal;
	private int pMargin;
	private int sPrice;
	private int sTax;
	private int oPrice;
	private int sMargin;

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

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

	public int getsMargin() {
		return sMargin;
	}

	public void setsMargin(int sMargin) {
		this.sMargin = sMargin;
	}

	public CoffeeAndIncome(int rank, Product pCode, Product pName, int pPrice, int pTotal, int pMargin, int sPrice,
			int sTax, int oPrice, int sMargin) {
		this.rank = rank;
		this.pCode = pCode;
		this.pName = pName;
		this.pPrice = pPrice;
		this.pTotal = pTotal;
		this.pMargin = pMargin;
		this.sPrice = sPrice;
		this.sTax = sTax;
		this.oPrice = oPrice;
		this.sMargin = sMargin;
	}

	@Override
	public String toString() {
		return String.format(
				"순위 : %s, 제품코드 : %s, 제품명 : %s, 제품단가 : %s, 판매수량 : %s, 마진율 : %s, 판매금액 : %s, 부가세액 : %s, 공급가액 : %s, 마진액 : %s",
				rank, pCode.getpCode(), pName.getpName(), pPrice, pTotal, pMargin, sPrice, sTax, oPrice, sMargin);
	}

	public Object[] toArray() {
		return new Object[]{rank, pCode, pName, pPrice, pTotal, pMargin, sPrice, sTax, oPrice, oPrice};
	}

}
