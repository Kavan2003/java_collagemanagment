import java.sql.*;
import java.util.Formatter;
import java.util.Scanner;

public class exam
{
/*
student
exam upcoming constant line wise all date wise syllabus
*/
Scanner sc = new Scanner(System.in);
public void upcoming_exam(String b){
  try {

      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con= DriverManager.getConnection(
              "jdbc:mysql://localhost:3306/college","root","root");

      Statement stmt=con.createStatement();
      ResultSet rs=stmt.executeQuery("select s.subject,d.date,d.status,d.syllabus from subject s join exam d where(s.subject_id=d.subject_id) and d.status=\"upcoming\";");
      Formatter fmt = new Formatter();
      fmt.format( "%35s %35s %35s %35s\n","subject", "date", "status","syllabus");
      while(rs.next())
      {

//          System.out.println("->"+rs.getString(1)+"\t->"+rs.getString(2)+"\t->"+rs.getString(3)+"\tsyllabus->"+rs.getString(4));
        fmt.format(" %35s  %35s %35s %35s\n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
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
public void result(String b){
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college","root","root");

        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select s.subject , b.grade from result \n" +
                "b\n" +
                "join subject s join  users u where u.id_no=b.id_no and s.subject_id=b.subject_id and u.id_no=(select id_no from login where username =\""+b+"\");");
//        select* from result
//                b
//        join subject s join  users u where u.id_no=b.id_no and s.subject_id=b.subject_id amd b.id_no = b;

        while(rs.next())
        {

            System.out.println("subject->"+rs.getString(1)+"\tgrade->"+rs.getString(2));
//            if(rs.getString(2)!="A")


        }
        System.out.println("Enter back to go to main menu");
        String s= sc.next();
        if(s=="back"){
            return;
        }
    }catch (Exception  e){
        System.out.println(e);
    }
}
}
