import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.*;
import javax.swing.*;
import java.text.*;
public class Member extends User{
	private dao Database;
	private int Date, fine_perday;
	private String[][] records;
	
	public void setDate(int Date) {this.Date = Date;}
	public int getDate() {return Date;}
	public void setfine_perday(int fine) {this.fine_perday = fine;}
	public int getfine_perday() {return fine_perday;}
	private Calendar now;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private java.util.Date nowdate1,nowdate2;
	private Date sqldate;
	
	public Member( String Name, String Account, String Password, String ID,int Acc,int Num){
		super(Name,Account,Password,ID,Acc,Num);
	}
	public void Countfines(Book b, java.util.Date returnDate){
		int fine = 0;
		int lendtime_duration = returnDate.compareTo(b.getLendTime());

		if(lendtime_duration - Date > 0) {
			fine = (lendtime_duration - Date) * fine_perday;
		} 
		
		else if(lendtime_duration <= 0) {
			fine = 0;
		}
		int i = getAccumufines()+fine;
		setAccumufines(i);
	}
	public void borrow(Book b) { //改成返回BOOLEAN 再去顯示是否成功那些
		if(b.getState()) {
			Database = new dao();
			now = Calendar.getInstance();
			String sdate;			
			String sql1 = "update Book set State = ?, Lend = ?, ReturnBook = ? where Name = ?";//更新書本歸還時間
	        PreparedStatement pstmt;
	        try {
	            pstmt = (PreparedStatement) Database.getCon().prepareStatement(sql1);
	            pstmt.setString(1, "未歸還");
	            
				nowdate1 = now.getTime();
				sdate = sdf.format(nowdate1);
	            nowdate1 = sdf.parse(sdate);
	            sqldate = new java.sql.Date(nowdate1.getTime());
	            pstmt.setDate(2, sqldate);
	            
				now.add(Calendar.DAY_OF_MONTH, getDate());
				nowdate2 = now.getTime();
				sdate = sdf.format(nowdate2);
				nowdate2 = sdf.parse(sdate);
	        	sqldate = new java.sql.Date(nowdate2.getTime());
	            pstmt.setDate(3, sqldate);
	            
	            pstmt.setString(4, b.getName());
	            
	            pstmt.executeUpdate();
	            pstmt.close();
	        } catch (SQLException | ParseException e ) {
	            e.printStackTrace();
	        }
			String sql2 = "INSERT INTO Record VALUES(?,?,?,?,?)";
	        try {
	        	pstmt = (PreparedStatement) Database.getCon().prepareStatement(sql2);
	            pstmt.setString(1, getName());	
	            pstmt.setString(2, b.getName());
	            pstmt.setString(3, "未歸還");
	            sqldate = new java.sql.Date(nowdate1.getTime());
	            pstmt.setDate(4, sqldate);
	            sqldate = new java.sql.Date(nowdate2.getTime());
	            pstmt.setDate(5, sqldate);
	            pstmt.executeUpdate();
	            pstmt.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        int i = getNum()-1;
	        setNum(i);
			String sql3 = "update User set Num = ? where Name = ?";//更新書本歸還時間;
	        try {
	            pstmt = (PreparedStatement) Database.getCon().prepareStatement(sql3);
	            pstmt.setInt(1, getNum()-1);	            	
	            pstmt.setString(2, getName());	           	            
	            pstmt.executeUpdate();
	            pstmt.close();
	            Database.getCon().close();
	        } catch (SQLException e ) {
	            e.printStackTrace();
	        }
		}
		else {
			String s = String.format("%s\n%s%d%s", "借閱失敗", "此書最晚將會在", b.getLendTime(),"歸還");
			JOptionPane.showMessageDialog(null,"線上圖書系統", s,JOptionPane.ERROR_MESSAGE);
		}
	}
	public void Return(String BookName) {
		Database = new dao();
		now = Calendar.getInstance();
		String sdate;
		String sql1 = "update Book set State = ? ,Lend = ?, ReturnBook = ? where Name = ?";//更新書本歸還時間
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) Database.getCon().prepareStatement(sql1);
            pstmt.setString(1, "已歸還");           
            pstmt.setDate(2, null);          
            pstmt.setDate(3, null);
            pstmt.setString(4, BookName);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e ) {
            e.printStackTrace();
        }
        
		String sql2 = "update Record set State = ?, ReturnBook = ? where Name = ? ";
        try {
        	pstmt = (PreparedStatement) Database.getCon().prepareStatement(sql2);
            pstmt.setString(1, "已歸還");
            
			nowdate1 = now.getTime();
			sdate = sdf.format(nowdate1);
            nowdate1 = sdf.parse(sdate);
            sqldate = new java.sql.Date(nowdate1.getTime());
            pstmt.setDate(2, sqldate);
            pstmt.setString(3, getName());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        int i = getNum()+1;
        setNum(i);
		String sql3 = "update User set Accu = ?, Num = ? where Name = ?";//更新書本歸還時間;
        try {
            pstmt = (PreparedStatement) Database.getCon().prepareStatement(sql3);
            pstmt.setInt(1, getAccumufines());
            pstmt.setInt(1, getNum()+1);
            pstmt.setString(2, getName());	           	            
            pstmt.executeUpdate();
            pstmt.close();
            Database.getCon().close();
        } catch (SQLException e ) {
            e.printStackTrace();
        }
        
	}
	public String[][] getrecord() {
		Database = new dao();
		String sql1 = "select * from Record where Name = '"+getName()+"'";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) Database.getCon().prepareStatement(sql1);           
            int r=0;
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
            	r++;
            }
            records = new String[r][5];
            rs = pstmt.executeQuery();
            while(rs.next()) {
            	String sdate = sdf.format(rs.getDate(4));
            	records[rs.getRow()-1][0] = rs.getString(1);
            	records[rs.getRow()-1][1] = rs.getString(2);
            	records[rs.getRow()-1][2] = rs.getString(3);
            	records[rs.getRow()-1][3] = sdate;
            	sdate = sdf.format(rs.getDate(5));
            	records[rs.getRow()-1][4] = sdate;
            }
            pstmt.close();
            Database.getCon().close();
        } catch (SQLException  e ) {
            e.printStackTrace();
        }
        return records;
	}
	public void writtecomment(String l, String BookName,int i) {
		Database = new dao();
		String sql2 = "INSERT INTO Comment VALUES(?,?,?)";
        try {
        	PreparedStatement pstmt = (PreparedStatement) Database.getCon().prepareStatement(sql2);
            pstmt.setString(1, BookName);	
            pstmt.setString(2, l);
            pstmt.setInt(3, i);  
            pstmt.executeUpdate();
            pstmt.close();
            Database.getCon().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}