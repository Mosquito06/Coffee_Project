package kr.or.dgit.Coffee_Project.common;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TextFieldComponent extends JPanel {
	private JTextField textField;

	public JTextField getTextField() {
		return textField;
	}

	public TextFieldComponent(String title) {
		setLayout(new GridLayout(1, 0, 0, 0));

		JLabel lblLabel = new JLabel(title);
		lblLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblLabel);

		textField = new JTextField();
		add(textField);
		textField.setColumns(10);

	}

	public String getTextValue() {
		return textField.getText();
	}

	public void setTextValue(String value) {
		textField.setText(value);
	}

	public void setEnable(boolean isEnable) {
		textField.setEditable(isEnable);
	}

	public void isEmptyCheck() throws Exception {
		if (getTextValue().equals("")) {
			textField.requestFocus();
			throw new Exception("공백이 존재합니다.");
		}
	}

}
