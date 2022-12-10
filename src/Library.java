import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class Library {
	private dao Database;
	private ArrayList<Book> allb;
	private ArrayList<User> u = new ArrayList<User>();
	public void setu(ArrayList<User> u) {
		this.u = u;
	}
	public ArrayList<User> getu(){
		return u;
	}
	public void setallBook() {
		allb = new ArrayList<Book>();
		Database = new dao();//初始化
		Database.getCon();
		String sql = "select * from Book";
		try {      
			PreparedStatement ps = Database.getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {	
				boolean b;
				String s = rs.getString(4);
				if(s.equals("已歸還")) {
					b = true;
				}
				else {
					b=false;
				}
				allb.add(new Book(rs.getString(1), rs.getString(2), rs.getString(3), b, rs.getString(5), rs.getDate(6), rs.getDate(7)));			
			}
			rs.close();
			ps.close();
			Database.getCon().close();
		} catch (SQLException e) {      
			e.printStackTrace();
		}
	}
	public ArrayList<Book> getallBook() {
		return allb;
	}

}
