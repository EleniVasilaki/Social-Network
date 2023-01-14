import java.io.File;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SignUp {

	public static int signUp() {

		String path = "users.txt";

		System.out.println("Please enter a username");
		boolean x = true;
		String un ="";
		String line;
		BufferedReader br = null;
		int id = 0;

		try {
			br = new BufferedReader(new FileReader(path));
		}catch (FileNotFoundException e) {
		   System.err.println("Unable to open file " + path);
   		}

		try {
			do
			{
				Scanner input = new Scanner(System.in);
				String username = input.next();
				un = username;

				while((line = br.readLine()) != null) {

					String[] column = line.split(",");

					if (username.equals(column[1])) {
						System.out.println("Someone else is already using this username. Please enter a new one.");
						x = false;
						break;
					} else {
						x = true;
					}
				}
				id++;
			} while (x == false);
			br.close();

		} catch (Exception e) {
			System.err.println("Error");
		}

		System.out.println("Please enter a password");
		Scanner in = new Scanner (System.in);
	    	String password = in.next();
		
		System.out.println("Please enter a password");
		Scanner in = new Scanner (System.in);
		String password = in.next();

		try (FileWriter f = new FileWriter(path, true);
			BufferedWriter b = new BufferedWriter(f);
			PrintWriter p = new PrintWriter(b);) {
				p.printf("%d,%s,%s \n",id,username,password);
		} catch (IOException i) { 
			i.printStackTrace(); 
		}
	    	Profile.createProfile();
		return id;		
	}
}

