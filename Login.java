import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader ;
import java.io.File;
import java.util.Scanner;
import java.io.*;

public class Login {
	public static String login() throws FileNotFoundException, IOException {
   		Scanner myobj1 = new Scanner(System.in);
    	System.out.println("Please enter your Username");
    	String userName = myobj1.next();

    	Scanner myobj2 = new Scanner(System.in);
    	System.out.println("Please enter your Password");
    	String password = myobj2.next();

		String line = "";

		try {
			BufferedReader br = new BufferedReader(new FileReader("users.txt"));
		} catch (FileNotFoundException e) {
			System.err.println("Unable to open file " + "users.txt");
		}
		BufferedReader br = new BufferedReader(new FileReader("users.txt"));
		while ((line = br.readLine()) != null) {
			String[] column = line.split(";");
			try {
				if ((userName.equals(column[1])) && (password.equals(column[2]))) {
					System.out.println("Connected successfully! Welcome!");
				} else if ((userName.equals(column[1])) && (password != (column[2]))) {
					System.out.println("Password incorrect");
				} else if ((password.equals(column[1])) && (userName !=(column[2]))) {
					System.out.println("Username incorrect");
				}

			} catch (Exception e) {
		 		System.err.println("error");
			}
		}
		return column[0];
    }
}
