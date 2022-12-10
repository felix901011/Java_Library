import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.text.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.Timer;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class More extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private Timer timer;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JButton returnButton ;
	private Member u;
	private JTable table;
	private DefaultTableModel model;
	private int row;
	private Date date;
	private Calendar c;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private ArrayList<Book> b;

	public More(ArrayList<Book> b, Member u) {
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
		panel.setBackground(new Color(255, 255, 0));
		panel.setBounds(0, 0, 1053, 139);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);	
			}
		});
		btnNewButton_3.setBackground(new Color(255, 255, 0));
		btnNewButton_3.setIcon(new ImageIcon(".\\Image\\home.png"));
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setBounds(22, 28, 94, 89);
		panel.add(btnNewButton_3);
		
		textField = new JTextField();
		textField.setFont(new Font("新細明體", Font.PLAIN, 40));
		textField.setBackground(new Color(255, 255, 0));
		textField.setBounds(351, 28, 332, 89);
		timer=new Timer(500,this);
		timer.start();
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 250, 205));
		panel_1.setBounds(0, 139, 525, 413);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("    Personal Information");
		lblNewLabel.setBackground(new Color(250, 250, 210));
		lblNewLabel.setIcon(new ImageIcon(".\\Image\\1471104_align_employee_general_human_human list_icon.png"));
		lblNewLabel.setFont(new Font("新宋体", Font.PLAIN, 30));
		lblNewLabel.setBounds(21, 0, 504, 74);
		panel_1.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(250, 250, 210));
		panel_3.setBounds(1, 0, 19, 74);
		panel_1.add(panel_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 250, 205));
		panel_2.setBounds(525, 139, 528, 413);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("    Personal Records");
		lblNewLabel_1.setBackground(new Color(250, 250, 210));
		lblNewLabel_1.setIcon(new ImageIcon(".\\Image\\2205222_film_movie_record_video_icon.png"));
		lblNewLabel_1.setFont(new Font("新宋体", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(24, 0, 504, 76);
		panel_2.add(lblNewLabel_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(250, 250, 210));
		panel_4.setBounds(0, 0, 25, 76);
		panel_2.add(panel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 86, 423, 263);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				recordselect(e);
			}
		});
		table.setModel(getModel());
		scrollPane.setViewportView(table);
		
		returnButton = new JButton("Return Book");
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   returnb(e);
			}
		});
		returnButton.setBackground(new Color(245, 222, 179));
		returnButton.setFont(new Font("新宋体", Font.PLAIN, 20));
		returnButton.setIcon(new ImageIcon(".\\Image\\8581230_delivery_return_shipping_transport_logistics_icon.png"));
		returnButton.setBounds(164, 359, 221, 44);
		returnButton.setEnabled(false);
		panel_2.add(returnButton);
		
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("新宋体", Font.PLAIN, 20));
		textField_1.setBounds(91, 182, 183, 25);
		textField_1.setEditable(false);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("新宋体", Font.PLAIN, 20));
		textField_2.setBounds(91, 243, 183, 25);
		textField_2.setEditable(false);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("新宋体", Font.PLAIN, 20));
		textField_3.setBounds(321, 121, 122, 25);
		textField_3.setEditable(false);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("新宋体", Font.PLAIN, 20));
		textField_4.setBounds(91, 121, 122, 25);
		textField_4.setEditable(false);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel_2.setFont(new Font("新宋体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(21, 122, 60, 25);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u5E33\u865F\uFF1A");
		lblNewLabel_3.setFont(new Font("新宋体", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(21, 183, 60, 25);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u5BC6\u78BC\uFF1A");
		lblNewLabel_4.setFont(new Font("新宋体", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(21, 241, 60, 31);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u8EAB\u5206\uFF1A");
		lblNewLabel_5.setFont(new Font("新宋体", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(253, 121, 68, 26);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("\u5269\u9918\u501F\u66F8\u6578\uFF1A");
		lblNewLabel_5_1.setFont(new Font("新宋体", Font.PLAIN, 20));
		lblNewLabel_5_1.setBounds(21, 300, 136, 26);
		panel_1.add(lblNewLabel_5_1);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("新宋体", Font.PLAIN, 20));
		textField_5.setColumns(10);
		textField_5.setEditable(false);
		textField_5.setBounds(167, 300, 32, 25);
		panel_1.add(textField_5);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("\u7D2F\u7A4D\u7F70\u6B3E\uFF1A");
		lblNewLabel_5_1_1.setFont(new Font("新宋体", Font.PLAIN, 20));
		lblNewLabel_5_1_1.setBounds(236, 300, 108, 26);
		panel_1.add(lblNewLabel_5_1_1);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("新宋体", Font.PLAIN, 20));
		textField_6.setColumns(10);
		textField_6.setEditable(false);
		textField_6.setBounds(354, 300, 89, 25);
		panel_1.add(textField_6);
	}
	public void actionPerformed(ActionEvent e) {
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date=new Date();
			textField.setText(format.format(date));
			textField_1.setText(u.getAcc());
			textField_2.setText(u.getPassword());
			textField_3.setText(u.getID());
			textField_4.setText(u.getName());
			textField_5.setText(String.valueOf(u.getNum()));		
			textField_6.setText(String.valueOf(u.getAccumufines()));
			
		}
	public void recordselect(MouseEvent e) {
		row = table.getSelectedRow();
		String s = (String)table.getValueAt(row, 2);
		if(s.equals("未歸還")){
			returnButton.setEnabled(true);
		}
	}
	public void returnb(ActionEvent e) {
		int selectedRowID = table.getSelectedRow();
		boolean c;
		this.c = Calendar.getInstance();
		String s = (String)table.getValueAt(selectedRowID, 2);
		if(s.equals("已歸還")) { c = true;}
		else {c=false;}
		
		u.Return((String) table.getValueAt(row, 1));
		
		int i = JOptionPane.showConfirmDialog(null,"是否給予評價呢?","詢問",JOptionPane.YES_NO_OPTION);
		if(i == JOptionPane.YES_OPTION) {
			String s2 = JOptionPane.showInputDialog(null,"請書您的評價：","評論區",JOptionPane.OK_CANCEL_OPTION);
			String s4 = JOptionPane.showInputDialog(null,"請給與星星數1~5","評論區",JOptionPane.OK_CANCEL_OPTION);
			if(!s2.isEmpty() && !s4.isEmpty()) {
				int star = Integer.parseInt(s4);
				u.writtecomment(s2,(String) table.getValueAt(row, 1), star);
			}else {	JOptionPane.showMessageDialog(null, "有空格，評論未成立", "提示", JOptionPane.ERROR_MESSAGE); }				

		}
		date = this.c.getTime();
		String s1 = sdf.format(date);
		try {
			date = sdf.parse(s1);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		Book b;
		String s3 = (String) table.getValueAt(row, 1);
		for(int j = 0 ; j< this.b.size();j++) {
			if(s3.equals(this.b.get(j).getName())) {
				b = this.b.get(j);
				u.Countfines(b, date);
				break;
			}					
		}		
		returnButton.setEnabled(false);
		u.setallBook();
		table.setModel(getModel());
	}
	public DefaultTableModel getModel() {
		model = new DefaultTableModel(
                new Object[][] {},
				new String[] {
						"Name","BookName","State", "LendTime", "ReturnTime"
				});
		String[][] r = u.getrecord();
		if(r != null) {
			Object[] m = new Object[5];
			for(int i = 0; i<r.length;i++) {
				for(int j = 0; j< r[i].length;j++) {
					m[j] = r[i][j];	
				}
				model.addRow(m);
			}
		}
		return model;
	}
}
