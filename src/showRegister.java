import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class showRegister extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField account;
	private JTextField password;
	private JTextField passwordcheck;
	private JComboBox<String> ID;
	private JPanel panel_1;
	private String hint1,hint2,hint3,hint4;
	private User u;
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					showRegister frame = new showRegister();
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
	public showRegister(User u) {
		this.u = u;
		setTitle("\u8A3B\u518A");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 960, 537);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 140, 946, 360);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton register = new JButton("");
		register.setIcon(new ImageIcon(".\\Image\\signup_0.png"));
		register.setBounds(382, 224, 121, 116);
		panel.add(register);
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registeract(e);
			}
		});
		register.setContentAreaFilled(false);
		register.setBorderPainted(false);
		register.setBackground(Color.GRAY);
		register.setFont(new Font("新細明體", Font.PLAIN, 20));
		
		passwordcheck = new JTextField();
		passwordcheck.setFont(new Font("新細明體", Font.PLAIN, 30));
		passwordcheck.setBounds(546, 199, 266, 44);
		this.hint1 = "    -Double Check -";
		passwordcheck.setText(hint1);
		passwordcheck.setForeground(Color.gray);
		passwordcheck.addFocusListener(new FocusAdapter() {
			
            public void focusGained(FocusEvent arg0)
            {   
				String temp = passwordcheck.getText();
                if(temp.equals(hint1)) {
                	passwordcheck.setText("");
                	passwordcheck.setForeground(new Color(0, 0, 0));
                }
            }
            @Override
            public void focusLost(FocusEvent arg0)
            {
            	String temp = passwordcheck.getText();
                if(temp.equals("")) {
                	passwordcheck.setText(hint1);
                	passwordcheck.setForeground(Color.gray);
                }
            }
		});
		panel.add(passwordcheck);
		passwordcheck.setColumns(10);
		
		password = new JTextField();
		password.setFont(new Font("新細明體", Font.PLAIN, 30));
		password.setBounds(546, 145, 266, 44);
		this.hint2 = "    -P a s s w o r d -";
		password.setText(hint2);
		password.setForeground(Color.gray);
		password.addFocusListener(new FocusAdapter() {
			
            public void focusGained(FocusEvent arg0)
            {   
				String temp = password.getText();
                if(temp.equals(hint2)) {
                	password.setText("");
                	password.setForeground(new Color(0, 0, 0));
                }
            }
            @Override
            public void focusLost(FocusEvent arg0)
            {
            	String temp = password.getText();
                if(temp.equals("")) {
                	password.setText(hint2);
                	password.setForeground(Color.gray);
                }
            }
		});
		panel.add(password);
		password.setColumns(10);
		
		account = new JTextField();
		account.setFont(new Font("新細明體", Font.PLAIN, 30));
		account.setBounds(546, 91, 266, 44);
		this.hint3 = "     -A c c o u n t -";
		account.setText(hint3);
		account.setForeground(Color.gray);
		account.addFocusListener(new FocusAdapter() {
			
            public void focusGained(FocusEvent arg0)
            {   
				String temp = account.getText();
                if(temp.equals(hint3)) {
                	account.setText("");
                	account.setForeground(new Color(0, 0, 0));
                }
            }
            @Override
            public void focusLost(FocusEvent arg0)
            {
            	String temp = account.getText();
                if(temp.equals("")) {
                	account.setText(hint3);
                	account.setForeground(Color.gray);
                }
            }
		});
		panel.add(account);
		account.setColumns(10);
		
		ID = new JComboBox<String>();
		ID.setBackground(Color.WHITE);
		ID.setBounds(691, 37, 121, 44);
		panel.add(ID);
		ID.setFont(new Font("新細明體", Font.PLAIN, 18));
		ID.addItem("--請選擇--");
		ID.addItem("學 生");
		ID.addItem("老 師");
		ID.addItem("職 員");
		
		name = new JTextField();
		name.setFont(new Font("新細明體", Font.PLAIN, 30));
		name.setBackground(Color.WHITE);
		name.setBounds(548, 37, 133, 44);
		this.hint4 = " -N a m e-";
		name.setText(hint4);
		name.setForeground(Color.gray);
		name.addFocusListener(new FocusAdapter() {
			
            public void focusGained(FocusEvent arg0)
            {   
				String temp = name.getText();
                if(temp.equals(hint4)) {
                	name.setText("");
                	name.setForeground(new Color(0, 0, 0));
                }
            }
            @Override
            public void focusLost(FocusEvent arg0)
            {
            	String temp = name.getText();
                if(temp.equals("")) {
                	name.setText(hint4);
                	name.setForeground(Color.gray);
                }
            }
		});
		panel.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(".\\Image\\signupicon.png"));
		lblNewLabel.setBounds(22, 37, 389, 188);
		panel.add(lblNewLabel);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 191, 255));
		panel_1.setBounds(0, 0, 946, 139);
		panel_1.setLayout(null);
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(".\\Image\\home.png"));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBackground(new Color(0, 191, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);			
			}
		});
		btnNewButton.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		btnNewButton.setBounds(20, 23, 113, 89);
		panel_1.add(btnNewButton);
		contentPane.add(panel_1);

	}
	protected void registeract(ActionEvent ae) {
		String name = this.name.getText();
		String account = this.account.getText();
		String password = this.password.getText();
		String passwordcheck = this.passwordcheck.getText();
		if(name.equals(hint4)) {name ="";}
		if(account.equals(hint3)) {account ="";}
		if(password.equals(hint2)) {password ="";}
		if(passwordcheck.equals(hint1)) {passwordcheck ="";}
		boolean c;
		String ID = (String) this.ID.getSelectedItem();
		if(!name.isEmpty() && !account.isEmpty() && !password.isEmpty() && password.equals(passwordcheck) && !ID.isEmpty()) {
			c = u.Register(name, account, password, ID);
			if(c) {
				JOptionPane.showMessageDialog(null,"註冊成功，請登入。","提示訊息",JOptionPane.INFORMATION_MESSAGE);
				setVisible(false);
			}
			else {				
            	JOptionPane.showMessageDialog(null,"帳號名稱與他人重複，請重新輸入。","提示訊息",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else if(!(password.equals(passwordcheck)))
		{  			           
			JOptionPane.showMessageDialog(null,"密碼不相符","提示訊息",JOptionPane.WARNING_MESSAGE);
		}
		else 
		{  			           
			JOptionPane.showMessageDialog(null,"尚有未輸入的內容","提示訊息",JOptionPane.WARNING_MESSAGE);
		}
	}
}
