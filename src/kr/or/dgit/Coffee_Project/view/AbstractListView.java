package kr.or.dgit.Coffee_Project.view;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.Coffee_Project.list.AbstractList;
import kr.or.dgit.Coffee_Project.list.SpriceList;
import kr.or.dgit.Coffee_Project.service.CoffeeAndIncomeService;

public abstract class AbstractListView extends JFrame {

	private JPanel contentPane;
	private AbstractList abstractlist;
	
	public AbstractListView(String title) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 725, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		// 윈도우 창 이미지 변경
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = tk.getImage(System.getProperty("user.dir") + "\\images\\CoffeeIcon.png");
		setIconImage(img);
		
		setLocationRelativeTo(null);
		
		abstractlist = CreatList();
		contentPane.add(abstractlist, BorderLayout.CENTER);
	}

	protected abstract AbstractList CreatList();
	
	public void loadData(){
		abstractlist.loadData();
	}

}
