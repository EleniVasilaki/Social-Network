import java.util.Scanner;

public class Interface {
    public static int option;

    public static void selection() {
        Scanner input = new Scanner(System.in);
        option = input.nextInt();
    }

    public void welcomeMenu() {
        do {
            System.out.println("""
                    1. Register
                    2. Login
                    """);

            selection();

            switch (option) {
                case 1:
                    SignIn.signIn();
                    mainMenu();
                case 2:
                    Login.logIn();
                    mainMenu();
                default: System.out.println("Wrong input. Please try again");
            }
        } while (option != 1 & (option != 2));
    }

    public void mainMenu() {
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
                case 2 -> {
                    Post.allPosts();
                    feedMenu();
                }
                case 3 -> CreatePost.createPostMethod();
                case 4 -> {
                    User.logOut();
                    welcomeMenu();
                }
                default -> System.out.println("Wrong input. Please try again");
            }
        } while (option != 1 & option != 2 & option != 3 & option != 4);
    }

    public void profileMenu() {
        do {
            System.out.println("""
                    1.1 Edit profile
                    1.2 My posts
                    1.3 Back
                    """);

            selection();

            switch (option) {
                case 1 -> Profile.changeProfile(userId);
                case 2 -> myPostsMenu();
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

    public void myPostsMenu() {
        do {
            System.out.println("""
                1.2.1 Edit
                1.2.2 Delete
                1.2.3 Next post
                1.2.4 Back
                """);

            selection();

            switch (option) {
                case 1 -> Post.editPost();
                case 2 -> Post.deletePostMethod();
                case 3 -> {
                    Post.nextPost();
                    feedMenu();
                }
                case 4 -> profileMenu();
                default -> System.out.println("Wrong input. Please try again");
            }
        } while (option != 1 & option != 2 & option != 3 & option != 4);
    }

    public void feedMenu() {
        do {
            System.out.println("""
                2.1 Like
                2.2 Comment
                2.3 Share
                2.4 Report
                2.5 Next post
                2.6 Back
                """);

            selection();

            switch (option) {
                case 1 -> Interaction.addLike();
                case 2 -> Interaction.addComment();
                case 3 -> Interaction.sharePost();
                case 4 -> Interaction.addReport();
                case 5 -> {
                    Post.nextPost();
                    feedMenu();
                }
                case 6 -> mainMenu();
                default -> System.out.println("Wrong input. Please try again");
            }
        } while (option != 1 & option != 2 & option != 3 & option != 4 & option != 5 & option != 6);
    }
}