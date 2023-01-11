
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.PrintWriter;
import java.io.*;

public class DeletePost {

	public static void main (String[] args) {
	        deletePostMethod("post.txt","MWV]SO[UL");
    }

    public static void deletePostMethod(String filepath, String postId) {
        //creating a temporary file to make changes in
        String tempFile = "tempPostId_data.txt";
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
                if (currentLine.contains(postId)) 
                {
                    System.out.println("Found Post with ID " + postId);
                    // Don't copy these 4 lines in the new file
                    br.readLine();
                    br.readLine();
                    br.readLine();
                    br.readLine();
                }
                else
                {
                  // Copy the original line to the new file since we don't want to delete this
                  pw.println(currentLine);
                }
                //line counter
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
}
