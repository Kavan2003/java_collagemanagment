import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Formatter;
import java.util.Scanner;

public class detail implements absclg {
    Scanner sc = new Scanner(System.in);
         public void detail(String b){
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college","root","root");

        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select s.name,s.course,s.dob,s.number,b.name,b.author,b.publication from userbook u join users s join lib b where  s.id_no = (select id_no from login where username =  \""+b+"\");");
        Formatter fmt = new Formatter();
        boolean f=false;
        while(rs.next())
        {
            if (f == false) {
                fmt.format(" %35s  %35s %35s %35s\n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
                f=true;
            }

            fmt.format(" book issued-- %35s  %35s %35s \n",rs.getString(5),rs.getString(6),rs.getString(7));



        }
        System.out.println(fmt);

        System.out.println("Enter back to go to main menu");
        String s= sc.next();
        if(s=="back"){
            return;
        }
    }catch (Exception  e){
        System.out.println(e);
    }
}
/*
student details
exam
result
motivation
fees
e-content
punch_out/in
attendance record
subject wise %
 */

}
