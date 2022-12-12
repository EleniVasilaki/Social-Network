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
	public Profile(String firstName, String lastName, String fieldOfInterest,
	                String dayOfBrirth, String monthOfBirth, String yearOfBirth,
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
	//method to create the profile and save the data to txt
	public void createAndSaveProfile(String userId) {
			Scanner s = new Scanner(System.in);
			System.out.println("Create your profile");
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
			System.out.println("Level of education:");
			String lOFe = s.next();
			// all these should be done before creating the new user bc of same constructor
			//saving all data to file


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
				pw.append("\n" + dataToBeSaved);
				pw.close();
			} catch (IOException e1) {
				System.out.println("An error has occurred");
			}
			s.close();
	}
	//it returns the values of a profile
	public static String[] getProfile(String userId) {
		ArrayList<String> rec = new ArrayList<String>();
	    boolean found = false;
		String[] data = new String[8];
		String r = "";
		try {
			Scanner x =
			new Scanner(new File("ProfileData.txt"));
			x.useDelimiter("[,\n]");
			while(x.hasNext()) {
				data[0] = x.next();
				data[1] = x.next();
				data[2] = x.next();
				data[3] = x.next();
				data[4] = x.next();
				data[5] = x.next();
				data[6] = x.next();
				data[7] = x.next();
				if(data[0] == userId) {
					r = data[0] + "," + data[1] + "," + data[2] + "," +
					data[3] + "," + data[4] + "," + data[5] + "," +
					data[6] + "," + data[7];
					rec.add(r);
					found = true;
					break;
				}
			}
			x.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		if (!found) {
			System.out.println("No records found");
		}
		String[] recArray = new String[rec.size()];
		rec.toArray(recArray);
		return recArray;
	}


	// it shows a profile
	public static void viewProfile(String userId) {
		String[] data = getProfile(userId);
		System.out.println("First name :" + data[1]);
		System.out.println("Last name: " + data[2]);
		System.out.println("Field of interest: " + data[3]);
		System.out.println("Birthday: " +
		data[4] + "/" + data[5] + "/" + data[6]);
		System.out.println("Level of education: " + data[7]);
	}
	// makes changes in txt file
	public static void changeProfile(String userId) {
		String[] data = getProfile(userId);
		System.out.println("Press 1 to change your first name");
		System.out.println("Press 2 to change your last name");
		System.out.println("Press 3 to change your field of interest");
		System.out.println("Press 4 to change the day of birth");
		System.out.println("Press 5 to change the month of birth");
		System.out.println("Press 6 to change the year of birth");
		System.out.println("Press 7 to change your level of education");
		Scanner s2 = new Scanner(System.in);
		int ans = s2.nextInt();
		System.out.println("Enter the new value");
		String newValue = s2.next();
		String dataToBeSaved = data[0];
		s2.close();
		for(int i = 1; i <8; i++) {
			if(i == ans) {
				dataToBeSaved += (newValue + ",");
			} else {
				dataToBeSaved += (data[i] + ",");
			}
		}
		File oldFile = new File("ProfileData.txt");
		File tempFile = new File("temp.txt");
		String[] st = new String[8];
		 try {
			 FileWriter fw = new FileWriter(tempFile, true);
			 BufferedWriter bw = new BufferedWriter(fw);
			 PrintWriter pw = new PrintWriter(bw);
			 Scanner  s3 = new Scanner(new File("temp.txt"));
			 s3.useDelimiter("[,\n]");
			 while(s3.hasNext()) {
				 st[0] = s3.next();
				 st[1] = s3.next();
				 st[2] = s3.next();
				 st[3] = s3.next();
				 st[4] = s3.next();
				 st[5] = s3.next();
				 st[6] = s3.next();
				 st[7] = s3.next();
				 if(st[0].equals(data[0])) {
					 pw.println(dataToBeSaved);
				 } else {
					 pw.println(st[0] + "," + st[1] + "," + st[2] +
				     "," + st[3] + "," + st[4] + "," + st[5] +
				     "," + st[6] + "," + st[7]);
				 }
				 s3.close();
				 pw.flush();
				 pw.close();
				 oldFile.delete();
				 File dump = new File("ProfileData.txt");
				 tempFile.renameTo(dump);
			 }
		 } catch (IOException e) {
			 System.out.println("An error has occured");
	     }
	 }
 }
