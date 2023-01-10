import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader ;
import java.io.File;
import java.util.Scanner;

public class Login {
public static void main(String args[]) {
   	Scanner myobj1 = new Scanner(System.in);
    System.out.println("Please enter your Username");
    String userName = myobj1.next();

    Scanner myobj2 = new Scanner(System.in);
    System.out.println("Please enter your Password");
    String password = myobj2.next();

String line = "";
BufferedReader br = null;

	try {
		FileReader file1 = new FileReader("users.txt");
		BufferedReader br = new BufferedReader(new FileReader(file1));
	}catch (FileNotFoundException e) {
		System.err.println("Unable to open file " + file1);
	}
	while ((line = br.readLine()) != null) {
		String[] column = line.split(";");
	try{
		if ((userName.equals(column[1])) && (password.equals(column[2]))) {
   	     System.out.println("Connected successfully! Welcome!");
		}
		else if ((userName.equals(column[1])) && (password != (column[2]))) {
			System.out.println("Password incorrect");
		}else if ((password.equals(column[1])) && (userName !=(column[2]))) {
			System.out.println("Username incorrect");
		}

	}catch (Exception e) {
		 System.err.println("error");
		}
	}
}
}