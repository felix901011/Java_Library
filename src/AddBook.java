import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class AddBook extends JFrame {

	private JPanel contentPane;
	private JTextField Name;
	private JTextField Writer;
	private JTextField Publish;
	private JTextField State;
	private JTextField Sort;
	private Admin u ;
	private String h1,h2,h3,h4,h5;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBook frame = new AddBook();
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
	public AddBook(Admin u) {
		this.u = u;
		setTitle("\u65B0\u589E\u4E00\u672C\u66F8");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 720, 480);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 706, 443);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Name = new JTextField();
		Name.setFont(new Font("新細明體", Font.PLAIN, 30));
		Name.setBounds(196, 59, 266, 44);
		this.h1 = "         - N a m e -";
		Name.setText(h1);
		Name.setForeground(Color.gray);
		Name.addFocusListener(new FocusAdapter() {
			
            public void focusGained(FocusEvent arg0)
            {   
				String temp = Name.getText();
                if(temp.equals(h1)) {
                	Name.setText("");
                	Name.setForeground(new Color(0, 0, 0));
                }
            }
            @Override
            public void focusLost(FocusEvent arg0)
            {
            	String temp = Name.getText();
                if(temp.equals("")) {
                	Name.setText(h1);
                	Name.setForeground(Color.gray);
                }
            }
		});
		panel.add(Name);
		Name.setColumns(10);
		
		Writer = new JTextField();
		Writer.setFont(new Font("新細明體", Font.PLAIN, 30));
		Writer.setBounds(196, 201, 266, 44);
		this.h2 = "       - W r i t e r -";
		Writer.setText(h2);
		Writer.setForeground(Color.gray);
		Writer.addFocusListener(new FocusAdapter() {
			
            public void focusGained(FocusEvent arg0)
            {   
				String temp = Writer.getText();
                if(temp.equals(h2)) {
                	Writer.setText("");
                	Writer.setForeground(new Color(0, 0, 0));
                }
            }
            @Override
            public void focusLost(FocusEvent arg0)
            {
            	String temp = Writer.getText();
                if(temp.equals("")) {
                	Writer.setText(h2);
                	Writer.setForeground(Color.gray);
                }
            }
		});
		panel.add(Writer);
		Writer.setColumns(10);
		
		Publish = new JTextField();
		Publish.setFont(new Font("新細明體", Font.PLAIN, 30));
		Publish.setBounds(196, 133, 266, 44);
		this.h3 = "      - P u b l i s h -";
		Publish.setText(h3);
		Publish.setForeground(Color.gray);
		Publish.addFocusListener(new FocusAdapter() {
			
            public void focusGained(FocusEvent arg0)
            {   
				String temp = Publish.getText();
                if(temp.equals(h3)) {
                	Publish.setText("");
                	Publish.setForeground(new Color(0, 0, 0));
                }
            }
            @Override
            public void focusLost(FocusEvent arg0)
            {
            	String temp = Publish.getText();
                if(temp.equals("")) {
                	Publish.setText(h3);
                	Publish.setForeground(Color.gray);
                }
            }
		});
		panel.add(Publish);
		Publish.setColumns(10);
		
		State = new JTextField();
		State.setFont(new Font("新細明體", Font.PLAIN, 30));
		State.setBounds(431, 271, 170, 44);
		this.h4 = "   - S t a t e -";
		State.setText(h4);
		State.setForeground(Color.gray);
		State.addFocusListener(new FocusAdapter() {
			
            public void focusGained(FocusEvent arg0)
            {   
				String temp = State.getText();
                if(temp.equals(h4)) {
                	State.setText("");
                	State.setForeground(new Color(0, 0, 0));
                }
            }
            @Override
            public void focusLost(FocusEvent arg0)
            {
            	String temp = State.getText();
                if(temp.equals("")) {
                	State.setText(h4);
                	State.setForeground(Color.gray);
                }
            }
		});
		panel.add(State);
		State.setColumns(10);
		
		Sort = new JTextField();
		Sort.setFont(new Font("新細明體", Font.PLAIN, 30));
		Sort.setBounds(196, 271, 170, 44);
		this.h5 = "    - S o r t -";
		Sort.setText(h5);
		Sort.setForeground(Color.gray);
		Sort.addFocusListener(new FocusAdapter() {
			
            public void focusGained(FocusEvent arg0)
            {   
				String temp = Sort.getText();
                if(temp.equals(h5)) {
                	Sort.setText("");
                	Sort.setForeground(new Color(0, 0, 0));
                }
            }
            @Override
            public void focusLost(FocusEvent arg0)
            {
            	String temp = Sort.getText();
                if(temp.equals("")) {
                	Sort.setText(h5);
                	Sort.setForeground(Color.gray);
                }
            }
		});
		panel.add(Sort);
		Sort.setColumns(10);
		
		btnNewButton = new JButton("\u65B0\u589E");
		btnNewButton.setFont(new Font("新宋体", Font.PLAIN, 20));
		btnNewButton.setBackground(new Color(204, 204, 153));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Addbookact(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(".\\Image\\8209093_user_interface_add_plus_ui_icon.png"));
		btnNewButton.setBounds(280, 349, 157, 67);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		panel.add(btnNewButton);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(".\\Image\\103511_text_add_document_icon.png"));
		lblNewLabel.setBounds(21, 10, 128, 137);
		panel.add(lblNewLabel);
	}
	public void Addbookact(ActionEvent e) {
		String a = Name.getText(), b = Writer.getText(), c = Publish.getText(), i = Sort.getText();
		if(a.equals(h1)) {a ="";}
		if(b.equals(h2)) {b ="";}
		if(c.equals(h3)) {c ="";}
		if(i.equals(h5)) {i ="";}

		if(!a.isEmpty() && !b.isEmpty() && !c.isEmpty() && !i.isEmpty()){
			 u.AddBook(a,b,c,true,i);
			 JOptionPane.showMessageDialog(null, "新增成功!", "提示", JOptionPane.INFORMATION_MESSAGE);
			 u.setallBook();
			 setVisible(false);
		}else if(Name.getText().isEmpty())
		{          
			JOptionPane.showMessageDialog(null,"請輸入書名","提示訊息",JOptionPane.WARNING_MESSAGE);
		}else if(Writer.getText().isEmpty())	
		{         
			JOptionPane.showMessageDialog(null,"請輸入作者","提示訊息",JOptionPane.WARNING_MESSAGE);
		}
		else if(Publish.getText().isEmpty())
		{          
			JOptionPane.showMessageDialog(null,"請輸入出版社","提示訊息",JOptionPane.WARNING_MESSAGE);
		}else if(Sort.getText().isEmpty())	
		{         
			JOptionPane.showMessageDialog(null,"請輸入分類","提示訊息",JOptionPane.WARNING_MESSAGE);
		}

	}

}
