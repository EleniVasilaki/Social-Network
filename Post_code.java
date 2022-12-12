import java.util.Scanner;

public class Post_code {
	public void num_of_choice () {
		Scanner input = new Scanner(System.in);
		System.out.println("click 1 to create a post" + "\n" + "click 2 to delete an owned post" + "\n" + "click 3 to edit an owned post");
		int number = input.nextInt();
		Create_Post a = new Create_Post();
   	 	if (number == 1) {
			a.createPostMethod();
		}
	}
}