import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;

public class Post {
    //Create Post Method	
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
    //Edit Method

    public void EditPostMethod(String name, String description, String link) {
		Scanner in = new Scanner(System.in);
		boolean flag = false;
		//the user is shown the text
		try {
			FileReader file = new FileReader(name);
			BufferedReader reader = new BufferedReader(file);
			String line;
			while (( line = reader.readLine()) != null) {
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

			try{
				FileWriter fr = new FileWriter(name);
				BufferedWriter writer = new BufferedWriter(fr);
				if (option == 1) {
					//edits the description
					in.nextLine();
					description = in.nextLine();
					writer.write(description);
				} else if (option == 2) {
					//edits the link
					in.nextLine();
					link = in.nextLine();
					writer.write(link);
				}
				writer.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			//the user is shown the texts after the changes are made
			try {
				FileReader file = new FileReader(name);
				BufferedReader reader = new BufferedReader(file);
				String line;
				while ((line = reader.readLine()) != null) {
					System.out.println(line);
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			//the user chooses to exit or to continue editing
			System.out.println("Press 1 to continue editing and 2 to save and exit");
			int ans = in.nextInt();
			if (ans == 2 ) {
				flag = true;
			} else {
				System.out.println(msg2);
			}
			in.close();
		}
	}

    //Delete Method
    public static void deletePostMethod(String postId, String userId) {
        //creating a temporary file to make changes in
		String filepath = ".\\post.txt"
        String tempFile = "tempPost.txt";
        File oldFile = new File(filepath);
        File newFile = new File(tempFile);

        String currentLine;
        int line = 0;


        try
		{   //boolean value true because we are adding to the existing file, not overwriting it
            // creating objects to read and write to the file
            FileWriter fw = new FileWriter(tempFile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            //while loop continues till there are no more lines to read to the file
			
            while((currentLine = br.readLine()) !=null)
            {   
                System.out.println("Reading Line " + line);
                line++;

                if (currentLine.contains(userId))
				{    
					String l = Integer.toString(line);
		
				    if (l.contains(postid)) {

                        System.out.println("Found Post with ID " + postId);
                        // Don't copy these 4 lines in the new file
                        br.readLine();
                        br.readLine();
                        br.readLine();
                        br.readLine();
                   }
				}
                else
                {
                  // Copy the original line to the new file since we don't want to delete this
                  pw.println(currentLine);
                }
            
            }

            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();

            oldFile.delete();
            File dump = new File(filepath);
            newFile.renameTo(dump);
            //System.out.println("New file created");
        }  catch(Exception e){
            System.out.println(e);
        }
    }

	//nextPost method
	public void nextPost(String userId) {

         Scanner scanner = new Scanner(System.in);
		 List<String> postArrayList = new ArrayList<String>();
		 LineNumberReader reader = new LineNumberReader(new InputStreamReader(new FileInputStream(".\\post.txt"), "UTF-8"));
        try{
            do{

                // read entire line as string
                String line = reader.readLine();
       
                // checking for end of file
                while (line != null) {
                    postArrayList.add(line);
                    line = reader.readLine();
                }
            
			    //show first post
			    for (int i= 0; i<postArrayList.size(); i++) {
				    if(userId==postArrayList.get(i)) {
					    String firstpostdes = postArrayList.get(i+2);
					    String firstpostlink = postArrayList.get(i+3);

					   System.out.println(firstpostdes +"\n"+ firstpostlink);
					   break;
				    }

			    }
			        //show next post
			
                do{
			    System.out.println("Type 1 if you want to see next post")
			    answer = scanner.nextInt();
					int j=i+4; 

					String nextpostdes = postArrayList.get(j+2);
					String nextpostlink = postArrayList.get(j+3);

					System.out.println(nextpostdes +"\n"+ nextpostlink);

					j=j+4

				} while(answer!=1)
	   

	}while()
	} catch(Exception e) {
            System.out.println(e);
	}
}
