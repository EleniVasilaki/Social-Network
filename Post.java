import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.File;

public class Post {
    //Create Post Method	
	public void createPostMethod(String userID) {

        Random rand = new Random();
        StringBuilder buffer = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
        	int limitedInt = 97 + (int) (rand.nextFloat() * (97 - 122));
        	buffer.append((char)  limitedInt);
        }
        String postID = buffer.toString();
        //The code above generates PostID
        System.out.println("1. Add description" + "\n" + "2. Add text/link");
        int option = Interface.input.nextInt();
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
			Interface.input.nextLine();
			if (option == 1) {

				writer.write(userID + "\n");
				writer.write(postID + "\n");
			    System.out.println("Please enter your description:");
			    String description = Interface.input.nextLine();
			    writer.write(description + "\n");
				System.out.println("Please insert link:");
			    String userPost = Interface.input.nextLine();
				writer.write(userPost + "\n");
				writer.close();

			} else if (option == 2) {

				writer.write(userID + "\n");
				writer.write(postID + "\n");
				writer.write("\n");
				System.out.println("Please insert link:");
			    String userPost = Interface.input.nextLine();
				writer.write(userPost + "\n");
				writer.close();	
					
			} else {
				System.out.println("Please enter 1 or 2");
			}
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("Please enter 1 or 2");
		}
		try {
			Interface.mainMenu();
		} catch (IOException e) {
			System.out.println("error on mainMenu");
		}	
    }
    //Edit Method
	
    public void editPostMethod(String userId, String postId){
		
	    try{
            ArrayList<String> editArrayList = new ArrayList<String>();
            LineNumberReader reader = new LineNumberReader(new InputStreamReader(new FileInputStream(".\\post.txt"), "UTF-8"));
		    String line;
			boolean flag = false;
            int i = 0;
            while((line = reader.readLine()) != null) {
       	        editArrayList.add(line);
       	    }
			reader.close();

            do{

                if(userId.equals(editArrayList.get(i)) && postId.equals(editArrayList.get(i+1))){
					flag = true;
                    System.out.println("1: Edit description \n" + "2: Edit link \n");

                    int option = Interface.input.nextInt();

                    if(option == 1){
                        System.out.println("Please enter new description for your post");
                        String des = Interface.input.next();
                        editArrayList.set(i+2, des);
						try {
							File oldfile = new File(".\\post.txt");
							File newfile = new File("newpost.txt");
							BufferedWriter writer = new BufferedWriter( new FileWriter("newpost.txt", true));
					
							for(String str: editArrayList) {
								writer.write(str + System.lineSeparator());
							   }
							writer.close();
							oldfile.delete();
							File dump = new File(".\\post.txt");
							newfile.renameTo(dump);
							System.out.println("New file created");
						} catch (IOException e) {
							System.out.println("An error occurred.");
							e.printStackTrace();
						}
						Interface.mainMenu();
                    } else if(option == 2){
                        System.out.println("Please enter new link for your post");
                        String link = Interface.input.next();
                        editArrayList.set(i+3, link);
						try {
							File oldfile = new File(".\\post.txt");
							File newfile = new File("newpost.txt");
							BufferedWriter writer = new BufferedWriter( new FileWriter("newpost.txt", true));
					
							for(String str: editArrayList) {
								writer.write(str + System.lineSeparator());
							}
							writer.close();
							oldfile.delete();
							File dump = new File(".\\post.txt");
							newfile.renameTo(dump);
							System.out.println("New file created");
						} catch (IOException e) {
							System.out.println("An error occurred.");
							e.printStackTrace();
						}
						Interface.mainMenu();
                    } else {
                        System.out.println("Wrong input. Please enter 1 or 2 \n");
						throw new IOException();
                    }

				}
                i = i + 4;
            } while(editArrayList.get(i+4) != null || flag == true/*&& editArrayList.get(i) == userId && editArrayList.get(i+1) == postId */);

        } catch (IOException e) {
			editPostMethod(userId, postId);
        }
		Post p = new Post();
		p.myPostsMenu(userId);
    }
	
	//Delete Method
    public static void deletePostMethod(String postId, String userId) {
        //creating a temporary file to make changes in
		String filepath = ".\\post.txt";
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
		
				    if (l.contains(postId)) {

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
            System.out.println("An error has occurred.");

        }
		Post p = new Post();
		p.myPostsMenu(userId);
    }

	//nextPost method
	public void myPostsMenu(String userId) {

		try {
//new
			LineNumberReader reader = new LineNumberReader(new InputStreamReader(new FileInputStream(".\\post.txt"), "UTF-8"));
        	ArrayList<String> listOfStrings = new ArrayList<String>();
			int i = 0;
			String strLine;
			boolean first = true;
			boolean flag = false;
			while((strLine = reader.readLine()) != null) {
				listOfStrings.add(strLine);
			}
		 	listOfStrings.add(null);
			
			//Print first post
			while(listOfStrings.get(i) != null && first == true) {

				if( listOfStrings.get(i).equals(userId) ) {
					first = false;
					System.out.println(listOfStrings.get(i + 2) + "\n" + listOfStrings.get(i + 3));
				}
				i += 4;
			}
			if (first == false) {
				do {
					flag = false;
					System.out.println("1. Edit post \n" + "2. Delete post \n" + "3. Next Post \n" + "4. Go back to profile \n");
					int answer = Interface.input.nextInt();
					if (answer == 1) {
						editPostMethod(userId, listOfStrings.get(i - 3));					
					} else if (answer == 2) {
						deletePostMethod(userId, listOfStrings.get(i - 3));
					} else if (answer == 3) {

						while(listOfStrings.get(i) != null && flag == false) {

							if( listOfStrings.get(i).equals(userId) ) {
								System.out.println(listOfStrings.get(i + 2) + "\n" + listOfStrings.get(i + 3));
								flag = true;
							}
							i += 4;
						}
						if (listOfStrings.get(i) == null) {
							System.out.println("You have reached the end of your posts\n" + "Sending you back to your first post \n");
							myPostsMenu(userId);
						}
					} else if (answer == 4) {
						Interface.profileMenu();
					} else {
						System.out.println("Wrong input. Please enter 1, 2, 3 or 4 \n");
						myPostsMenu(userId);
					}
				} while (flag == true);
				
			} else {
				System.out.println("You dont have any posts");
				try {
					Interface.profileMenu();
				} catch (IOException e) {
				}
			}

		} catch (Exception e) {

		}
	}
}
// new
		/*try{
            
		    List<String> postArrayList = new ArrayList<String>();
		    LineNumberReader reader = new LineNumberReader(new InputStreamReader(new FileInputStream(".\\post.txt"), "UTF-8"));
			// read entire line as string
			String line = null;
			boolean first = false; //Becomes true if user has any posts
			boolean flag = true;
			int i = 0;
			String postid = null;
			String postdes;
			String postlink;

			// Arraylist with users posts
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				System.out.println(userId);
				if (line == userId) {
					
					for (int j = 0; j == 3; j++ ) {
						postArrayList.add(line);
						line = reader.readLine();
						first = true; //Tests if user has any posts at all
					}
				} else {

					for (int k = 0; k == 3; k++ ) {
						line = reader.readLine();
					}
				}	
			}
			postArrayList.add(line); //So i can check if there are no more posts (I need the last shell to be empty)

			if (first == true) {
				do {
					//show first post
					if (first == true) { //First now has another use, it allows the commands below to exeute only once
						if (userId == postArrayList.get(i)) {
							postid = postArrayList.get(i + 1);
							postdes = postArrayList.get(i + 2);
							postlink = postArrayList.get(i + 3);
	
							System.out.println(postdes + "\n" + postlink);
							first = false;
						}
					}
					System.out.println("1. Edit post \n" + "2. Delete post \n" + "3. Next Post \n" + "4. Go back to profile \n");
					int answer = Interface.input.nextInt();
	
					if (answer == 1) {
						editPostMethod(userId, postid);
					} else if (answer == 2) {
						deletePostMethod(userId, postid);
					} else if (answer == 3) {

						if (postArrayList.get(i + 4) == null) {       					
							System.out.println("You have reached the end of your posts\n" + "Sending you back to your first post \n");
							myPostsMenu(userId);
						} else {
							i = i + 4;
							postid = postArrayList.get(i + 1);
							postdes = postArrayList.get(i + 2);
							postlink = postArrayList.get(i + 3);
		
							System.out.println(postdes + "\n" + postlink);
						}

					} else if(answer==4) { //Go back
						Interface.profileMenu();
						flag = false;
					} else { //wrong input
						System.out.println("Wrong input. Please enter 1, 2, 3 or 4 \n");
						myPostsMenu(userId);
					}
	
				} while (postArrayList.get(i + 4) != null && flag == true);
				reader.close();

			} else {
				System.out.println("You have no posts");
			}

		} catch (Exception e) {
			System.out.println("An error has occurred.");
		}
		try {
			Interface.profileMenu();
		} catch (IOException e) {

		}
	}
} */
