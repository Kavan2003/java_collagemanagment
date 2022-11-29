import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class loginregister {
    Scanner input = new Scanner(System.in);
    String Id_Type, ID_NO ,course ,DOB ,Name,Username,Password,Email,Number;
    int pr10,pr12;
    public String login() throws IOException {
        try{
        String UUsername,Upass,Uauto;
    System.out.println("Welcome to login portal");
        System.out.println("Enter Username");
        UUsername = input.next();

        System.out.println("Enter password");
        Upass = input.next();




            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/college","root","root");

            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from login ");

            while(rs.next())

                if(UUsername.equals(rs.getString(1))&Upass.equals(rs.getString(2))){
//            System.out.println("success");
            con.close();
                return UUsername;}


            con.close();
            return "fail";
        }catch(Exception e){ System.out.println(e);}

        return "fail";
    }}

/*


    public void register() {
//        System.out.println("Your roll no is 00000");
        System.out.println("WELCOME TO REGISTRATION");
        System.out.println("Enter Your Name");
        Name = input.next();
        System.out.println("Enter Your Email");
        Email = input.next();
        System.out.println("Enter Your DOB");
        DOB = input.next();
        System.out.println("Enter Your Number");
        Number = input.next();
        System.out.println("set Your Password");
        Password = input.next();
        System.out.println("Enter course");
        course = input.next();
        System.out.println("Enter 10th percentage");
        pr10 = input.nextInt();
        System.out.println("Enter 12th percentage ");
        pr12 = input.nextInt();

        System.out.println("Enter Id Type And ID NO.");
        Id_Type = input.next();
        ID_NO = input.next();
        Username=Email;
        System.out.println("YOUR Email IS YOUR USERNAME");
        String data;
        data = "<"+Username+Password+">\t"+Name+"\t"+Email+"\t"+DOB+"\t"+Number+"\t"+course+"\t"+pr10+"\t"+pr12+"\t"+Id_Type+"->"+ID_NO+"\n";
        File file = new File("login.txt");
        FileWriter fr;
        try {
            fr = new FileWriter(file,true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedWriter br = new BufferedWriter(fr);
        try {
            br.write(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            br.close();
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void demo() throws Exception{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/college","root","root");
//here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from users");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            con.close();
        }catch(Exception e){ System.out.println(e);}
        System.out.println("done");
    }
}
    }
            }
*/
