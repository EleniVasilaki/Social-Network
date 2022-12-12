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

	public static void main(String[] args) {

		File file1 = new File("users.txt");

		System.out.println("Please enter a username");
		boolean x = false;
		String username = "";
		BufferedReader br = null;

		try {
			do
			{
				Scanner in = new Scanner (System.in);

				username = in.nextLine();
				br = new BufferedReader(new FileReader(file1));
				String line = "";

				while((line = br.readLine()) != null) {

					String[] column = line.split(",");

					if (username.equals(column[0]) == true) {
						System.out.println("Someone else is already using this username. Please enter a new one.");


					} else {
						x = true;
					}
				}

			} while (x == false);
			br.close();

		} catch (FileNotFoundException e) {
			System.err.println("Unable to open file ");
		} catch (Exception e) {
			System.err.println("Error");
		}

		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter(file1));
			PrintWriter pw = new PrintWriter(bw);
			pw.printf("%s,",username);
			bw.close();
		} catch (FileNotFoundException e) {
			System.err.println("Unable to open file ");
		} catch (Exception e) {
			System.err.println("Error");
		}

		System.out.println("Please enter a password");
		Scanner in = new Scanner (System.in);
		in.next();
	    String password = in.nextLine();
	    try {
			bw = new BufferedWriter(new FileWriter(file1));
			PrintWriter pw = new PrintWriter(bw);
			pw.println(""+password);
			bw.close();
		} catch (FileNotFoundException e) {
			System.err.println("Unable to open file ");
		} catch (Exception e) {
			System.err.println("Error");
		}

	}
}

