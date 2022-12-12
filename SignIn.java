import java.io.File;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SignIn {

	public static void signIn() {

		String path = "users.txt";

		System.out.println("Please enter a username");
		boolean x = true;
		String un ="";
		String line;
		BufferedReader br = null;

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

					if (username.equals(column[0])) {
						System.out.println("Someone else is already using this username. Please enter a new one.");
						x = false;
						break;
					} else {
						x = true;
					}
				}
			} while (x == false);
			br.close();

		} catch (Exception e) {
			System.err.println("Error");
		}

		System.out.println("Please enter a password");
		Scanner in = new Scanner (System.in);
	    String password = in.next();
	    try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(path));
			PrintWriter pw = new PrintWriter(bw);
			pw.printf("%s,%s \n",un,password);
			pw.close();

		} catch (FileNotFoundException e) {
			System.err.println("Unable to open file ");

		} catch (Exception e) {
			System.err.println("Error");
		}

	}
}

