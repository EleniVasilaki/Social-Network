import java.util.Scanner;

public class Post_code {
	public void num_of_choice () {
		Scanner input = new Scanner(System.in);
		System.out.println("click 1 to create a post" + "\n" + "click 2 to delete an owned post" + "\n" + "click 3 to edit an owned post");
		int number = input.nextInt();
		Create_Post CP = new Create_Post();
		Delete_Post DP = new Delete_post();
		Edit_post	EP = new Edit_post();
   	 	if (number == 1) {
			CP.createPostMethod();
		}else if (number == 2); {
			DP.some_method2();
		} else {
			EP.some_method3();
		}
	}
}