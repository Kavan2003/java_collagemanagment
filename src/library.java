import java.sql.*;
import java.util.Formatter;
import java.util.Scanner;


class library implements abslib {

//    private String str;
Scanner sc = new Scanner(System.in);
     public void issue_book(String b) {
        /* this.str = str; */

//        int i=0;
      try{
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection con= DriverManager.getConnection(
                  "jdbc:mysql://localhost:3306/college","root","root");

          Statement stmt=con.createStatement();
          ResultSet rs=stmt.executeQuery("select * from lib ");
          Formatter fmt = new Formatter();
//          System.out.println("\t\t\t\t");
          while(rs.next())
          {

//              System.out.println("name->"+rs.getString(1)+"\tisbn->"+rs.getString(2)+"\tauthor->"+rs.getString(3)+"\tpublication->"+rs.getString(4)+"\tstatus->"+rs.getString(5));
              fmt.format(" %35s %35s %35s  %35s %35s \n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));

          }

          System.out.println(fmt);
          System.out.println("Enter the book isbn number to issue \nAnd enter none to return");
          String issuebook;
          issuebook=sc.next();

//          Statement stm=con.createStatement();
//          rs=stmt.executeQuery("select*from users where id_no=(select id_no from login where username = \""+b+"\")");
//          while(rs.next())
//              System.out.println(rs.getString(1)+rs.getString(2)+rs.getString(3)+rs.getString(4)+rs.getString(5));

         if (issuebook!="none"){
             rs = stmt.executeQuery("select id_no from login where username = \"" + b + "\"");
             String userid=null;
             while(rs.next())
                 userid = rs.getString(1);
//             System.out.println(userid);

             stmt.executeUpdate("insert into userbook(isbn,id_no) values ("+issuebook+","+userid+")");
             stmt.executeUpdate("update lib \n" +
                     "set status=\"issued\"\n" +
                     "where isbn=\""+issuebook+"\";");
             rs= stmt.executeQuery("select*from userbook");
             while(rs.next())
                 System.out.println(rs.getString(1)+rs.getString(2));
         }
//          con.close();
          con.close();

      }catch(Exception e){ System.out.println(e);}



    }
     public void return_book(String b){
       try{
           Formatter fmt = new Formatter();
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con= DriverManager.getConnection(
                   "jdbc:mysql://localhost:3306/college","root","root");

            Statement stmt=con.createStatement();
           ResultSet   rs = stmt.executeQuery("select name,author,isbn from lib where isbn=\n" +
                   "(select isbn from userbook where id_no=\n" +
                   "(select id_no from login where username =\""+b+"\"));");
           fmt.format(" %35s %35s %35s   \n","name ","isbn","author");
           //data of book issued  by user
//                       rs=stmt.executeQuery("select*from users where id_no=(select id_no from login where username = \""+b+"\")");
                  while(rs.next())
                      fmt.format(" %35s %35s %35s   \n",rs.getString(1),rs.getString(3),rs.getString(2));
//                      System.out.println("name->"+rs.getString(1)+"\tisbn->"+rs.getString(3)+"\tauthor->"+rs.getString(2));
//              System.out.println(rs.getString(1)+rs.getString(2)+rs.getString(3));
           System.out.println(fmt);

           System.out.println("Enter isbn no if you want to return book else enter back");
           String isb = sc.next();
           if (isb !="back"){
               stmt.executeUpdate("update lib \n" +
                       "set status=\"available\"\n" +
                       "where isbn=\""+isb+"\";");
               stmt.executeUpdate("DELETE FROM userbook WHERE isbn=\""+isb+"\"");

                rs = stmt.executeQuery("select name,author,isbn from lib where isbn=\n" +
                       "(select isbn from userbook where id_no=\n" +
                       "(select id_no from login where username =\""+b+"\"));");


               while(rs.next())




               fmt.format(" %35s %35s %35s   \n",rs.getString(1),rs.getString(2),rs.getString(3));





               System.out.println(fmt);

           }

           else{
               con.close();
               return;
           }


//            ResultSet rs=stmt.executeQuery("select * from lib ");
//            while(rs.next())
//               System.out.println("");
             }catch (Exception  e){
            System.out.println(e);
       }
    }



    /*
    add book to lib
    remove book to lib
    search book to lib
    add issued book to useracc
    returne book from useracc
    2 table req userbook  &  libbook
    libbook>>book_id,name,Emei,author,public,status
    userbook>>booki_d,user_id


     */

}