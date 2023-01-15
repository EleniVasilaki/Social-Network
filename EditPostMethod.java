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
public void EditPostMethod(String userID, String postID) {
	Scanner in = new Scanner(System.in);
	boolean flag = false;
	try{
		   ArrayList<String> editArrayList = new ArrayList<String>();
		   LineNumberReader reader = new LineNumberReader(new InputStreamReader(new FileInputStream(".\\post.txt"), "UTF-8"));
		   boolean flg = true;
		   int i = 0;
		   do{
		   		String line = reader.readLine();
		        while (line != null) {
		        	editArrayList.add(line);
		            line = reader.readLine();
		        }

		  			    //show post
		  				if(flg==true){
		  				    if(userId==postArrayList.get(i) && postID==editArrayList.get(i+1)) {
		  					    String description = editArrayList.get(i+2);
		  					    String link = editArrayList.get(i+3);

		  					   System.out.println(description +"\n"+ link);
		  					   while (flag == false) {
							   		String msg2 = "click 1 to edit the description, or click 2 to edit the link";
							   		System.out.println(msg2);
							   		int option = in.nextInt();
							   	    try {
							   			BufferedWriter writer = new BufferedWriter( new FileWriter(".\\post.txt", true));
							   			BufferedReader reader = new BufferedReader(new FileReader(".\\post.txt")
							   			in.nextLine();
							   			if (option == 1) {
							   				writer.write(userID + "\n");
							   				writer.write(postID + "\n");
							   			    System.out.println("Please enter your description:");
							   				description = in.nextLine();
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
							   				link = in.nextLine();
							   				writer.write(userPost + "\n");
							   				writer.close();
							   				in.close();
							   			} else {
							   				System.out.println("Please insert 1 or 2");
							   			}
							   			//the user chooses to exit or to continue editing
							   			System.out.println("Press A to continue editing and B to save and exit");
							   			String ans = in.next();
							   			if (ans == "B") {
							   				flag = true;
							   			} else if (ans == "A"){
							   				System.out.println(msg2);
							   			} else {
							   				System.out.println("Insert A or B")
							   			}
							   			in.close();
									}
		  					        flg==false;
						   }else{
							   i++4;
						   }
				    }while(flg == true)

				}
			}else{
				System.out.println ("Wrong userID or postID")
			}
		}