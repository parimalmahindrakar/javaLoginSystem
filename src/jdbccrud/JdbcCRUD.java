package jdbccrud;
import java.sql.*;

public class JdbcCRUD {

    public boolean checkLogin(String name, String pswd) throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/SampleDB", "root", "");
        try{
            PreparedStatement pst;
            pst = conn.prepareStatement("select * from users where username=? and password=?");
            pst.setString(1, name);
            pst.setString(2, pswd);
            ResultSet rs = pst.executeQuery();
            return rs.next();
        }catch(SQLException e){
            System.out.println("Error: "+e);
            return false;
        }
        finally{
            conn.close();
        }
    }
    public boolean checkUserName(String name) throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/SampleDB", "root", "");
        try{
            PreparedStatement pst;
            pst = conn.prepareStatement("select * from users where username=?");
            pst.setString(1, name);
            ResultSet rs = pst.executeQuery();
            return rs.next();
        }catch(SQLException e){
            System.out.println("Error: "+e);
            return false;
        }finally{
            conn.close();
        }
    }
    public void insertQuery(String uname,String pswd) throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/SampleDB", "root", "");
        try{
            PreparedStatement pst;
            pst = conn.prepareStatement("insert into users(username,password) values(?,?)");
            pst.setString(1, uname);
            pst.setString(2, pswd);
            int rowsInserted = pst.executeUpdate();
            System.out.println(rowsInserted);
            if (rowsInserted > 0){
                System.out.println("A new user was inserted successfully!");
            }
        }catch(SQLException e){
            System.out.println("Error: "+e);
        }finally{
            conn.close();
        }
    }

    
}
