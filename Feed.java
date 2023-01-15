import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Feed {
   	
	static boolean firstTime = true;
   	
    public static void feedMethod (String userID) {	

		Interface interf = new Interface();

    	try {
    		
        	boolean flag = false;
        	LineNumberReader reader = new LineNumberReader(new InputStreamReader(new FileInputStream(".\\post.txt"), "UTF-8"));
        	ArrayList<String> listOfStrings = new ArrayList<String>();
        	int i = 3;
        	
        	do {       
       			String strLine;
       			String postID = null;
               
       			while((strLine = reader.readLine()) != null) {
       				listOfStrings.add(strLine);
       			}
       			
        		listOfStrings.add(null);
        		
       			if (firstTime == true) {			//First post is shown here
       				System.out.println(listOfStrings.get(i - 1) + "\n" + listOfStrings.get(i) + "\n");  
       				postID = listOfStrings.get(i - 2);
        			firstTime = false;
        		}
        		
       			System.out.println("1. Next post \n" + "2. Previous post \n"
       					+ "3. Like \n" + "4. See number of likes \n" + "5. Go back \n");
       			
        		Scanner in = new Scanner(System.in);
               
        		int option = in.nextInt(); 
				int numOfLikes;
       			flag = true;
       			
       			if (option == 1) {       		//Next Post Code		
       				i += 4; 
       				postID = listOfStrings.get(i - 2);
       				System.out.println(listOfStrings.get(i - 1) + "\n" + listOfStrings.get(i) + "\n");
       				
       				if (listOfStrings.get(i + 1) == null) {       					
       					System.out.println("You have reached the end of the feed \n" + "Sending you back to the start of the feed \n");
       					firstTime = true;
       					throw new NullPointerException();       					
       				} 
       				
       			} else if (option == 2) {			//Previous Post Code
       				i -= 4;
       				
       				if (i <= -1) {      					
       					System.out.println("Previous posts don't exist \n");  
       					
       				} else {
           				System.out.println(listOfStrings.get(i - 1) + "\n" + listOfStrings.get(i) + "\n");	
       				}

       			} else if (option == 3) {     		//Like Code		
       				System.out.println(postID);
        			Interaction.like(userID, postID); 
        			System.out.println("You liked the post \n");
        			
       			} else if (option == 4) {			//Count of Likes Code
					numOfLikes = Interaction.likes(postID); 
       				System.out.println("Number of likes :" + numOfLikes + "\n");
       				
       			} else if (option == 5) {   
					interf.mainMenu();    	// Go Back Code			
       				flag = false; 
       				
        		} else {       						//Wrong Input Code
        			System.out.println("Please enter 1, 2, 3, 4 or 5 \n");       			
        		}

        	} while (listOfStrings.get(i + 1) != null && flag == true);
        	reader.close();
        	
    	} catch (Exception e) {
        	feedMethod(userID);
    	}
    } 
}
