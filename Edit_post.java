import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
public class Edit_post extends Post {
	public void EditPostMethod(String name, String description, String link) {
		Scanner in = new Scanner(System.in);
		boolean flag = false;
		//the user is shown the text
		try {
			FileReader file = new FileReader(name);
			BufferedReader input = new BufferedReader(file);
			String line;
			while ((line = reader.readLine()) =! null) {
				System.out.println(line);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//the user chooses to edit the description or the link
		while (flag == false) {
			String msg2 = "click 1 to edit the description, or click 2 to edit the link";
			System.out.println(msg2);
			int option = in.nextInt();
			if (option == 1) {
				//edits the description
				FileWriter fr = new FileWriter(name);
				BufferedWriter br = new BufferedWriter(fr);
				in.nextline();
				try {
					description = in.nextLine();
					writer.write(description);
					writer.close();
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			} else if (option == 2) {
				//edits the link
				FileWriter fr = new FileWriter(name);
				BufferedWriter br = new BufferedWriter(fr);
				in.nextline();
				try {
					link = in.nextLine();
					writer.write(link);
					writer.close();
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			//the user is shown the texts after the changes are made
			try {
				FileReader file = new FileReader(name);
				BufferedReader input = new BufferedReader(file);
				String line;
				while ((line = reader.readLine()) =! null) {
					System.out.println(line);
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			//the user chooses to exit or to continue editing
			System.out.println("Press 1 to continue editing and 2 to save and exit");
			int ans = in.next();
			if (ans == 2 ) {
				flag = true;
			} else {
				System.out.println(msg2);
			}
		}
	}
}
