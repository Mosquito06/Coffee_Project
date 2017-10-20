package kr.or.dgit.Coffee_Project.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.Coffee_Project.Content.CoffeeContent;
import kr.or.dgit.Coffee_Project.common.AbstactListComponent;
import kr.or.dgit.Coffee_Project.common.ProductListComponent;
import kr.or.dgit.Coffee_Project.common.SaleListComponent;
import kr.or.dgit.Coffee_Project.dto.Coffee;
import kr.or.dgit.Coffee_Project.dto.Product;
import kr.or.dgit.Coffee_Project.service.CoffeeService;
import kr.or.dgit.Coffee_Project.service.ProductService;
import kr.or.dgit.Coffee_Project.Content.ProductContent;

public class CoffeeView extends JFrame {

	private JPanel contentPane;
	private CoffeeContent coffeecontent;
	private AbstactListComponent<Product> listProduct;
	private AbstactListComponent<Coffee> listCoffee;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoffeeView frame = new CoffeeView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CoffeeView() {
		setTitle("\uB9E4\uCD9C\uAD00\uB9AC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 10, 10));
		setLocationRelativeTo(null);

		coffeecontent = new CoffeeContent();
		coffeecontent.getPanelPname().setEnable(false);
		coffeecontent.getPanelPcode().getTextField().addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(FocusEvent e) {
								
				try{
					 String pCode = coffeecontent.getPanelPcode().getTextField().getText();
					Product product = ProductService.getInstance().selectItemByno(new Product(pCode, 0));
					coffeecontent.getPanelPname().setTextValue(product.getpName());
				}catch(NullPointerException err){
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
				try {
					coffeecontent.isEmptyCheck();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "�����͸� ��� �Է����ּ���.");
					e1.printStackTrace();
					// return;
				}
				Coffee coffee = coffeecontent.getContent();
				CoffeeService.getInstance().insertItem(coffee);
				listProduct.loadModel();
				listCoffee.loadModel();
				coffeecontent.clear();
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

		ProductContent panel = new ProductContent();
		ProductInput.add(panel);

		JPanel ProductBtnPanel = new JPanel();
		ProductInput.add(ProductBtnPanel);
		ProductBtnPanel.setLayout(new GridLayout(0, 2, 5, 10));

		JButton btnAddProduct = new JButton("\uCD94\uAC00");
		btnAddProduct.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		ProductBtnPanel.add(btnAddProduct);

		JButton btnDeleteProduct = new JButton("\uC0AD\uC81C");
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
		SaleBtnPanel.setLayout(new GridLayout(1, 0, 5, 0));

		JButton btnDeleteSale = new JButton("\uC0AD\uC81C");
		btnDeleteSale.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coffee coffee = listCoffee.getSelectItem();
				CoffeeService.getInstance().deleteItem(coffee);
				listCoffee.loadModel();

			}
		});
		SaleBtnPanel.add(btnDeleteSale);

		JLabel label = new JLabel("\uC2E4\uC801\uAD00\uB9AC");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("����", Font.BOLD, 15));
		SalePanel.add(label, BorderLayout.NORTH);
	}
}
