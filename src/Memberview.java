import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Memberview extends JFrame {
	private Member u;
	private JPanel contentPane;

	public Memberview(User u) {
		//多形
		if(u.getID() == "學 生") {
			this.u = new Student(u.getName(),u.getAcc(),u.getPassword(),u.getID(),u.getAccumufines(),u.getNum());
		}
		else if(u.getID() == "教 師"){
			this.u = new Teacher(u.getName(),u.getAcc(),u.getPassword(),u.getID(),u.getAccumufines(),u.getNum());
		}
		else {
			this.u = new Staff(u.getName(),u.getAcc(),u.getPassword(),u.getID(),u.getAccumufines(),u.getNum());
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1067, 589);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 250, 154));
		panel.setBounds(0, 0, 1053, 139);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setBackground(new Color(0, 250, 154));
		btnNewButton_3.setIcon(new ImageIcon(".\\Image\\home.png"));
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setBounds(22, 28, 94, 89);
		panel.add(btnNewButton_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 139, 1053, 426);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showBorrowview(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(".\\Image\\borrow.png"));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBounds(94, 86, 265, 259);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showMore(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(".\\Image\\more.png"));
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBounds(689, 86, 258, 259);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showSearch(e);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(".\\Image\\search.png"));
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setBounds(391, 86, 258, 259);
		panel_1.add(btnNewButton_2);
						
	}
	public void showSearch(ActionEvent e) {
		Search c = new Search(this.u.getallBook(),u);
	}
	public void showMore(ActionEvent e) {
		More m = new More(this.u.getallBook(),u);
	}
	public void showBorrowview(ActionEvent e) {
		borrowview b = new borrowview(this.u.getallBook(),u);
	}
}

