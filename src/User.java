import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class User extends Library{

	protected String Name;
	protected String Account;
	protected String Password;
	protected String ID;
	private int Accumufines = 0, Num;
	private dao Database;
	private User u;
	private ArrayList<Book> searchBook;
	
	public void setName( String Name ){ this.Name = Name; }
	public String getName(){ return Name; }
	public void setAcc( String Account ){ this.Account = Account; }
	public String getAcc(){ return Account; }
	public void setPassword( String Password ){ this.Password = Password; }
	public String getPassword(){ return Password; }
	public void setID( String ID ){ this.ID = ID; }
	public String getID(){ return ID; }
	public void setAccumufines(int Accu) {this.Accumufines = Accu;}
	public int getAccumufines() {return Accumufines;}
	public void setNum(int Num) {this.Num = Num;}
	public int getNum() {return Num;}
	public void setUser(User u) { this.u = u;}
	public User getUser() {return u;}

	public User( String Name, String Account, String Password, String ID, int Acc, int Num){
		setName(Name);
		setAcc(Account);
		setPassword(Password);
		setID(ID);
		setAccumufines(Acc);
		setNum(Num);
		setallBook();
	}

	public Boolean Search(String Name) {
		searchBook = new ArrayList<Book>();
		Database = new dao();
		Database.getCon();	
		boolean b, have = false;
		String sql = "select * from Book where Name like ?";
		try {     
			PreparedStatement ps = Database.getCon().prepareStatement(sql);
			String l = Name+'%';
			ps.setString(1, l);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				have = true;
			}
			rs = ps.executeQuery();
			while(rs.next()) {		
				if(rs.getString(4) == "已歸還") {
					b = true;
				}
				else {b=false;}
				searchBook.add(new Book(rs.getString(1),rs.getString(2),rs.getString(3),b,rs.getString(5),rs.getDate(6),rs.getDate(7)));			
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
     
			e.printStackTrace();
		}
		return have;		
	}	
	public ArrayList<Book> getsearch(){
		return searchBook;
	}
	
	
	public Boolean Login( String Account, String Password ) {
		Database = new dao();
		Database.getCon();
		String sql = "select * from User where Account=? and Password=?";
		boolean flag = false;
		try {       
			PreparedStatement ps = Database.getCon().prepareStatement(sql);
			ps.setString(1, Account);
			ps.setString(2, Password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				setUser(new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getInt(5), rs.getInt(6)));
				flag = true;
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {

       
			e.printStackTrace();
		}
		return flag;
		
	}
	public boolean Register(String name, String account, String password, String ID) {
		Database = new dao();
		boolean c = true;
		String again = "select Account from User where Account = '"+account+"'";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) Database.getCon().prepareStatement(again);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
            	c = false;
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(c) {
			String  sql = "INSERT INTO User VALUES(?,?,?,?,?,?)";
	        PreparedStatement pstmt1;
	        try {
	            pstmt1 = (PreparedStatement) Database.getCon().prepareStatement(sql);
	            pstmt1.setString(1, name);
	            pstmt1.setString(2, account);
	            pstmt1.setString(3, password);
	            pstmt1.setString(4, ID);
	            pstmt1.setInt(5, 0);
	            if(ID == "老 師") {
	            	pstmt1.setInt(6, 15);
	            }
	            else if(ID == "學 生") {
	            	pstmt1.setInt(6, 5);
	            }
	            else {
	            	pstmt1.setInt(6, 10);
	            }
	            pstmt1.executeUpdate();
	            pstmt1.close();
	            Database.getCon().close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }  
		}
		return c;
	}
}
