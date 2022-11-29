import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

;

public class sql {
    public static void main(String[] args) {


                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con=DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/college","root","root");
//here sonoo is database name, root is username and password
                    String s = "kavanthosani2003@gmail.com\n";
                    Statement stmt=con.createStatement();
                    ResultSet rs=stmt.executeQuery("select username from users");
                    while(rs.next())
//                        s.equals(rs.getString(1)
                        System.out.println(rs.getString(1)+s.equals(rs.getString(1)+"\n"));
                    con.close();
                }catch(Exception e){ System.out.println(e);}
            }
        }


