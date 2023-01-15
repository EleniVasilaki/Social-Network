import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Login {
    public static String login() throws IOException {
        Scanner myobj1 = new Scanner(System.in);
        System.out.println("Please enter your Username");
        String userName = myobj1.next();
        Scanner myobj2 = new Scanner(System.in);
        System.out.println("Please enter your Password");
        String password = myobj2.next();
        String userid = "-1";
        String line;
        boolean flag = false;
  
        BufferedReader br = new BufferedReader(new FileReader("users.txt"));
        while ((line = br.readLine()) != null) {
            String[] column = line.split(",");
            try {
                if ((userName.equals(column[1])) && (password.equals(column[2]))) {
                   flag = true;
                   userid = column[0];
                }
            } catch (Exception e) {
                System.err.println("error");
            }    
        }
        if (flag == true) {
            System.out.println("Access granted! Welcome!");
        } else {
            System.out.println("Access denied! Invalid Username or Password");
            Interface.welcomeMenu();
        }
        return userid;
    }
}
