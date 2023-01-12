import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

// H upload na kanei extend thn create: mesw methodou ths create na kalw thn upload analoga ean ebale perigrafh h oxi o xrhsths????
public  class CreatePost extends Post_code{
	//public static String path;
	public void createPostMethod(String userID) {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        StringBuilder buffer = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
        	int limitedInt = 97 + (int) (rand.nextFloat() * (97 - 122));
        	buffer.append((char)  limitedInt);
        }
        String postID = buffer.toString();
        //The code above generates PostID
        System.out.println("click 1 to add a description to your post" + "\n" + "click 2 to add text/link for your post");
        int option = in.nextInt();
        try {
			BufferedWriter writer = new BufferedWriter( new FileWriter(".\\post.txt", true));
			BufferedReader reader = new BufferedReader(new FileReader(".\\post.txt"));
			/*long postId = 0;
			String line;
			while ((line = reader.readLine()) != null) {
				postId = postId + 1;
			}
			postId = postId / 3; //Otherwise postId goes up by 3 not by 1 */
			//The hidden code above is for adding increasing numbers as an extra line of each post
			in.nextLine();
			if (option == 1) {
				writer.write(userID + "\n");
				writer.write(postID + "\n");
			    System.out.println("Please enter your description:");
			    String description = in.nextLine();
			    writer.write(description + "\n");
				System.out.println("Please insert link:");
			    String userPost = in.nextLine();
				writer.write(userPost + "\n");
				writer.close();
				in.close();
			} else if (option == 2) {
				writer.write(userID + "\n");
				writer.write(postID + "\n");
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
    }
}


