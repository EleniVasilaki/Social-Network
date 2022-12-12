import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;


public class main {
    public static void main(String[] args) {
		//Create_Post.createPostMethod();
		Path testpath = Create_Post.createPostMethod();
		//System.out.println(testpath);
		try {
			File file = new File(testpath.toString());
			Desktop desktop = Desktop.getDesktop();
			if (file.exists()) {
				desktop.open(file);
			}else{
				System.out.println("d");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
