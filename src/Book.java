import java.util.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
public class Book extends Library {
    private String Name, Writer, Publish, Sort, Borrower;
    private Date LendTime, ReturnTime;
    private boolean State;
    private dao Database;
    private ArrayList <String> Comment= new ArrayList <String>();
    private int Star;
    
    Scanner s= new Scanner(System.in);

    public Book(String name, String writer, String publish, Boolean state, String sort, Date lendtime, Date returntime) {
        setName(name);
        setWriter(writer);
        setPublish(publish);
        setSort(sort);
        setState(state);
        setLendTime(lendtime);
        setReturnTime(returntime);
    }

    public void setName(String name){this.Name=name;}
    public String getName(){return Name;}
    public void setWriter(String writer){this.Writer=writer;}
    public String getWriter(){return Writer;}
    public void setPublish(String publish){this.Publish=publish;}
    public String getPublish(){return Publish;}
    public void setSort(String sort){this.Sort=sort;}
    public String getSort(){return Sort;}

    public void setState(Boolean state){this.State=state;}
    public Boolean getState(){return State;}

    public void setLendTime(Date lendtime){this.LendTime=lendtime;}
    public Date getLendTime(){return LendTime;}
    public void setReturnTime(Date returntime){this.ReturnTime=returntime;}
    public Date getReturnTime(){return ReturnTime;}

    //public void addComment(String comment){this.Comment.add(s.next());}
    //public ArrayList<String> getComment(){return Comment;}
    /*public void addStar(int star){
        do{
            if(0<=star&&star<=5){
                Star.add(star);
            }else{System.out.println("Please insert only 0-5 stars.");}
        }while(star<0||star>5);
    } */   
    public int getavgStar(){
    	Database = new dao();
    	String sql = "select AVG(Star) from Comment where BookName = '"+getName()+"'";
    	try {
        	PreparedStatement pstmt = Database.getCon().prepareStatement(sql);
    		ResultSet rs = pstmt.executeQuery();
    		if(rs.next()) {
    			this.Star = rs.getInt(1);
    		}
    		rs.close();
    		pstmt.close();
    		Database.getCon().close();
    	}catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return Star;
    }
    public ArrayList<String> getComment(){
    	Database = new dao();
    	String sql = "select Comment from Comment where BookName = '"+getName()+"'";
    	try {
        	PreparedStatement pstmt = Database.getCon().prepareStatement(sql);
    		ResultSet rs = pstmt.executeQuery();
    		while(rs.next()) {
    			this.Comment.add(rs.getString(1));
    		}
    		rs.close();
    		pstmt.close();
    		Database.getCon().close();
    	}catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return Comment;
    }

    public String toString(){return getName()+ getWriter()+ getPublish()+ getSort()+ getLendTime()+ getReturnTime()+ getComment()+ getState();}

}