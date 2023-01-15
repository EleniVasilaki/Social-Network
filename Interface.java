import java.io.IOException;
import java.util.Scanner;

public class Interface {
    public static int option;
    public static String uid;

    public static void selection() {
        Scanner input = new Scanner(System.in);
        option = input.nextInt();
    }

    public static void welcomeMenu() throws IOException {
        do {
            System.out.println("""
                    1. Register
                    2. Login
                    """);

            selection();

            switch (option) {
                case 1:
                    uid = SignUp.signUp();
                    mainMenu();
                case 2:
                    uid = Login.login();
                    mainMenu();
                default: System.out.println("Wrong input. Please try again");
            }
        } while (option != 1 & (option != 2));
    }

    public static void mainMenu() throws IOException {
        do {
            System.out.println("""
                    1. Profile
                    2. Feed
                    3. Create post
                    4. Log out
                    """);

            selection();

            switch (option) {
                case 1 -> profileMenu();
                case 2 -> Feed.feedMethod(uid);
                case 3 -> Post.createPostMethod(uid);
                case 4 -> logOut();
                default -> System.out.println("Wrong input. Please try again");
            }
        } while (option != 1 & option != 2 & option != 3 & option != 4);
    }

    public static void profileMenu() throws IOException {
        do {
            System.out.println("""
                    1.1 Edit profile
                    1.2 My posts
                    1.3 Back
                    """);

            selection();

            switch (option) {
                case 1 -> Profile.changeProfile(uid);
                case 2 -> Post.myPostsMenu(uid);
                case 3 -> mainMenu();
                default -> System.out.println("Wrong input. Please try again");
            }
        } while (option != 1 & option != 2 & option != 3);
    }

    public static void logOut() throws IOException {
        welcomeMenu();
    }
}