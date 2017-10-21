package kr.or.dgit.Coffee_Project.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.Coffee_Project.Content.CoffeeContent;
import kr.or.dgit.Coffee_Project.Content.ProductContent;
import kr.or.dgit.Coffee_Project.common.AbstactListComponent;
import kr.or.dgit.Coffee_Project.common.ProductListComponent;
import kr.or.dgit.Coffee_Project.common.SaleListComponent;
import kr.or.dgit.Coffee_Project.dto.Coffee;
import kr.or.dgit.Coffee_Project.dto.Product;
import kr.or.dgit.Coffee_Project.service.CoffeeService;
import kr.or.dgit.Coffee_Project.service.ProductService;

public class CoffeeView extends JFrame {

	private JPanel contentPane;
	private CoffeeContent coffeecontent;
	private AbstactListComponent<Product> listProduct;
	private AbstactListComponent<Coffee> listCoffee;
	private ProductContent productContent;

	public AbstactListComponent<Product> getListProduct() {
		return listProduct;
	}

	public AbstactListComponent<Coffee> getListCoffee() {
		return listCoffee;
	}

	public CoffeeView() {
		setTitle("\uB9E4\uCD9C\uAD00\uB9AC");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1000, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 10, 10));
		
		// ������ â �̹��� ����
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = tk.getImage(System.getProperty("user.dir") + "\\images\\CoffeeIcon.png");
		setIconImage(img);
		
		setLocationRelativeTo(null);

		coffeecontent = new CoffeeContent();
		coffeecontent.getPanelPname().setEnable(false);
		coffeecontent.getPanelPprice().getTextField().addFocusListener(new FocusAdapter() {

			@Override
			public void focusGained(FocusEvent e) {
				try {
					coffeecontent.getPanelPcode().isEmptyCheck();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "��ǰ�ڵ带 ���� �Է��ϼ���");
					coffeecontent.getPanelPcode().getTextField().requestFocus();
					return;
				}
				String pCode = coffeecontent.getPanelPcode().getTextField().getText();
				Product product = ProductService.getInstance().selectItemByno(new Product(pCode, 0));

				try {
					coffeecontent.getPanelPname().setTextValue(product.getpName());
				} catch (NullPointerException err) {
					coffeecontent.getPanelPcode().getTextField().requestFocus();
					JOptionPane.showMessageDialog(null, "��ϵ��� ���� ��ǰ�Դϴ�.");
				}
			}

		});

		JPanel InputPanel = new JPanel();
		contentPane.add(InputPanel);
		InputPanel.setLayout(new BorderLayout(0, 5));
		InputPanel.add(coffeecontent, BorderLayout.CENTER);

		JPanel InputBtnPanel = new JPanel();
		InputPanel.add(InputBtnPanel, BorderLayout.SOUTH);
		InputBtnPanel.setLayout(new GridLayout(0, 3, 5, 0));

		JButton btnAdd = new JButton("\uC785\uB825");
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("�Է�")) {
					try {
						coffeecontent.isEmptyCheck();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "�����͸� ��� �Է����ּ���.");
						return;
					}
					Coffee coffee = coffeecontent.getContent();
					CoffeeService.getInstance().insertItem(coffee);
					listProduct.loadModel();
					listCoffee.loadModel();
					coffeecontent.clear();
				}
				if (e.getActionCommand().equals("����")) {
					try {
						coffeecontent.isEmptyCheck();
					} catch (Exception e3) {
						JOptionPane.showMessageDialog(null, "�����͸� ��� �Է����ּ���.");
						return;
					}
					Coffee coffee = coffeecontent.getContent();
					CoffeeService.getInstance().updateItem(coffee);
					listProduct.loadModel();
					listCoffee.loadModel();
					coffeecontent.clear();
					btnAdd.setText("�Է�");
				}

			}
		});
		InputBtnPanel.add(btnAdd);

		JButton btnOutSmargin = new JButton("\uB9C8\uC9C4\uC561");
		btnOutSmargin.addActionListener(new ActionListener() {

			private AbstractListView frame;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (frame == null) {
					frame = new SmarginView("������ ����");
					frame.loadData();
					frame.setVisible(true);
				} else {
					frame.loadData();
					frame.setVisible(true);
				}

			}
		});
		InputBtnPanel.add(btnOutSmargin);

		JButton btnOutSprice = new JButton("\uD310\uB9E4\uAE08\uC561");
		btnOutSprice.addActionListener(new ActionListener() {

			private AbstractListView frame;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (frame == null) {
					frame = new SpriceView("�Ǹ� �ݾ� ����");
					frame.loadData();
					frame.setVisible(true);
				} else {
					frame.loadData();
					frame.setVisible(true);
				}
			}
		});
		InputBtnPanel.add(btnOutSprice);

		JLabel lblInput = new JLabel("\uD310\uB9E4\uC2E4\uC801 \uC785\uB825");
		lblInput.setFont(new Font("����", Font.BOLD, 15));
		lblInput.setHorizontalAlignment(SwingConstants.CENTER);
		InputPanel.add(lblInput, BorderLayout.NORTH);

		JPanel ProductPanel = new JPanel();
		contentPane.add(ProductPanel);
		ProductPanel.setLayout(new BorderLayout(0, 5));

		listProduct = new ProductListComponent();
		ProductPanel.add(listProduct, BorderLayout.CENTER);

		JPanel ProductInput = new JPanel();
		ProductPanel.add(ProductInput, BorderLayout.SOUTH);
		ProductInput.setLayout(new GridLayout(0, 1, 5, 5));

		productContent = new ProductContent();
		ProductInput.add(productContent);

		JPanel ProductBtnPanel = new JPanel();
		ProductInput.add(ProductBtnPanel);
		ProductBtnPanel.setLayout(new GridLayout(0, 2, 5, 10));

		JButton btnAddProduct = new JButton("\uCD94\uAC00");
		btnAddProduct.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					productContent.isEmptyCheck();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "�����͸� ��� �Է����ּ���.");
					return;
				}
				Product product = productContent.getContent();
				ProductService.getInstance().insertItem(product);
				listProduct.loadModel();
				listCoffee.loadModel();
				productContent.clear();
			}
		});
		ProductBtnPanel.add(btnAddProduct);

		JButton btnDeleteProduct = new JButton("\uC0AD\uC81C");
		btnDeleteProduct.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Product product = listProduct.getListValue();
				try {
					ProductService.getInstance().deleteItem(product);
				} catch (NullPointerException err) {
					JOptionPane.showMessageDialog(null, "������ ��ǰ�� �����ϼ���");
					return;
				}
				listProduct.loadModel();
				listCoffee.loadModel();
			}
		});

		ProductBtnPanel.add(btnDeleteProduct);

		JLabel lblProduct = new JLabel("\uC81C\uD488\uAD00\uB9AC");
		lblProduct.setFont(new Font("����", Font.BOLD, 15));
		lblProduct.setHorizontalAlignment(SwingConstants.CENTER);
		ProductPanel.add(lblProduct, BorderLayout.NORTH);

		JPanel SalePanel = new JPanel();
		contentPane.add(SalePanel);
		SalePanel.setLayout(new BorderLayout(0, 5));

		listCoffee = new SaleListComponent();
		SalePanel.add(listCoffee, BorderLayout.CENTER);

		JPanel SaleBtnPanel = new JPanel();
		SalePanel.add(SaleBtnPanel, BorderLayout.SOUTH);
		SaleBtnPanel.setLayout(new GridLayout(0, 2, 5, 0));

		JButton btnDeleteSale = new JButton("\uC0AD\uC81C");
		btnDeleteSale.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coffee coffee = listCoffee.getListValue();
				try {
					CoffeeService.getInstance().deleteItem(coffee);
				} catch (NullPointerException err) {
					JOptionPane.showMessageDialog(null, "�����ϰų� ������ ������ �����ϼ���");
					return;
				}
				listCoffee.loadModel();
				listProduct.loadModel();

			}
		});

		JButton btnUpdateSale = new JButton("\uC218\uC815");
		btnUpdateSale.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coffee coffee = listCoffee.getListValue();
				try {
					coffeecontent.setContent(coffee);
				} catch (NullPointerException err) {
					JOptionPane.showMessageDialog(null, "�����ϰų� ������ ������ �����ϼ���");
					return;
				}
				btnAdd.setText("����");

			}
		});

		SaleBtnPanel.add(btnUpdateSale);

		SaleBtnPanel.add(btnDeleteSale);

		JLabel label = new JLabel("\uC2E4\uC801\uAD00\uB9AC");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("����", Font.BOLD, 15));
		SalePanel.add(label, BorderLayout.NORTH);
	}
}
