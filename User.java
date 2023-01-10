import java.util.ArrayList;
public class User {

	private int id;
	private String username;
	private String password;

	static ArrayList<Integer> ids = new ArrayList<>();
	static ArrayList<String> usernames = new ArrayList<>();
	static ArrayList<String> passwords = new ArrayList<>();

	public User(int id, String username, String password) {
		this.id = id;
	    this.username = username;
	    this.password = password;

	    ids.add(id);
	    usernames.add(username);
	    passwords.add(password);
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
   	}
}