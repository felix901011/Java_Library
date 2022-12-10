import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.util.ArrayList;
import javax.swing.ImageIcon;
public class LOG extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private User u = new User(null,null,null,null,0,0);

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LOG frame = new LOG();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LOG() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1067, 589);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setVisible(true);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1053, 139);
		panel.setBackground(new Color(204, 102, 204));
		panel.setForeground(Color.PINK);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(".\\Image\\home.png"));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBackground(new Color(204, 102, 204));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton.setFont(new Font("·L³n¥¿¶ÂÅé", Font.BOLD, 20));
		btnNewButton.setBounds(21, 29, 102, 89);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Library");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 50));
		lblNewLabel.setBounds(429, 10, 183, 129);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 142, 1053, 410);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(".\\Image\\log in.png"));
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showLoginview(e);
			}
		});
		btnNewButton_1.setBounds(94, 86, 261, 260);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(".\\Image\\sign up.png"));
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showRegisterview(e);
			}
		});
		btnNewButton_2.setBounds(391, 86, 261, 260);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showSearch(e);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(".\\Image\\search.png"));
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setBounds(687, 86, 261, 260);
		panel_1.add(btnNewButton_3);
		
	}
	protected void showRegisterview(ActionEvent ae) {
		showRegister r = new showRegister(u);
	}
	protected void showLoginview(ActionEvent ae) {
		showlogin g = new showlogin(u);
		this.setVisible(false);
	}
	public void showSearch(ActionEvent e) {
		Search s = new Search(this.u.getallBook(),u);
	}
}


