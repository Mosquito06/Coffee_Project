package kr.or.dgit.Coffee_Project.Content;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import kr.or.dgit.Coffee_Project.common.TextFieldComponent;
import kr.or.dgit.Coffee_Project.dto.Coffee;
import kr.or.dgit.Coffee_Project.dto.Product;

public class CoffeeContent extends JPanel {

	private TextFieldComponent panelPcode;
	private TextFieldComponent panelPname;
	private TextFieldComponent panelPprice;
	private TextFieldComponent panelPtotal;
	private TextFieldComponent panelPmargin;

	public TextFieldComponent getPanelPcode() {
		return panelPcode;
	}

	public TextFieldComponent getPanelPname() {
		return panelPname;
	}

	public CoffeeContent() {
		setLayout(new GridLayout(0, 1, 0, 10));

		panelPcode = new TextFieldComponent("제품코드");
		add(panelPcode);

		panelPname = new TextFieldComponent("제품명");
		add(panelPname);

		panelPprice = new TextFieldComponent("제품단가");
		add(panelPprice);

		panelPtotal = new TextFieldComponent("판매수량");
		add(panelPtotal);

		panelPmargin = new TextFieldComponent("마진율");
		add(panelPmargin);

	}

	public Coffee getContent() {
		Product pCode = new Product(panelPcode.getTextValue(), 0);
		Product pName = new Product(panelPname.getTextValue(), 1);
		int pPrice = Integer.parseInt(panelPprice.getTextValue());
		int pTotal = Integer.parseInt(panelPtotal.getTextValue());
		int pMargin = Integer.parseInt(panelPmargin.getTextValue());
		return new Coffee(pCode, pName, pPrice, pTotal, pMargin);
	}

	public void setContent(Coffee coffee) {
		panelPcode.setTextValue(coffee.getpCode().getpCode());
		panelPname.setTextValue(coffee.getpName().getpName());
		panelPprice.setTextValue(String.valueOf(coffee.getpPrice()));
		panelPtotal.setTextValue(String.valueOf(coffee.getpTotal()));
		panelPmargin.setTextValue(String.valueOf(coffee.getpMargin()));

	}

	public void isEmptyCheck() throws Exception {
		panelPcode.isEmptyCheck();
		panelPname.isEmptyCheck();
		panelPprice.isEmptyCheck();
		panelPtotal.isEmptyCheck();
		panelPmargin.isEmptyCheck();
	}

	public void clear() {
		panelPcode.setTextValue("");
		panelPname.setTextValue("");
		panelPprice.setTextValue("");
		panelPtotal.setTextValue("");
		panelPmargin.setTextValue("");
	}

}
