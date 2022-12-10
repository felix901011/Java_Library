import java.sql.*;
public class dao {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/Library?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    private static Connection con = null;

    static final String USER = "user";
    static final String PASS = "";
	public dao() {
        try{
            Class.forName(JDBC_DRIVER);
        
            System.out.println("连接数据库...");
            con = DriverManager.getConnection(DB_URL,USER,PASS);
 
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){

            e.printStackTrace();
        }
    }
	public Connection getCon() {
		   
        
		return con;
	}
	
	public void closeCon(Connection con) throws SQLException{

       
		if(con!= null) {

       
			con.close();
		}	
	}

}
