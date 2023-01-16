import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.util.ArrayList;
public class Profile{
	private String firstName;
	private String lastName;
	private String fieldOfInterest;
	private String dayOfBirth;
	private String monthOfBirth;
	private String yearOfBirth;
	private String levelOfEducation;
	public Profile () {
	}
	public Profile(String firstName, String lastName, String fieldOfInterest,
	                String dayOfBirth, String monthOfBirth, String yearOfBirth,
	                String levelOfEducation) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.fieldOfInterest = fieldOfInterest;
		this.dayOfBirth = dayOfBirth;
		this.monthOfBirth = monthOfBirth;
		this.yearOfBirth = yearOfBirth;
		this.levelOfEducation = levelOfEducation;
	}
	//Seters and Geters to handle the private values
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setFieldOfInterest(String fieldOfInterest) {
		this.fieldOfInterest = fieldOfInterest;
	}
	public String getFieldOfInterest() {
		return fieldOfInterest;
	}
	public void setDayOfBirth(String dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}
	public String getDayOfBirth() {
		return dayOfBirth;
	}
	public void setMonthOfBirth(String monthOfBirth) {
		this.monthOfBirth = monthOfBirth;
	}
	public String getMonthOfBirth() {
		return monthOfBirth;
	}
	public void setYearOfBirth(String yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}
	public String getYearOfBirth() {
		return yearOfBirth;
	}
	public void setLevelOfEducation(String levelOfEducation) {
		this.levelOfEducation = levelOfEducation;
	}
	public String getLevelOfEducation() {
		return levelOfEducation;
	}
	//creates profile and saves data to the txt
	public static void createProfile(String userId) {
			Scanner s = new Scanner(System.in);
			System.out.println("Create your Bio");
			System.out.println("First name:");
			String fn = s.next();
			System.out.println("Last name:");
			String ln = s.next();
			System.out.println("Field of interest:");
			String fOFi = s.next();
			System.out.println("Birthday:");
			System.out.println("Day:");
			String dOFb = s.next();
			System.out.println("Month:");
			String mOFb = s.next();
			System.out.println("Year:");
			String yOFb = s.next();
			int answ = 0;
			String lOFe = "";
			do {
				System.out.println("Level of education:");
			    System.out.println("1.High School");
			    System.out.println("2.Bsc");
			    System.out.println("3.Msc");
			    System.out.println("4.Phd");
			   answ = s.nextInt();
			   switch(answ) {
				   case 1:
				   lOFe = "High School";
				   break;
				   case 2:
				   lOFe = "Bsc";
				   break;
				   case 3:
				   lOFe = "Msc";
				   break;
				   case 4:
				   lOFe = "Phd";
				   break;
				   default:
				   System.out.println("Wrong input. Try again");
			   }
			 } while(answ != 1 && answ != 2 && answ != 3 && answ != 4);
			Profile p = new Profile(fn , ln , fOFi , dOFb , mOFb , yOFb , lOFe);
			String d0 = userId;
			String d1 = p.getFirstName();
			String d2 = p.getLastName();
			String d3 = p.getFieldOfInterest();
			String d4 = p.getDayOfBirth();
			String d5 = p.getMonthOfBirth();
			String d6 = p.getYearOfBirth();
			String d7 = p.getLevelOfEducation();

			try {
				File f = new File("ProfileData.txt");
				PrintWriter pw = new PrintWriter(new FileOutputStream(f,true));
				String dataToBeSaved
				= (d0 + "," + d1 + "," + d2 +
				"," + d3 + "," + d4 + "," + d5 +
				"," + d6 + "," + d7);
				pw.append(dataToBeSaved + "\n");
				pw.close();
				System.out.println("You have completed your Bio");
			} catch (IOException e1) {
				System.out.println("An error has occurred");
			}
			s.close();
	}
	//returns the values of a profile
	public static String[] getProfile(String userId) {
		String[] data = new String[8];
				String currentLine;
				boolean found = false;
				try {
					FileReader fr = new FileReader("ProfileData.txt");
					BufferedReader br = new BufferedReader(fr);
					while((currentLine = br.readLine()) != null) {
						data = currentLine.split(",");
						if(userId.equals(data[0])) {
							found = true;
							break;
						}
					}
				} catch (FileNotFoundException e) {
					System.out.println("File not found");
					return null;
				} catch (IOException e1) {
					System.out.println("An error has occurred");
				}
				if(!found) {
					System.out.println("No records found");
				}
		return data;
	}


	// shows the profile
	public static void viewProfile(String userId) {

		String[] d = getProfile(userId);
		if(d.length == 8) {
		     System.out.println("My Bio");
		     System.out.println("First name :" + d[1]);
		     System.out.println("Last name: " + d[2]);
		     System.out.println("Field of interest: " + d[3]);
		     System.out.println("Birthday: " +
		     d[4] + "/" + d[5] + "/" + d[6]);
		     System.out.println("Level of education: " + d[7]);
		 } else {
			 System.out.println("Could not find rec");
		 }
	}
	// makes changes in txt file by replacing the old line
	public static void changeProfile(String userId) {

		viewProfile(userId);
		String[] data = new String[8];
		data = getProfile(userId);
	    System.out.println('\n' + "1. Change first name");
	    System.out.println("2. Change last name");
		System.out.println("3. Change field of interest");
	    System.out.println("4. Change day of birth");
		System.out.println("5. Change month of birth");
		System.out.println("6. Change year of birth");
		System.out.println("7. Change level of education");
	    Scanner s2 = new Scanner(System.in);
		int ans = s2.nextInt();
		System.out.println("Enter the new value:");
		String newValue = "";
		int answ = 0;
		if(ans == 7) {
			do {
				System.out.println("Level of education:");
				System.out.println("1.High School");
			    System.out.println("2.Bsc");
				System.out.println("3.Msc");
				System.out.println("4.Phd");
				answ = s2.nextInt();
				switch(answ) {
					case 1:
					newValue = "High School";
					break;
					case 2:
				    newValue = "Bsc";
					break;
					case 3:
					newValue = "Msc";
					break;
					case 4:
					newValue = "Phd";
					break;
					default:
					System.out.println("Wrong input. Please try again");
				}
			} while(answ != 1 && answ != 2 && answ != 3 && answ != 4);
		} else {
			newValue = s2.next();
		}
	    String dataToBeSaved = data[0];
		String oldData = data[0];
	    for(int i = 1; i <8; i++) {
			oldData += ("," + data[i]);
			if(i == ans) {
				dataToBeSaved += ("," + newValue );
			} else {
				dataToBeSaved += ("," + data[i]);
			}
		}
		s2.close();
		try {
			Scanner sc = new Scanner(new File("ProfileData.txt"));
			StringBuffer buffer = new StringBuffer();
			while (sc.hasNextLine()) {
				buffer.append(sc.nextLine()+System.lineSeparator());
			}
			String fileContents = buffer.toString();
			sc.close();
			fileContents = fileContents.replaceAll(oldData, dataToBeSaved);
			FileWriter writer = new FileWriter("ProfileData.txt");
			writer.append(fileContents);
			writer.flush();
			System.out.println("You have successfully changed your Bio");
		} catch(IOException e) {
			System.out.println("An error has occurred");
		}
	}

	//changes the username
	public void changeUsername(String userId) {
		String[] data = new String[3];
		String currentLine;
		boolean found = false;
		String oldLine = "";
		String newLine = "";
		String newUN ;
		try {
			FileReader fr = new FileReader("users.txt");
			BufferedReader br = new BufferedReader(fr);
			while((currentLine = br.readLine()) != null) {
				data = currentLine.split(",");
				if(userId.equals(data[0])) {
					found = true;
					break;
				}
			}
			if(found) {
				System.out.println("My username: " + data[1]);
	            System.out.println("Please enter new username");
	            Scanner sc = new Scanner(System.in);
                newUN = sc.next();
                sc.close();
                oldLine = data[0] + "," + data[1] + "," + data[2];
                newLine = data[0] + "," + newUN + "," + data[2];
                Scanner s2 = new Scanner(new File("users.txt"));
                StringBuffer buffer = new StringBuffer();
                while(s2.hasNextLine()) {
					buffer.append(s2.nextLine() + System.lineSeparator());
				}
				String fileContents = buffer.toString();
				s2.close();
				fileContents = fileContents.replaceAll(oldLine, newLine);
				FileWriter writer = new FileWriter("users.txt");
				writer.append(fileContents);
				writer.flush();
				System.out.println("You have successfully changed your username");
			}
		} catch(FileNotFoundException e1) {
			System.out.println("File Not Found");
		} catch(IOException e2) {
			System.out.println("Error");
		}
	}

	//verifies current password and changes it
	public void changePassword(String userId) {
			String[] data = new String[3];
			String currentLine;
			boolean found = false;
			boolean pwans = false;
			String oldLine = "";
			String newLine = "";
			String newPW;
			String currPW;
			try {
				FileReader fr = new FileReader("users.txt");
				BufferedReader br = new BufferedReader(fr);
				while((currentLine = br.readLine()) != null) {
					data = currentLine.split(",");
					if(userId.equals(data[0])) {
						found = true;
						break;
					}
				}
				if(found) {
					Scanner sc = new Scanner(System.in);
					System.out.println("Please enter current password:");
					currPW = sc.next();
					if(currPW.equals(data[2])) {
						System.out.println("Please enter new password:");
		                newPW = sc.next();
		                pwans = true;
					} else {
						System.out.println("Wrong password");
						System.out.println("You can't change the password");
						newPW = data[2];
					}
	                sc.close();
	                oldLine = data[0] + "," + data[1] + "," + data[2];
	                newLine = data[0] + "," + data[1] + "," + newPW;
	                Scanner s2 = new Scanner(new File("users.txt"));
	                StringBuffer buffer = new StringBuffer();
	                while(s2.hasNextLine()) {
						buffer.append(s2.nextLine() + System.lineSeparator());
					}
					String fileContents = buffer.toString();
					s2.close();
					fileContents = fileContents.replaceAll(oldLine, newLine);
					FileWriter writer = new FileWriter("users.txt");
					writer.append(fileContents);
					writer.flush();
					if(pwans) {
						System.out.println("You have successfully changed your password");
					}
				}
			} catch(FileNotFoundException e1) {
				System.out.println("File Not Found");
			} catch(IOException e2) {
				System.out.println("Error");
			}
		}

}
