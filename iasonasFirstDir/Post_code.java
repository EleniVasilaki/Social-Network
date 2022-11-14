import java.util.Scanner;

public class Post_code {
	public static int num_of_choice () {
		Scanner input = new Scanner(System.in);
		System.out.println("click 1 to create a post" + "\n" + "click 2 to delete an owned post" + "\n" + "click 3 to edit an owned post");
		int number = input.nextInt();
   	 	return number;
	}
}