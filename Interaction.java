import java.io.*;
import java.util.*;

public class Interaction {
    // Initialising interaction and id and other attributes for our comment object.
    boolean like, comment, share, report;
    static int id;

    // Creating method that reads the interactions data from the interactions-data.txt database file.
    public static void readdata() {
        try {
            File myObj = new File("interaction-data.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] myArray = data.split(",");
                Interaction inter = new Interaction(myArray[0], Integer.parseInt(myArray[1]), myArray[2], myArray[3], myArray[4], myArray[5]);
                id = ids.size();
                MyFrame.pats.add(inter);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred. \n");
            e.printStackTrace();
        }
    }

    // These are arraylists in which we are going to input our interactions,ids and other info.
    static ArrayList<Integer> ids = new ArrayList<>();
    static ArrayList<ArrayList<Boolean>> likes = new ArrayList<>();
    static ArrayList<ArrayList<Boolean>> comments = new ArrayList<>();
    static ArrayList<ArrayList<Boolean>> shares = new ArrayList<>();
    static ArrayList<ArrayList<Boolean>> reports = new ArrayList<>();


    // Interaction object constructor.
    public Interaction(String comment, int id, String share, String like, String report) {
        this.comment = comment;
        this.id = id;
        this.share = share;
        this.like = like;
        this.report = report;
        // Adding interaction attributes to arraylists.
        ids.add(id);
        comments.add(comment);
        shares.add(share);
        likes.add(like);
        reports.add(report);
    }

    // Simple toString to return id.
    public int getId() {
        return id;
    }

    // Returning comment
    public String getComment() {
        return comment;
    }

    // Custom toString that return full id + name.
    public String getInteraction() {
        return "Comment: " + comment + "\nID: " + id;
    }

    // Custom toString that returns all interaction's attributes
    public String getInteractionData() {
        return "Comment: " + comment + "\nLike: " + like
                + "\nShare: " + share + "\nReport: " + report
                + "\n";
    }

    // Function that returns all interaction comments in a nice format.
    public static String allCommments() {
        String c = "";
        for (int i = 0; i <= comments.size() - 1; i++) {
            c += "ID: " + i + " Comment: " + comments.get(i) + "\n \n";
        }
        return c;
    }

    // Method  that returns all interactions data in a nice format.
    public static void allData() {
        for (int i = 0; i <= comments.size() - 1; i++) {
            System.out.println("ID: " + i + " Comment: " + comments.get(i) + "\nShare: " + shares.get(i) + " Likes: " + likes.get(i)
                    + "\nReport: " + reports.get(i));
        }
    }

    // Static method that returns arraylist of comments.
    public static ArrayList<String> returnComments() {
        return comments;
    }

    // Static method that returns arraylist of Ids.
    public static ArrayList<Integer> returnIds() {
        return ids;
    }

    // Static method that returns arraylist of shares.
    public static ArrayList<String> returnShares() {
        return shares;
    }

    // Static method that returns arraylist of date of likes.
    public static ArrayList<String> returnLikes() {
        return likes;
    }

    // Static method that returns arraylist of date of reports.
    public static ArrayList<String> returnReports() {
        return reports;
    }

    // Checks if the post (pid) is liked by any given user (uid) in 2D ArrayList<Boolean> likes.
    public static void addLike(int uid, int pid) {
        if (!likes.get(returnSeat(uid, "users.txt")).get(returnSeat(pid, "post.txt"))) {
                likes.get(returnSeat(uid, "users.txt")).set(pid, true);
                System.out.println("Post liked!");
        } else {
            likes.get(returnSeat(uid, "users.txt")).set(pid, false);
            System.out.println("Like removed from post.");
        }
    }

    // Sum up the number of likes that a post (pid) has got based on the number of "true" indexes.
    public static int likes(List<List<Boolean>> likes, int pid) {
        int counter = 0, numOfLikes = 0;

        for (int i = 0; i < likes.get(pid).size(); i++) {
            if (likes.get(i).get(pid))
                counter += 1;
        }
        numOfLikes += counter;

        return numOfLikes;
    }

    public static void addComment(int uid) {
        System.out.print("Post a comment: ");
        Scanner comment = new Scanner(System.in);
        String input = comment.nextLine();
        comments.add(input);
        System.out.println(input);
    }

    public static void sharePost() {
        return User.uid + " shared: " + Post.id;
    }

    public static void addReport(int uid) {
        if (!reports.get(returnSeat(uid, "users.txt"))) {
            likes.set(returnSeat(uid, "users.txt"), true);
            System.out.println("Post reported!");
        } else
            System.out.println("Post already reported!");
    }

    // This method reads the data from users.txt and return the number the of the line from the given id and file.
    public static int returnSeat(int id, String file) {
        int lines = 0, seat = 0; // The seat (the number of line) where the ID is found.
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                lines++;
                String[] column = line.split(";");
                if (id == Integer.parseInt(column[0])) {
                    seat = lines;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return seat;
    }
}
