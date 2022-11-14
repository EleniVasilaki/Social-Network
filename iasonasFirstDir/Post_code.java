import java.util.Scanner;

public class Post_code {
	public num_of_choice () {
		Scanner input = new Scanner(System.in);
		System.out.println("click 1 to create a post" + "\n" + "click 2 to delete an owned post" + "\n" + "click 3 to edit an owned post");
		int number = input.nextInt();
   	 	if (number == 1) {
			Create_post.some_method();
		}else if (number == 2); {
			Delete_post.some_method2();
		}else{
			Edit_post.some_method3();
		}
	}
}