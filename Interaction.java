import java.io.*;
import java.util.*;

public class Interaction {
    public static void checkInteractions(int uid, int pid) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("interactions.txt"));
            String line;
            boolean found = false;
            // Checks if any interaction by any user has ever happened in any post.
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (Integer.parseInt(values[0]) == uid && Integer.parseInt(values[1]) == pid) {
                    found = true;
                    break;
                }
            }
            br.close();
            // If it hasn't, it sets the interactions to false.
            if (!found) {
                BufferedWriter bw = new BufferedWriter(new FileWriter("interactions.txt", true));
                bw.write(uid + "," + pid + ",false," + "" + ",false,false");
                bw.newLine();
                bw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void like(int uid, int pid) {
        checkInteractions(uid, pid);
        try {
            BufferedReader br = new BufferedReader(new FileReader("interactions.txt"));
            String line;
            StringBuilder fileContent = new StringBuilder();
            boolean found = false;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (Integer.parseInt(values[0]) == uid && Integer.parseInt(values[1]) == pid && values[2].equals("false")) {
                    found = true;
                    line = uid + "," + pid + ",true," + values[3] + "," + values[4] + "," + values[5];
                    System.out.println("Post successfully liked!");
                }
                fileContent.append(line);
                fileContent.append(System.lineSeparator());
            }
            br.close();
            if (found) {
                FileWriter fw = new FileWriter("interactions.txt");
                fw.write(fileContent.toString());
                fw.close();
            } else {
                System.out.println("You have already liked this post.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Counts how many times a post (pid) has been liked.
    public static int likes(int pid) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("interactions.txt"));
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (Integer.parseInt(values[1]) == pid && values[2].equals("true")) {
                    count++;
                }
            }
            br.close();
            return count;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void comment(int uid, int pid) {
        checkInteractions(uid, pid);
        try {
            BufferedReader br = new BufferedReader(new FileReader("interactions.txt"));
            String line;
            StringBuilder fileContent = new StringBuilder();
            boolean found = false;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (Integer.parseInt(values[0]) == uid && Integer.parseInt(values[1]) == pid && (values[3].equals("") || !values[3].equals(""))) {
                    found = true;

                    System.out.println("Post a comment:");
                    Scanner in = new Scanner(System.in);
                    String comment = in.nextLine();

                    line = uid + "," + pid + "," + values[2] + "," + comment + "," + values[4] + "," + values[5];
                }
                fileContent.append(line);
                fileContent.append(System.lineSeparator());
            }
            br.close();
            if (found) {
                FileWriter fw = new FileWriter("interactions.txt");
                fw.write(fileContent.toString());
                fw.close();
            } else {
                System.out.println("New comment added!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Counts how many comments a post (pid) has got.
    public static int comments(int pid) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("interactions.txt"));
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (Integer.parseInt(values[1]) == pid && !values[3].equals("")) {
                    count++;
                }
            }
            br.close();
            return count;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void sharePost(int uid, int pid) {
        checkInteractions(uid, pid);
        try {
            BufferedReader br = new BufferedReader(new FileReader("interactions.txt"));
            String line;
            StringBuilder fileContent = new StringBuilder();
            boolean found = false;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (Integer.parseInt(values[0]) == uid && Integer.parseInt(values[1]) == pid && values[2].equals("false")) {
                    found = true;
                    line = uid + "," + pid + "," + values[2] + "," + values[3] + ",true," + values[5];
                    System.out.println("You shared the post #" + pid);
                }
                fileContent.append(line);
                fileContent.append(System.lineSeparator());
            }
            br.close();
            if (found) {
                FileWriter fw = new FileWriter("interactions.txt");
                fw.write(fileContent.toString());
                fw.close();
            } else {
                System.out.println("Post already shared");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int shares(int pid) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("interactions.txt"));
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (Integer.parseInt(values[1]) == pid && !values[4].equals("true")) {
                    count++;
                }
            }
            br.close();
            return count;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void report(int uid, int pid) {
        checkInteractions(uid, pid);
        try {
            BufferedReader br = new BufferedReader(new FileReader("interactions.txt"));
            String line;
            StringBuilder fileContent = new StringBuilder();
            boolean found = false;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (Integer.parseInt(values[0]) == uid && Integer.parseInt(values[1]) == pid && values[2].equals("false")) {
                    found = true;
                    line = uid + "," + pid + "," + values[2] + "," + values[3] + "," + values[4] + ",true";
                    System.out.println("Post #" + pid + " successfully reported!");
                }
                fileContent.append(line);
                fileContent.append(System.lineSeparator());
            }
            br.close();
            if (found) {
                FileWriter fw = new FileWriter("interactions.txt");
                fw.write(fileContent.toString());
                fw.close();
            } else {
                System.out.println("Post already reported!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int reports(int pid) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("interactions.txt"));
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (Integer.parseInt(values[1]) == pid && !values[5].equals("true")) {
                    count++;
                }
            }
            br.close();
            return count;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
