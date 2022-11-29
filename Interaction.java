import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Date;
import java.lang.Math;

public class Interaction {
    // Initialising interaction and id and other attributes for our comment object.
    String comment;
    String like;
    String share;
    String report;
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
    static ArrayList<String> comments = new ArrayList<>();
    static ArrayList<String> shares = new ArrayList<>();
    static ArrayList<String> likes = new ArrayList<>();
    static ArrayList<String> reports = new ArrayList<>();


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

    public void addComment() {
        System.out.print("Post a comment: ");
        Scanner comment = new Scanner(System.in);
        String input = comment.nextLine();

        comments.add(input);
        System.out.println(input);
    }


    public void addLike() {
        if (!likes.contains(User.uid)) {
            likes.add(User.uid);
            like++;
            System.out.println("Post liked!");
        } else {
            likes.remove(User.uid);
            like--;
            System.out.println("Like removed!");
        }
    }

    public String sharePost() {
        return User.uid + " shared: " + Post.id;
    }

    public void addReport() {
        if (!report.contains(User.uid)) {
            reports.add(User.uid);
            report++;
            System.out.println("Report has been successfully submitted!");
        } else {
            System.out.println("You have already submitted a report!");
        }
    }
}
