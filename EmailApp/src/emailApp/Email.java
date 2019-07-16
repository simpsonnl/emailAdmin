package emailApp;

import java.util.Scanner;

public class Email {
	
	private String companyName = "RandomCompany";
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String altEmail;
	private String question;
	private String answer;
	private String email;
	private int mailboxCap = 500;
	//determines the length of the temporary password 
	private int passLen = 10;

	
	//Constructor gets the first and last name
	
	public Email(String firstName, String lastName) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		
		System.out.println("Name: " + getName());
		System.out.println("");
		
		//sets the department from user input
		this.department = setDepartment();
		System.out.println("Department set to: " + this.department + "\n");
		
		//gets and prints out an alternate email
		setAltEmail();
		System.out.println("Alt Email: " + this.altEmail + "\n");
		
		//gets a security question answer in the event of a forgotten password
		setQuestion();
		setAnswer();
		
		//generates and prints out new email
		this.email = generateEmail();
		System.out.println("Company email: " + this.email +"\n");
		
		//generates a temporary random password
		this.password = randomPassword(passLen);
		System.out.println("Your temporary password is \""  + password + "\"\n");
		
		
	}
	
	//gets and sets the department from the user
	
	private String setDepartment() {
		char dep;
		String department = null;
		
		//loops until a given number is selected
		do {
		System.out.print("Select a department ID:\n1 for Sales\n2 for Accounting\n3 for Development\n0 for None\n\nDepartment ID:");
		
		Scanner in = new Scanner(System.in);
		
		dep = in.next().charAt(0);
			
			//sets the department depending on what number is entered
			if(dep == '1') {
				department = "Sales";
			}else if(dep == '2') {
				department = "Accounting";
			}else if(dep == '3') {
				department = "Developement";
			}else if(dep == '0') {
				department = "";
			}else {
				System.out.println("Enter a valid ID.");
			}
		//if department is still null, a valid id number was not entered
		}while(department==null);
		
		return department;
	}
	
	//generates a random password from the password set
	private String randomPassword(int len) {
		String passSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVQXYZ1234567890!@#$%";
		
		char[] password = new char[len];
		
		for(int i = 0; i < len; i++) {
			int rand = (int)(Math.random()*passSet.length());
			password[i] = passSet.charAt(rand);
		}
		
		return new String(password);
	}
	
	//generates email
	private String generateEmail() {
		if(this.department=="") {
			return this.firstName.toLowerCase() + this.lastName.toLowerCase() + "@" + this.companyName + ".com"; 
			}else {
				return this.firstName.toLowerCase() + this.lastName.toLowerCase() + "@" + this.department + "." + this.companyName + ".com"; 
			}
	}
	
	//set mailbox capacity
	public void setMailboxCapacity(int cap) {
		this.mailboxCap = cap;
	}
	
	//sets the alternate email given by the user
	public void setAltEmail() {
		
		System.out.print("Please enter an alternate email: ");
		Scanner in = new Scanner(System.in);
		String altEmail = in.nextLine();
		
		this.altEmail = altEmail;
	}
	//sets security question
	public void setQuestion() {
		Scanner in = new Scanner(System.in);
		char num;
		boolean x = true;
		
		//lists the possible security questions
		//loops until a given number is chosen
		do {
			System.out.println("Security Questions:\n");
			System.out.println("1. What was your childhood nickname?");
			System.out.println("2. What is the name of your favorite childhood friend?");
			System.out.println("3. What is your oldest sibling's middle name?");
			System.out.println("4. In what city or town was your first job?");
			System.out.println("5. What school did you attend for sixth grade?");
			System.out.println("Enter the number for the security question you wish to answer: ");
			
			num = in.next().charAt(0);
			
			//sets the question depending on what number is chosen
			if(num == '1') {
				this.question = "What was your childhood nickname?";
				x = false;
			}if(num =='2') {
				this.question = "What is the name of your favorite childhood friend?";
				x = false;
			}if(num == '3') {
				this.question = "What is your oldest sibling's middle name?";
				x = false;
			}if(num == '4') {
				this.question = "In what city or town was your first job?";
				x = false;
			}if(num == '5') {
				this.question = "What school did you attend for sixth grade?";
				x = false;
			}else {
				System.out.println("Please enter a valid number.");
			}
			
		}while(x);
	}
	
	//sets security answer
	public void setAnswer() {
		System.out.println("\n" + this.question + "\nAnswer: ");
		Scanner in = new Scanner(System.in);
		this.answer = in.nextLine();
	}
	
	//sets the password
	public void setPassword(String password) {
		this.password = password;
	}
	
	//gets name
	public String getName() {
		return (firstName + " " + lastName);
	}
	
	//gets password
	public String getPassword() {
		return this.password;
	}
	
	//gets email
	public String getEmail() {
		return this.email;
	}
	
	//get department
	public String getDepartment() {
		return this.department;
	}
	
	//gets mailbox capacity
	public int getMailboxCapacity() {
		return this.mailboxCap;
	}
	
	//gets security question
	public String getQuestion() {
		return this.question;
	}
	
	//gets security answer
		public String getAnswer() {
			return this.answer;
		}
}
