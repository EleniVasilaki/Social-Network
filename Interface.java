import java.io.IOException;
import java.util.Scanner;

public class Interface {

    public static String uid;
    static Scanner input = new Scanner(System.in);

    public static void welcomeMenu() throws IOException {
        int option;
        SignUp su = new SignUp();

        do {
            System.out.println("""
                    1. Signup
                    2. Login
                    """);

            option = Interface.input.nextInt();

            switch (option) {
                case 1:
                    uid = su.signUp();
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
        Post post = new Post();
        do {
            System.out.println("""
                    1. Profile
                    2. Feed
                    3. Create post
                    4. Log out
                    """);

           option = Interface.input.nextInt();

            switch (option) {
                case 1:
                    profileMenu();
                    break;
                case 2:
                    Feed.feedMethod(uid);
                    break;
                case 3:
                    post.createPostMethod(uid);
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
            Profile.viewProfile(uid);
            
            System.out.println("""
                    1. Edit profile
                    2. Change username
                    3. Change password
                    4. My posts
                    5. Back
                    """);

            option = Interface.input.nextInt();

            switch (option) {
                case 1:
                    Profile.changeProfile(uid);
                    break;
                case 2:
                    Profile.changeUsername(uid);
                    break;
                case 3:
                    Profile.changePassword(uid);
                    break;
                case 4:
                    obj.myPostsMenu(uid);
                    break;
                case 5:
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