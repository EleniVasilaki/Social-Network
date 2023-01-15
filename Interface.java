import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Interface {
    public static String uid;

    public static int selection() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                return input.nextInt();
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Error: Please enter a valid integer.");
            }
        }
    }

    public static void welcomeMenu() throws IOException {
        int option;
        do {
            System.out.println("""
                    1. Register
                    2. Login
                    """);

            option = selection();

            switch (option) {
                case 1:
                    uid = SignUp.signUp();
                    mainMenu();
                    break;
                case 2:
                    uid = Login.login();
                    mainMenu();
                    break;
                default:
                    System.out.println("Wrong input. Please try again");
            }
        } while (option != 1 && (option != 2));
    }

    public static void mainMenu() throws IOException {
        int option;
        do {
            System.out.println("""
                    1. Profile
                    2. Feed
                    3. Create post
                    4. Log out
                    """);

            option = selection();

            switch (option) {
                case 1:
                    profileMenu();
                    break;
                case 2:
                    Feed.feedMethod(uid);
                    break;
                case 3:
                    Post.createPostMethod(uid);
                    break;
                case 4:
                    logOut();
                    break;
                default:
                    System.out.println("Wrong input. Please try again");
            }
        } while (option != 1 && option != 2 && option != 3 && option != 4);
    }
    
    public static void profileMenu() throws IOException {
        Post obj = new Post();
        int option;
        do {
            System.out.println("""
                    1.1 Edit profile
                    1.2 My posts
                    1.3 Back
                    """);

            option = selection();

            switch (option) {
                case 1:
                    Profile.changeProfile(uid);
                    break;
                case 2:
                    obj.myPostsMenu(uid);
                    break;
                case 3:
                    mainMenu();
                    break;
                default:
                    System.out.println("Wrong input. Please try again");
            }
        } while (option != 1 && option != 2 && option != 3);
    }

    public static void logOut() throws IOException {
        System.out.println("You have been logged out!");
        welcomeMenu();
    }
}