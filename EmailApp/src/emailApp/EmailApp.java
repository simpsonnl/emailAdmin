package emailApp;

import java.util.ArrayList;
import java.util.Scanner;

public class EmailApp {
	
	//array list that stores all the users created
	private static ArrayList<Email> mailList = new ArrayList<Email>();

	public static void main(String[] args) {

		promptUser();
		
	}
	
	private static void promptUser() {
		
		boolean status = true;
		Scanner in = new Scanner(System.in);
		
		//loops until a matching number is entered
		while(status) {
			
			System.out.print("What would you like to do?\n"
					+ "\n1: Create New Employee\n"
					+ "2: Change Password\n"
					+ "3: Forgot Password\n"
					+ "0: Quit\n"
					+ "\nEnter a number: ");
			
			char num = in.next().charAt(0);
		
			//bring you to the right method depending on what number was entered
			if(num == '1') {
				createNew();
			}else if(num == '2') {
				changePassword();
			}else if(num == '3') {
				forgotPassword();
			}else if(num == '0') {
				status = false;
			}else {
					System.out.println("Please enter a valid number.\n");
				}
		}
	}
	
	private static void createNew() {
		System.out.print("Enter your first name: ");
		Scanner in = new Scanner(System.in);
		String first = in.nextLine();	
		
		System.out.print("Enter your last name: ");
		String last = in.nextLine();
		
		Email acc = new Email(first, last);
		mailList.add(acc);
	}
	
	private static void changePassword(){
		String email;
		String currentPass;
		String newPass1;
		String newPass2;
		Email currentUser = null;
		boolean x = true;
		boolean y = true;
		boolean z = true;
		Scanner in = new Scanner(System.in);
		
		//check if mailList is null
		if(mailList.isEmpty()) {
			System.out.println("The mail list is empty. Please create a user.\n");
			return;
		}
		
		//This loops through the mail list to look for the users email
		//if it is in the list it sets  that index as the current user
		//if it is not, it goes back to the beginning of the loop and 
		//asks for the email again.
		while(x) {
		
			System.out.print("Enter your email(or type \"quit\" to go back): ");
			
			email = in.nextLine();
			//System.out.print(mailList.get(0).getEmail());
			
			//exit if quit is entered
			if(email.equals("quit")) {
				return;
				}
			
				for(int i = 0; i < mailList.size(); i++) {
						if(email.contentEquals(mailList.get(i).getEmail())) {
							currentUser = mailList.get(i);
						}
					}
				if(currentUser == null) {
					System.out.println("Invalid email. Please enter a valid email.");
				}else {
					x = false;
				}
		}
		//loops until you enter the correct current password
		while(y) {
			System.out.print("Enter your current password(or type \\\"quit\\\" to go back): ");
			
			currentPass = in.nextLine();
			
			//exit if quit is entered
			if(currentPass.equals("quit")) {
				return;
				}
				
			//checks that the correct current password was entered
			if(currentPass.contentEquals(currentUser.getPassword())) {
				while(z) {
					
					//asks for the new password twice to verify
					System.out.print("Please enter a new password: ");
					newPass1 = in.nextLine();
					System.out.print("Please enter the new password again: ");
					newPass2 = in.nextLine();
					
					//if the two entered new passwords match, the password is changed for the user and returns to menu
					//if they are different, loops back to the beginning of the new password process
					if(newPass1.contentEquals(newPass2)) {
						currentUser.setPassword(newPass1);
						System.out.println("\nYour new password is \"" + newPass1 + "\"\n");
						return;
					}else {
						System.out.println("New passwords don't match, try again.");
					}
				}
				//set to false to exit the while loop
				y = false;
			
			}else {
				System.out.println("Incorrect passowrd.\n");
			}
			//goes back to the beginning of the first while loop if the entered password is incorrect
		}
		
		
		
	}
	private static void forgotPassword() {
		String email;
		Email currentUser = null;
		String newPass1;
		String newPass2;
		boolean x = true;
		boolean z = true;
		String q;
		String a;
		Scanner in = new Scanner(System.in);
		
		//checks for an empty mail list
		if(mailList.isEmpty()) {
			System.out.println("The mail list is empty. Please create a user.\n");
			return;
		}
		//gets current user by asking for email
		while(x) {
			
			System.out.print("Enter your email(or type \"quit\" to go back): ");
			
			email = in.nextLine();
			
			
			//exit the method if quit is entered
			if(email.equals("quit")) {
				return;
				}
				
				//searches the mail list for a user with a matching email
				for(int i = 0; i < mailList.size(); i++) {
						if(email.contentEquals(mailList.get(i).getEmail())) {
							currentUser = mailList.get(i);
						}
					}
				//if current user is still null, no user was found with the entered email
				//goes back to the begging of the while loop
				//if a user was found x is set to false and the loop is exited
				if(currentUser == null) {
					System.out.println("\nInvalid email. Please enter a valid email.");
				}else {
					x = false;
				}
		}
		//retrieves the current users chosen security question
		q = currentUser.getQuestion();
		
		//loops until the correct answer is entered or the user types quit
		do {
			System.out.println("\n" + q);
			System.out.println("\nAnswer(or \"quit\" to go back): ");
			
			a = in.nextLine();
			
			//if quit is entered, the method is exited. goes back to menu
			if(a.equals("quit")) {
				return;
				
			}
			//if the correct answer is entered, starts the new password process
			if (a.equals(currentUser.getAnswer())) {
				while(z) {
					System.out.print("Please enter a new password: ");
					newPass1 = in.nextLine();
					System.out.print("Please enter the new password again: ");
					newPass2 = in.nextLine();
					
					//if the two entered new passwords match, the password is changed for the user and returns to menu
					//if they are different, loops back to the beginning of the new password process
					if(newPass1.contentEquals(newPass2)) {
						currentUser.setPassword(newPass1);
						System.out.println("\nYour new password is \"" + newPass1 + "\"\n");
						return;
					}else {
						System.out.println("New passwords don't match, try again.");
					}
				}
			}
			System.out.println("Incorrect answer, try again.");
			
		}while(!(a.equals(currentUser.getAnswer())));
	}
}
