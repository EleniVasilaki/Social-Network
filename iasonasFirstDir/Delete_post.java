
public class Delete_post extends Post_code
    public void deletePostMethod(String filepath, int postId)
) {
        {
        //creating a temporary file to make changes in
        String tempFile = "tempPostId_data.txt";
        File oldFile = new File(filepath);
        File newFile = new File(tempFile);

        String currentLine;
        int line = 0
        
        
        try
        {   //boolean value true because we are adding to the existing file, not overwriting it
            // creating objects to read and write to the file
            FileWriter fw = new FileWriter(tempFile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            //while loop continues till there are no more lines to read to the file
            while((currentLine = br.readLine()) !=null)  { 
                if (currentLine.contains(postId)) {
                    while (line != null) {
                        if ((currentLine != line) & ((currentLine + 1) != line) & ((currentLine + 2) != line)){
                        pw.println(line);
                        }
                    }
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
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    }
    
}
