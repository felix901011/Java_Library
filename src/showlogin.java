import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.ImageIcon;
public class showlogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField accountField;
	private JTextField passwordField;
	private String hint1,hint2;
	private User u ;
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					showlogin frame = new showlogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 */
	public showlogin(User u) {
		this.u = u;
		setTitle("\u4F7F\u7528\u8005\u767B\u5165");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 537);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.hint1 = "      - A c c o u n t -";
		this.hint2 = "      - P a s s w o r d -";
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 128, 114));
		panel.setBounds(0, 0, 946, 139);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				LOG l = new LOG();
			}
		});
		btnNewButton_1.setBackground(new Color(250, 128, 114));
		btnNewButton_1.setIcon(new ImageIcon(".\\Image\\home.png"));
		btnNewButton_1.setBounds(24, 10, 106, 102);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 138, 946, 362);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		accountField = new JTextField();
		accountField.setBounds(569, 71, 292, 40);
		panel_1.add(accountField);
		accountField.setForeground(new Color(0, 0, 0));
		accountField.setFont(new Font("新細明體", Font.PLAIN, 30));
		accountField.setText(hint1);
		accountField.setForeground(Color.gray);
		accountField.addFocusListener(new FocusAdapter() {
			
            public void focusGained(FocusEvent arg0)
            {   
				String temp = accountField.getText();
                if(temp.equals(hint1)) {
                	accountField.setText("");
                	accountField.setForeground(new Color(0, 0, 0));
                }
            }
            @Override
            public void focusLost(FocusEvent arg0)
            {
            	String temp = accountField.getText();
                if(temp.equals("")) {
                	accountField.setText(hint1);
                	accountField.setForeground(Color.gray);
                }
            }
		});
		accountField.setColumns(10);
		
		passwordField = new JTextField();
		passwordField.setBounds(569, 139, 292, 40);
		panel_1.add(passwordField);
		passwordField.setFont(new Font("新細明體", Font.PLAIN, 30));
		passwordField.setText(hint2);
		passwordField.setForeground(Color.gray);
		passwordField.addFocusListener(new FocusAdapter() {
			
            public void focusGained(FocusEvent arg0)
            {   
				String temp = passwordField.getText();
                if(temp.equals(hint2)) {
                	passwordField.setText("");
                	passwordField.setForeground(new Color(0, 0, 0));
                }
            }
            @Override
            public void focusLost(FocusEvent arg0)
            {
            	String temp = passwordField.getText();
                if(temp.equals("")) {
                	passwordField.setText(hint2);
                	passwordField.setForeground(Color.gray);
                }
            }
		});
		passwordField.setColumns(10);
		
		JButton btnNewButton = new JButton(""); 
		btnNewButton.setBounds(396, 223, 136, 139);
		panel_1.add(btnNewButton);
		btnNewButton.setIcon(new ImageIcon(".\\Image\\login_0.png"));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginact(e);
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 17));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(".\\Image\\loginicon.png"));
		lblNewLabel.setBounds(48, 27, 439, 208);
		panel_1.add(lblNewLabel);
	}
	protected void loginact(ActionEvent e) {
		String account = accountField.getText();
		String password = passwordField.getText();
		if(!account.isEmpty() && !password.isEmpty()) {							
			boolean result = u.Login(accountField.getText().trim(), passwordField.getText().trim());
			if(result){          
				//登入成功 
				JOptionPane.showMessageDialog(null, "登入成功!", "提示", JOptionPane.INFORMATION_MESSAGE);
				this.setVisible(false);
				if(u.getUser().getID().equals("管理員")) {
					Adiminview a = new Adiminview(u.getUser());
				}else {
					Memberview n = new Memberview(u.getUser());
				}
			}else{          
				//登入失敗
				JOptionPane.showMessageDialog(null, "登入名或密碼錯誤，請重新登入!", "提示", JOptionPane.ERROR_MESSAGE); 				
			}
		
		}else if(accountField.getText().isEmpty())
		{   

			JOptionPane.showMessageDialog(null,"請輸入帳號","提示訊息",JOptionPane.WARNING_MESSAGE);
		}else if(passwordField.getText().isEmpty())	
		{   
			JOptionPane.showMessageDialog(null,"請輸入密碼","提示訊息",JOptionPane.WARNING_MESSAGE);
		}
	}
}
