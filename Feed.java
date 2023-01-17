import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;

public class Feed {

    public static void feedMethod (String userID) {	
		boolean firstTime = true;
		System.out.println("Feed:");
    	try {
    		
        	boolean flag = false;
        	LineNumberReader reader = new LineNumberReader(new InputStreamReader(new FileInputStream(".\\post.txt"), "UTF-8"));
        	ArrayList<String> listOfStrings = new ArrayList<String>();
        	int i = 3;
			String strLine;
			String postID = null;
			while((strLine = reader.readLine()) != null) {
				listOfStrings.add(strLine);
			}
			
		 	listOfStrings.add(null);
        	
        	do {       
				
	
       			if (firstTime == true) {			//First post is shown here
       				System.out.println(listOfStrings.get(i - 1) + "\n" + listOfStrings.get(i) + "\n");  
       				postID = listOfStrings.get(i - 2);
        			firstTime = false;
        		}
        		
       			System.out.println("1. Next post \n" + "2. Previous post \n"
       					+ "3. Like \n" + "4. See number of likes \n" + "5. Report\n" + "6. See Reports\n" + "7. Go back \n");
               
        		int option = Interface.input.nextInt(); 
				int numOfLikes;
				int report;
       			flag = true;
       			
       			if (option == 1) {       		//Next Post Code		
       				i += 4; 
       				postID = listOfStrings.get(i - 2);
       				System.out.println(listOfStrings.get(i - 1) + "\n" + listOfStrings.get(i) + "\n");
       				
       				if (listOfStrings.get(i + 1) == null) { 
						System.out.println("You have reached the end of the feed \n");

						do {  					
      	 					System.out.println("1: Like \n" + "2. See number of likes \n" + "3. Report\n" + "4. See reports\n" + "5. Go back\n"); 
							option = Interface.input.nextInt();	
							if (option == 1) {     		//Like Code		

							 Interaction.like(userID, postID); 
								
							} else if (option == 2) {			//Count of Likes Code
								numOfLikes = Interaction.likes(postID); 
								System.out.println("Number of likes :" + numOfLikes + "\n");

							} else if (option == 3) {        //Report Code
								Interaction.report(userID, postID);
			
							} else if (option == 4) {			//Count of Reports Code
								report = Interaction.reports(postID);
								System.out.println("Number of reports: " + report);
							} else if (option != 5){
								System.out.println("Please enter 1, 2, 3, 4 or 5");
							}
						} while( option != 5);
						Interface.mainMenu(); 
					}
       				
       			} else if (option == 2) {			//Previous Post Code
       				i -= 4;
       				
       				if (i <= -1) {      					
       					System.out.println("Previous posts don't exist \n");  
       					
       				} else {
           				System.out.println(listOfStrings.get(i - 1) + "\n" + listOfStrings.get(i) + "\n");	
       				}

       			} else if (option == 3) {     		//Like Code		

        			Interaction.like(userID, postID); 
						
       			} else if (option == 4) {			//Count of Likes Code
					numOfLikes = Interaction.likes(postID); 
       				System.out.println("Number of likes :" + numOfLikes + "\n");

				} else if (option == 5) {        //Report Code
					Interaction.report(userID, postID);

				} else if (option == 6) {			//Count of Reports Code
					report = Interaction.reports(postID);
					System.out.println("Number of reports: " + report);

				} else if (option == 7) {   
					Interface.mainMenu();    	// Go Back Code			
       				flag = false; 
       				
        		} else {       						//Wrong Input Code
        			System.out.println("Please enter 1, 2, 3, 4, 5, 6 or 7\n");       			
        		}

        	} while (listOfStrings.get(i + 1) != null && flag == true);
        	reader.close();

        	
    	} catch (Exception e) {
			System.out.println("Please enter 1, 2, 3, 4 or 5 \n"); 
        	feedMethod(userID);
    	}
    } 
}
