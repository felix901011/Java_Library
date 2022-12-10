import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
public class Admin extends User{
	private dao Database;
	public Admin( String Name, String Account, String Password, String ID,int Acc,int Num){
		super(Name,Account,Password,ID,Acc,Num);
	}

	public  void ReviseBook(Book b, String name, String writter, String publish, String sort) {
		Database = new dao();
		String  sql = "update Book set Name = ?,Writter = ?,Publish = ?, Sort = ? where Name = '"+b.getName() +"'";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) Database.getCon().prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, writter);
            pstmt.setString(3, publish);
            pstmt.setString(4, sort);
            pstmt.executeUpdate();
            pstmt.close();
            Database.getCon().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	public void AddBook(String name, String writter, String publish, boolean state, String sort) {
		Database = new dao();
		String  sql = "INSERT INTO Book VALUES(?,?,?,?,?,?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) Database.getCon().prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, writter);
            pstmt.setString(3, publish);
            pstmt.setString(4, "คwยkมู");
            pstmt.setString(5, sort);
            pstmt.setDate(6, null);
            pstmt.setDate(7, null);
            pstmt.executeUpdate();
            pstmt.close();
            Database.getCon().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	public void RemoveBook(Book b) {
		Database = new dao();
		String sql = "delete from Book where Name = '"+b.getName()+"'";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) Database.getCon().prepareStatement(sql);
			pstmt.executeUpdate();
			pstmt.close();
			Database.getCon().close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}