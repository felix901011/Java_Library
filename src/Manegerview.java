import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Manegerview extends JFrame{

	private JPanel contentPane;
	private DefaultTableModel model;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private Admin u;
	private ArrayList<Book> b;
	private Book b1; 
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private java.util.Date nowdate1,nowdate2;
	private JButton btnNewButton_1, btnNewButton;
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manegerview frame = new Manegerview();
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
	public Manegerview(ArrayList<Book> b, Admin u) {
		this.u = u;
		this.b = b;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1067, 589);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1053, 254);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 254, 1053, 288);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u66F8\u7C4D\u8CC7\u6599");
		lblNewLabel.setFont(new Font("新宋体", Font.PLAIN, 30));
		lblNewLabel.setBounds(74, 22, 122, 35);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(".\\Image\\4781829_circle_customer_help_info_information_icon.png"));
		lblNewLabel_1.setBounds(23, 10, 48, 47);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u66F8\u540D\uFF1A");
		lblNewLabel_2.setFont(new Font("新宋体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(84, 67, 60, 25);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u4F5C\u8005\uFF1A");
		lblNewLabel_3.setFont(new Font("新宋体", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(84, 123, 68, 25);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u51FA\u7248\u793E\uFF1A");
		lblNewLabel_4.setFont(new Font("新宋体", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(64, 179, 80, 31);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u72C0\u614B\uFF1A");
		lblNewLabel_5.setFont(new Font("新宋体", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(399, 66, 68, 26);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u5206\u985E\uFF1A");
		lblNewLabel_6.setFont(new Font("新宋体", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(399, 117, 68, 25);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("\u51FA\u79DF\u6642\u9593\uFF1A");
		lblNewLabel_7.setFont(new Font("新宋体", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(725, 67, 100, 25);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("\u61C9\u6B78\u56DE\u6642\u9593\uFF1A");
		lblNewLabel_8.setFont(new Font("新宋体", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(703, 117, 122, 25);
		panel_1.add(lblNewLabel_8);
		
		textField = new JTextField();
		textField.setFont(new Font("新宋体", Font.PLAIN, 20));
		textField.setBounds(155, 67, 183, 25);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("新宋体", Font.PLAIN, 20));
		textField_1.setBounds(155, 123, 183, 25);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("新宋体", Font.PLAIN, 20));
		textField_2.setBounds(155, 179, 183, 25);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("新宋体", Font.PLAIN, 20));
		textField_3.setBounds(477, 67, 122, 25);
		textField_3.setEditable(false);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("新宋体", Font.PLAIN, 20));
		textField_4.setBounds(477, 117, 122, 25);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("新宋体", Font.PLAIN, 20));
		textField_5.setBounds(835, 67, 189, 25);
		textField_5.setEditable(false);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("新宋体", Font.PLAIN, 20));
		textField_6.setBounds(835, 113, 189, 25);
		textField_6.setEditable(false);
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		
		btnNewButton = new JButton("\u522A\u9664");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteselectrow(e);
			}
		});
		btnNewButton.setBackground(new Color(204, 204, 204));
		btnNewButton.setFont(new Font("新宋体", Font.PLAIN, 20));
		btnNewButton.setEnabled(false);
		btnNewButton.setIcon(new ImageIcon(".\\Image\\103412_text_book_remove_icon.png"));
		btnNewButton.setBounds(761, 179, 156, 77);
		panel_1.add(btnNewButton);
		
		btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reviseb(e);
			}
		});
		btnNewButton_1.setBackground(new Color(204, 204, 204));
		btnNewButton_1.setFont(new Font("新宋体", Font.PLAIN, 20));
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setIcon(new ImageIcon(".\\Image\\352158_system_tv_update_icon.png"));
		btnNewButton_1.setBounds(584, 179, 156, 77);
		panel_1.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(95, 10, 807, 244);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showselectrow(e);
			}
		});
		table.setModel(getModel());
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setSelectionBackground(Color.darkGray);
		scrollPane.setViewportView(table);

	}
	
	public void deleteselectrow(ActionEvent e) {
	      int selectedRowID=table.getSelectedRow();
	      boolean c;
	      if (selectedRowID != -1) { //有選取 : 刪除指定列
	  		  String s = (String)table.getValueAt(selectedRowID, 3);
			  if(s.equals("已歸還")) { c = true;}
			  else {c=false;}
	          try {
	      		if(table.getValueAt(selectedRowID, 5) == null) { nowdate1 = null;}
	      		else{ nowdate1 = sdf.parse((String)table.getValueAt(selectedRowID, 5));}
	    		if(table.getValueAt(selectedRowID, 6) == null) { nowdate2 = null;}
	    		else{ nowdate2 = sdf.parse((String)table.getValueAt(selectedRowID, 6));}
			  } catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			  }
	    	  Book b = new Book((String)table.getValueAt(selectedRowID, 0), (String)table.getValueAt(selectedRowID, 1), (String)table.getValueAt(selectedRowID, 2), c, (String)table.getValueAt(selectedRowID, 4), nowdate1, nowdate2);
	    	  model.removeRow(selectedRowID);
	    	  u.RemoveBook(b);
	    	  u.setallBook();
	    	  this.b = u.getallBook();
	  		  table.setModel(getModel());
	  		  btnNewButton.setEnabled(false);
	    	  JOptionPane.showMessageDialog(null,"已刪除此書。","提示訊息",JOptionPane.INFORMATION_MESSAGE);
	       }
	      else {
	    	  JOptionPane.showMessageDialog(null,"請選擇書籍。","提示訊息",JOptionPane.INFORMATION_MESSAGE);
	      }
	}
	
	public void showselectrow(MouseEvent e) {
		int selectedRowID=table.getSelectedRow();
		boolean c;
		textField.setText((String)table.getValueAt(selectedRowID, 0));
		textField_1.setText((String)table.getValueAt(selectedRowID, 1));
		textField_2.setText((String)table.getValueAt(selectedRowID, 2)); 
		textField_3.setText((String)table.getValueAt(selectedRowID, 3));
		textField_4.setText((String)table.getValueAt(selectedRowID, 4)); 
		
		if(textField_3.getText().equals("已歸還")) {
		btnNewButton.setEnabled(true);}
		else {btnNewButton.setEnabled(false);}
		btnNewButton_1.setEnabled(true);
		
		if(table.getValueAt(selectedRowID, 5) == null) { textField_5.setText("");}
		else{ textField_5.setText(sdf.format((Date) table.getValueAt(selectedRowID, 5)));}
		
		if(table.getValueAt(selectedRowID, 6) == null) { textField_6.setText("");}
		else{ textField_6.setText(sdf.format((Date) table.getValueAt(selectedRowID, 6)));}
		
		if(textField_3.getText().equals("已歸還")) { c = true;}
		else {c=false;}
		
		b1 = new Book((String)table.getValueAt(selectedRowID, 0),(String)table.getValueAt(selectedRowID, 1), (String)table.getValueAt(selectedRowID, 2), c, (String)table.getValueAt(selectedRowID, 3), (Date) table.getValueAt(selectedRowID, 5), (Date) table.getValueAt(selectedRowID, 6));
	}
	public void reviseb(ActionEvent e) {		
		u.ReviseBook(b1, textField.getText(), textField_1.getText(), textField_2.getText(), textField_4.getText());	
		JOptionPane.showMessageDialog(null,"已修改完成。","提示訊息",JOptionPane.INFORMATION_MESSAGE);
		btnNewButton_1.setEnabled(false);
  	  	u.setallBook();
  	  	this.b = u.getallBook();
		table.setModel(getModel());
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
