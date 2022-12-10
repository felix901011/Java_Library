import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import java.lang.Object;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
;public class Search extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField time;
	private DefaultTableModel model;
	private Timer timer;
	private ArrayList<Book> b;
	/*

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search frame = new Search();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	 */
	public Search(ArrayList<Book> b, User u) {
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
	public void showComment(MouseEvent e) {
		int selectedRowID = table.getSelectedRow();
		boolean c;
		String s = (String)table.getValueAt(selectedRowID, 3);
		if(s.equals("已歸還")) { c = true;}
		else {c=false;}
		Book b1 = new Book((String)table.getValueAt(selectedRowID, 0),(String)table.getValueAt(selectedRowID, 1), (String)table.getValueAt(selectedRowID, 2), c, (String)table.getValueAt(selectedRowID, 3), (Date) table.getValueAt(selectedRowID, 5), (Date) table.getValueAt(selectedRowID, 6));
		String s1 = "Average Star ："+String.valueOf(b1.getavgStar())+"\n"+"Comment:";		
		for(String l : b1.getComment()){
			s1 = s1 + l +"\n";
		}
		JOptionPane.showMessageDialog(null, s1, b1.getName(),JOptionPane.INFORMATION_MESSAGE);	
	}
}
