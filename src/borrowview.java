import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class borrowview extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField time;
	private DefaultTableModel model;
	private Timer timer;
	private Member u;
	private JButton btnNewButton_2 ;
	private ArrayList<Book> b;

	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					borrowview frame = new borrowview();
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
	public borrowview(ArrayList<Book> b, Member u) {
		this.u = u;
		this.b = b;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 960, 537);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 165, 0));
		panel.setBounds(0, 0, 946, 139);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel title = new JLabel("Library");
		title.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 50));
		title.setBounds(371, 10, 183, 129);
		panel.add(title);
		
		time = new JTextField();
		time.setFont(new Font("新細明體", Font.PLAIN, 20));
		time.setBackground(new Color(255, 153, 0));
		time.setBounds(716, 94, 172, 35);
		timer=new Timer(500,this);
		timer.start();
		panel.add(time);
		time.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setBackground(new Color(255, 165, 0));
		btnNewButton_1.setIcon(new ImageIcon(".\\Image\\home.png"));
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBounds(27, 25, 88, 89);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 136, 946, 364);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(68, 119, 807, 288);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showComment(e);
			}
		});
		table.setModel(getModel());
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("\u641C\u7D22\uFF1A");
		lblNewLabel.setFont(new Font("新宋体", Font.PLAIN, 26));
		lblNewLabel.setBounds(249, 41, 86, 38);
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("新宋体", Font.PLAIN, 20));
		textField.setBounds(345, 43, 262, 38);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textField.getText();
				boolean c;
				if(!text.isEmpty()) {
					c = u.Search(text);
					if(c) {
						show(u.getsearch());
					}
					else {
						JOptionPane.showMessageDialog(null, "查無資料", "線上圖書系統",JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"請輸入搜索關鍵字","提示訊息",JOptionPane.WARNING_MESSAGE); 
				}

			}
		});
		btnNewButton.setIcon(new ImageIcon(".\\Image\\172546_search_icon.png"));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBounds(617, 38, 56, 43);
		panel_1.add(btnNewButton);
		
		btnNewButton_2 = new JButton("Borrow Book");
		btnNewButton_2.setBackground(new Color(238, 232, 170));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrowact(e);
			}
		});
		btnNewButton_2.setFont(new Font("新宋体", Font.PLAIN, 19));
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.setIcon(new ImageIcon(".\\Image\\185073_dowload_book_icon.png"));
		btnNewButton_2.setBounds(683, 26, 212, 73);
		panel_1.add(btnNewButton_2);
	}
	public void show(ArrayList<Book> b) {
		model = new DefaultTableModel(
                new Object[][] {},
				new String[] {
						"Name","Writter", "Publish", "State", "Sort", "LendTime", "ReturnTime"
				});
		for(int i = 0; i<b.size();i++) {
			String state= "";
			if(b.get(i).getState()) {
				state = "已歸還";
			}
			else {
				state = "未歸還";
				}
			model.addRow(new Object [] {b.get(i).getName(), b.get(i).getWriter(), b.get(i).getPublish(), state, b.get(i).getSort(), b.get(i).getLendTime(), b.get(i).getReturnTime() });
		}
		table.setModel(model);
	}
	public void actionPerformed(ActionEvent e) {
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date();
		time.setText(format.format(date));
	}
	public void showComment(MouseEvent e) {
		int selectedRowID = table.getSelectedRow();
		boolean c;
		String s = (String)table.getValueAt(selectedRowID, 3);
		if(s.equals("已歸還")) { c = true;
		btnNewButton_2.setEnabled(true);}
		else {c=false;}
		Book b1 = new Book((String)table.getValueAt(selectedRowID, 0),(String)table.getValueAt(selectedRowID, 1), (String)table.getValueAt(selectedRowID, 2), c, (String)table.getValueAt(selectedRowID, 3), (Date) table.getValueAt(selectedRowID, 5), (Date) table.getValueAt(selectedRowID, 6));
		String s1 = "Average Star ："+String.valueOf(b1.getavgStar())+"\n"+"Comment:";		
		for(String l : b1.getComment()){
			s1 = s1 + l +"\n";
		}
		JOptionPane.showMessageDialog(null, s1, b1.getName(),JOptionPane.INFORMATION_MESSAGE);	
	}
	public void borrowact(ActionEvent e) {
		int selectedRowID = table.getSelectedRow();
		Book b1 = new Book((String)table.getValueAt(selectedRowID, 0),(String)table.getValueAt(selectedRowID, 1), (String)table.getValueAt(selectedRowID, 2), true, (String)table.getValueAt(selectedRowID, 3), (Date) table.getValueAt(selectedRowID, 5), (Date) table.getValueAt(selectedRowID, 6));
		u.borrow(b1);
  	  	u.setallBook();
  	  	this.b = u.getallBook();
		table.setModel(getModel());
		JOptionPane.showMessageDialog(null, "借閱成功", "通知",JOptionPane.INFORMATION_MESSAGE);
		btnNewButton_2.setEnabled(false);
	}
	public DefaultTableModel getModel() {
		model = new DefaultTableModel(
                new Object[][] {},
				new String[] {
						"Name","Writter", "Publish", "State", "Sort", "LendTime", "ReturnTime"
				});
		for(int i = 0; i<this.b.size();i++) {
			String state= "";
			if(this.b.get(i).getState()) {
				state = "已歸還";
			}else {state = "未歸還";}
			model.addRow(new Object [] {this.b.get(i).getName(), this.b.get(i).getWriter(), this.b.get(i).getPublish(), state, this.b.get(i).getSort(), this.b.get(i).getLendTime(), this.b.get(i).getReturnTime(), });
		}
		return model;
	}
}
