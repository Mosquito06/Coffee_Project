package kr.or.dgit.Coffee_Project.Content;

import java.awt.GridLayout;

import javax.swing.JPanel;

import kr.or.dgit.Coffee_Project.common.TextFieldComponent;
import kr.or.dgit.Coffee_Project.dto.Coffee;
import kr.or.dgit.Coffee_Project.dto.Product;

public class ProductContent extends JPanel {

	private TextFieldComponent panelPcode;
	private TextFieldComponent panelPname;

	public ProductContent() {
		setLayout(new GridLayout(0, 1, 0, 5));
		
		panelPcode = new TextFieldComponent("力前内靛");
		add(panelPcode);
		
		panelPname = new TextFieldComponent("力前疙");
		add(panelPname);

	}
	
	public Product getContent(){
		Product pCode = new Product(panelPcode.getTextValue(), 0);
		Product pName = new Product(panelPname.getTextValue(), 1);
		return new Product(pCode.getpCode(), pName.getpName());
	}
	
	public void setContent(Coffee coffee){
		panelPcode.setTextValue(coffee.getpCode().getpCode());
		panelPname.setTextValue(coffee.getpName().getpName());
		
	}
	
	public void isEmptyCheck() throws Exception{
		panelPcode.isEmptyCheck();
		panelPname.isEmptyCheck();
	}
	
	public void clear(){
		panelPcode.setTextValue("");
		panelPname.setTextValue("");
	}
	
}
