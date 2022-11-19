import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// H upload na kanei extend thn create: mesv methodoy ths create na kalv thn upload analoga ean ebale erigrafh h oxi o xrhsths????
public  class Create_post extends Post_code{
    public void createPostMethod() {
        Scanner in = new Scanner(System.in);
        System.out.println("click 1 to add a description to your post" + "\n" + "click 2 to add text/link for your post"); // more options
        int option = in.nextInt();
        if (option == 1) {
            System.out.println("Please enter your description:");
            String description = in.next();
            try {
                BufferedWriter writer = new BufferedWriter( new FileWriter(".\\post.txt"));
                writer.write(description);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            } 
        }
        System.out.println("Please insert link:");
        String userPost = in.next();
        try {
            BufferedWriter writer = new BufferedWriter( new FileWriter(".\\post.txt"));
            writer.write(userPost);
            writer.close();
            } catch (IOException e) {
            e.printStackTrace();
        } 
        in.close();
    }
}
