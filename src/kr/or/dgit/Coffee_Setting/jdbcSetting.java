package kr.or.dgit.Coffee_Setting;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class jdbcSetting extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jdbcSetting frame = new jdbcSetting();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public jdbcSetting() {
		setTitle("\uB370\uC774\uD130\uBCA0\uC774\uC2A4 \uC138\uD305");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 442, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnInit = new JButton(new BtnAction("초기화"));
		btnInit.setBounds(226, 40, 178, 48);
		panel.add(btnInit);
		
		JButton btnExport = new JButton(new BtnAction("백업"));
		btnExport.setBounds(226, 169, 178, 45);
		panel.add(btnExport);
		
		JButton btnImport = new JButton(new BtnAction("복원"));
		btnImport.setBounds(226, 103, 178, 45);
		panel.add(btnImport);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\images\\DBBack copy.jpg"));
		lblNewLabel.setBounds(0, 0, 416, 251);
		panel.add(lblNewLabel);
	}

}
