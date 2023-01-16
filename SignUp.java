import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;

import java.util.Scanner;

public class SignUp {

	public String signUp() {

		String path = "users.txt";

		System.out.println("Please enter a username");
		boolean x = true;
		String username ="";
		String line;
		int id = 1;
		username = Interface.input.nextLine();

		/*try {

			do
			{
				id = 1;
				FileReader fr = new FileReader("users.txt");
				BufferedReader br = new BufferedReader(fr);
				
				while((line = br.readLine()) != null) {
					
					id++;
					String[] column = line.split(",");

					if (username.equals(column[1])) {
						System.out.println("Someone else is already using this username. Please enter a new one.");
						x = false;
						break;
					} else {
						x = true;
					}
				}
				br.close();
			} while (x == false);
			
		}catch (FileNotFoundException e) {
			System.err.println("Unable to open file " + path);
		} catch (Exception e) {
			System.err.println("An error has occurred");
		}

		System.out.println("Please enter a password");
	    String password = input.next();

		try {
			File file = new File(path);
			PrintWriter pw = new PrintWriter(new FileOutputStream(file,true));
			String dataToBeSaved = (id + "," + username + "," + password);
			pw.append(dataToBeSaved + "\n");
			pw.close();

		} catch (FileNotFoundException e) {
			System.err.println("Unable to open file ");

		} catch (Exception e) {
			System.err.println("An error has occurred");
		} /* */

		String userid = String.valueOf(id);
		Profile.createProfile(userid);
		return userid;
	}
}

