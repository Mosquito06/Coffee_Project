package kr.or.dgit.Coffee_Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.Coffee_Project.view.CoffeeView;
import kr.or.dgit.Coffee_Setting.jdbcSetting;


public class CoffeeProjectMain extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoffeeProjectMain frame = new CoffeeProjectMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CoffeeProjectMain() {

		setTitle("\uBAA8\uAD6C\uC18C\uD504\uD2B8");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);

		JPanel BtnPanel = new JPanel();
		contentPane.add(BtnPanel, BorderLayout.CENTER);
		BtnPanel.setLayout(null);

		JPanel BtnTopPanel = new JPanel();
		BtnTopPanel.setBounds(156, 115, 209, 59);
		BtnPanel.add(BtnTopPanel);
		BtnTopPanel.setLayout(new GridLayout(0, 1, 0, 0));

		JButton btnStart = new JButton("\uC2DC\uC791\uD558\uAE30");
		btnStart.setFont(new Font("±¼¸²", Font.BOLD, 15));
		btnStart.addActionListener(new ActionListener() {

			private CoffeeView frame;

			@Override
			public void actionPerformed(ActionEvent e) {
					if (frame == null) {
						frame = new CoffeeView();
						frame.getListCoffee().loadModel();
						frame.getListProduct().loadModel();
						frame.setVisible(true);
					} else {
						frame.getListCoffee().loadModel();
						frame.getListProduct().loadModel();
						frame.setVisible(true);
					}
			}
		});
		BtnTopPanel.add(btnStart);

		JPanel BtnBottomPanel = new JPanel();
		BtnBottomPanel.setBounds(185, 196, 155, 38);
		BtnPanel.add(BtnBottomPanel);
		BtnBottomPanel.setLayout(new GridLayout(0, 1, 0, 0));

		JButton BtnData = new JButton("DB \uC124\uCE58\uD558\uAE30");
		BtnData.addActionListener(new ActionListener() {

			private jdbcSetting frame;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (frame == null) {
					frame = new jdbcSetting();
					frame.setVisible(true);
				} else {
					frame.setVisible(true);
				}

			}
		});
		BtnBottomPanel.add(BtnData);

		JLabel ImgLabel = new JLabel("New label");
		ImgLabel.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\images\\CoffeeBack.jpg"));
		ImgLabel.setBounds(0, 0, 524, 371);
		BtnPanel.add(ImgLabel);

	}
}
