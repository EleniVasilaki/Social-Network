import java.io.IOException;
import java.util.Scanner;

public class Interface {
    public static int option;
    public static String uid, pid;

    public Interface() {}

    public void selection() {
        Scanner input = new Scanner(System.in);
        option = input.nextInt();
    }

    public void welcomeMenu() throws IOException {
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

    public void mainMenu() throws IOException {
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

    public void profileMenu() throws IOException {
        do {
            System.out.println("""
                    1.1 Edit profile
                    1.2 My posts
                    1.3 Back
                    """);

            selection();

            switch (option) {
                case 1 -> Profile.changeProfile(uid);
                case 2:
                    pid = Post.myPostsMenu();
                case 3 -> mainMenu();
                default -> System.out.println("Wrong input. Please try again");
            }
        } while (option != 1 & option != 2 & option != 3);
    }

    /*
    public void editProfileMenu() {
        do {
            System.out.println("""
                    1.1.1 Change username
                    1.1.2 Change password
                    1.1.3 Change your bio
                    1.1.4 Back
                    """);

            selection();

            switch (option) {
                case 1 -> Profile.changeUsername();
                case 2 -> Profile.changePassword();
                case 3 -> Profile.changeBio();
                case 4 -> profileMenu();
                default -> System.out.println("Wrong input. Please try again");
            }
        } while (option != 1 & option != 2 & option != 3 & option != 4);
    }
    */

    /*
    public void myPostsMenu() throws IOException {
        do {
            System.out.println("""
                1.2.1 Edit
                1.2.2 Delete
                1.2.3 Next post
                1.2.4 Back
                """);

            selection();

            switch (option) {
                case 1 -> Post.EditPostMethod();
                case 2 -> Post.deletePostMethod(pid);
                case 3 -> {
                    Post.nextPost();
                    feedMenu();
                }
                case 4 -> profileMenu();
                default -> System.out.println("Wrong input. Please try again");
            }
        } while (option != 1 & option != 2 & option != 3 & option != 4);
    }
     */

    public void logOut() throws IOException {
        welcomeMenu();
    }
}