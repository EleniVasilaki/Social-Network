
public class Delete_post extends Post_code
    public void deletePostMethod(String filepath, int line)
) {
        {
        //creating a temporary file to make changes in
        String tempFile = "tempPost.txt";
        File oldFile = new File(filepath);
        File newFile = new File(tempFile);

        int line = 0;
        String currentLine;

        try
        {   //boolean value true because we are adding to the existing file, not overwriting it
            FileWriter fw = new FileWriter(tempFile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            //while loop continues till there are no more lines to read to the file
            while((currentLine = br.readLine()) !=null)
            {  //line counter
                line++;

                if (deleteline != line)
                {
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
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    }
    
}
