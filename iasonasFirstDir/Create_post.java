import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

// H upload na kanei extend thn create: mesw methodou ths create na kalw thn upload analoga ean ebale perigrafh h oxi o xrhsths????
public  class Create_Post extends Post_code{
	//public static String path;
    public static Path createPostMethod() { //return is for testing purposes
        Scanner in = new Scanner(System.in);
        System.out.println("click 1 to add a description to your post" + "\n" + "click 2 to add text/link for your post"); // more options?
        int option = in.nextInt();
        try {
			BufferedWriter writer = new BufferedWriter( new FileWriter(".\\post.txt", true));
			BufferedReader reader = new BufferedReader(new FileReader(".\\post.txt"));
			long postId = 0;
			String line;
			while ((line = reader.readLine()) != null) {
				postId = postId + 1;
				System.out.println(postId);
			}
			postId = postId / 3; //Otherwise postId goes up by 3 not by 1
			System.out.println(postId);
			in.nextLine();
			if (option == 1) {
				writer.write(postId + "\n");
			    System.out.println("Please enter your description:");
			    String description = in.nextLine();
			    writer.write(description + "\n");
				System.out.println("Please insert link:");
			    String userPost = in.nextLine();
				writer.write(userPost + "\n");
				writer.close();
				in.close();
			} else if (option == 2) {
				writer.write(postId + "\n");
				writer.write("\n");
				System.out.println("Please insert link:");
			    String userPost = in.nextLine();
				writer.write(userPost + "\n");
				writer.close();
				in.close();			
			} else {
				System.out.println("Please insert 1 or 2");
			}
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("Please insert 1 or 2");
		}
		Path path = Paths.get(".\\post.txt");
		return path;
    }
}

