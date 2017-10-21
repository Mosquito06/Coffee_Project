package kr.or.dgit.Coffee_Project.dto;

import java.text.DecimalFormat;

public class Total {
	private int oTprice;
	private int sTtax;
	private int sTprice;
	private int sTmargin;

	public int getoTprice() {
		return oTprice;
	}

	public void setoTprice(int oTprice) {
		this.oTprice = oTprice;
	}

	public int getsTtax() {
		return sTtax;
	}

	public void setsTtax(int sTtax) {
		this.sTtax = sTtax;
	}

	public int getsTprice() {
		return sTprice;
	}

	public void setsTprice(int sTprice) {
		this.sTprice = sTprice;
	}

	public int getsTmargin() {
		return sTmargin;
	}

	public void setsTmargin(int sTmargin) {
		this.sTmargin = sTmargin;
	}

	public Total(int oTprice, int sTtax, int sTprice, int sTmargin) {
		this.oTprice = oTprice;
		this.sTtax = sTtax;
		this.sTprice = sTprice;
		this.sTmargin = sTmargin;
	}

	@Override
	public String toString() {
		
		return String.format("%s, %s, %s, %s", oTprice, sTtax, sTprice, sTmargin);
	}
	
	public Object[] toArray(){
		DecimalFormat df = new DecimalFormat("#,##0");
		return new Object[]{"гу╟Х", null, null, null, null, df.format(oTprice), df.format(sTtax), df.format(sTprice), null, df.format(sTmargin/100)};
	}
}
