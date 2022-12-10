import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Adiminview extends JFrame {

	private JPanel contentPane;
	private Admin u;
	/*

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adiminview frame = new Adiminview();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Adiminview(User u) {
		this.u = new Admin(u.getName(), u.Account, u.Password, u.ID,u.getAccumufines(),u.getNum());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1067, 589);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 255, 204));
		panel.setBounds(0, 0, 1053, 139);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 137, 1053, 405);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Administrator");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 50));
		lblNewLabel.setBounds(359, 10, 346, 129);
		panel.add(lblNewLabel);
		
		JButton home = new JButton("");
		home.setIcon(new ImageIcon(".\\Image\\home.png"));
		home.setForeground(Color.RED);
		home.setBackground(new Color(204, 102, 204));
		home.setContentAreaFilled(false);
		home.setBorderPainted(false);
		home.setHorizontalAlignment(SwingConstants.LEADING);
		home.setFont(new Font("·L³n¥¿¶ÂÅé", Font.BOLD, 20));
		home.setBounds(21, 29, 102, 89);
		panel.add(home);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showAddBook(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(".\\Image\\add.png"));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBounds(155, 64, 263, 259);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showManagerview(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(".\\Image\\manager.png"));
		btnNewButton_1.setBounds(577, 64, 263, 259);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		panel_1.add(btnNewButton_1);
		
	}
	public void showAddBook(ActionEvent e) {
		AddBook a = new AddBook(u);
	}
	public void showManagerview(ActionEvent e) {
		Manegerview m = new Manegerview(u.getallBook(), u);
	}
}
