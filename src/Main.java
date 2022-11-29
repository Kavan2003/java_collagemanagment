import java.io.IOException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
//        System.out.println("Hello world!");
        loginregister r =new loginregister();
        String b="fail";
        library l=new library();
        exam e=new exam();
        detail d=new detail();

        while(b=="fail"){
            b=r.login();
//        b="kavan.thosanii";
//        d.detail();

            if(b!="fail"){
                while(true){

                    System.out.println("1.issue book");
                    System.out.println("2.return book");
                    System.out.println("3check exam");
                    System.out.println("4.check result");
                    System.out.println("5. profile");
                    System.out.println("6. exit");
                    System.out.println("Enter the choice");
                    int p=sc.nextInt();
                    switch (p){
                        case 1:l.issue_book(b);
                            break;
                        case 2:l.return_book(b);
                            break;
                        case 3:e.upcoming_exam(b);
                            break;
                        case 4:e.result(b);
                            break;
                        case 5 :d.detail(b);
                            break;
                        case 6: return;
                        default:
                            System.out.println("Invallid option");
                    }

                }
            }

        }
    }
}