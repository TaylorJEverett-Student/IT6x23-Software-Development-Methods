package EpicVotingSystem;

import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

/*
 * File Name :Interface
 * author :Taylor Everett
 * Date :27/9/2017
 * Description :version 1.2
 */

public class VotingInterface {
	private VotingController vc;
	private Staff theStaff;
	private Candidate theCandidate;

	private admin theAdmin;

	// not used anymore
	// private final String USERNAME = "admin";
	// private final String PASSWORD ="admin123";

	// Used to count the number of login attempts
	private int loginCount = 0;
	private int numberOfCandidates = 0;

	// used to get inputs to add and delete
	Scanner editInput = new Scanner(System.in);

	public int getNumberOfCandidates() {
		return numberOfCandidates;
	}

	public void setNumberOfCandidates(int numberOfCandidates) {
		this.numberOfCandidates = numberOfCandidates;
	}

	private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	// Here is the start of your program.
	public static void main(String[] args) {
		VotingInterface vi = new VotingInterface();
		vi.start();
	}

	// This methods is complete and does not require change.
	public void start() {
		vc = new VotingController();
		commenceVoting();
	}

	// This method helps to manage admin session after a successful login
	private boolean manageAdmin() {
		boolean adminQuit = false;
		boolean systemQuit = false;

		while (!adminQuit) {
			System.out.println("\n\t\t***=====Admin Opions=====***");
			System.out.println("\nTo view voting report enter \"V\"" + "\nTo view Staff vote report \"S\""
					+ "\nTo update candidate enter \"UC\"" + "\nTo update Staff enter \"US\""
					+ "\nTo update Admin enter \"UA\"" + "\nTo Set change deadline time enter \"T\""
					+ "\nTo continue voting enter \"C\""+ "\nTo end voting enter \"Stop\" : ");
			String input = getInput();
			if (input.equalsIgnoreCase("v")) {
				printVoteResults();// voting results
			} else if (input.equalsIgnoreCase("s")) {
				printStaffReport();// staff vote information
			} else if (input.equalsIgnoreCase("uc")) {
				updateCandidates();// view add and delete from candidates.txt 
			} else if (input.equalsIgnoreCase("us")) {
				updateStaff();// view add and delete from staff.txt 
			} else if (input.equalsIgnoreCase("ua")) {
				updateAdmin();// view add and delete from admin.txt 
			} else if (input.equalsIgnoreCase("T")) {
				updateTime();// view set time
			} else if (input.equalsIgnoreCase("C")) {
				adminQuit = true;//ends admin Panel
				commenceVoting();//once this method is closed the program stops running so to make it continue, it calls for the the first options to show again
			} else if (input.equalsIgnoreCase("Stop")) {
				// stop system
				adminQuit = true;//ends admin Panel
				systemQuit = true;//ends the whole program
				System.out.println("Voting System Closed");
			} else {
				System.out.println("Cannot understand your input, please re-enter : \n\n");
			}
		}
		return systemQuit;
	}

	// validates administrator username & password. This method is complete and
	// does not require additional code.
	/*
	 * public boolean validateAdmin(String username, String password) {
	 * if(username.equalsIgnoreCase(USERNAME)&&(password.equals(PASSWORD))) {
	 * return true; } else { return false; } }
	 */

	// screen input reader. This method is complete and working OK.
	private String getInput() {
		String theInput = "";

		try {
			theInput = in.readLine().trim();
		} catch (IOException e) {
			System.out.println(e);
		}
		return theInput;
	}

	// =======================================================================
	public void commenceVoting() {
		boolean systemQuit = false;
		while (!systemQuit) {
			String input = null;//blank place holder
			System.out.println("\n\t\t============== eVoting System ==============\n\n");
			System.out.print("Enter \"v\" to Vote as staff \nOR \"a\" to login in as system adminirstaror \nOR \"help\" if you are unsure : ");
			input = getInput();// uses this method to attain user input

			if (input.equalsIgnoreCase("V")) {//if input is equal to v it will activate this method
				manageVote();
			} else if (input.equalsIgnoreCase("A")) {//if input is equal to A it will activate this method
				validateAdmin();
				systemQuit = true;//stop running when the method is stopped as well
			}else if (input.equalsIgnoreCase("Help")){
				System.out.print("\nStaff should only need to enter V \nOnly Administrators should enter A");
			} else {
				System.out.println("Your input Unknown");//catching an other inputs
			}
		}
	}

	// ====================================================================-==

	private void validateAdmin() {
		boolean adminQuit = false;//false to keep this method going

		while (adminQuit == false) {
			System.out.print("\nYou have entered Administration space. \nEnter username or \"Q\" to quit : ");
			String input = getInput();

			try {
				theAdmin = vc.getAdminUsername(input);
				if (theAdmin != null) {//comparing the admin.txt with user input
					adminQuit = true;
				}
				if (input.equalsIgnoreCase("q")) {//if Q is pressed the method will close and start the program over
					adminQuit = true;
					commenceVoting();// to continue the program running
				} else {
					String password = null;
					System.out.print("\nPlease enter password : ");
					password = getInput().trim();

					if ((theAdmin.getPassWord()).equals(password)) {//if password matches admin username then openamin panel
						
						adminQuit = true;
						manageAdmin();
					} else {
						System.out.println("Incorrect Password does not match password stored for this admin");
						commenceVoting();
					}
				}
			} catch (Exception e) {
				System.out.println("Incorrect username. Username \"" + input + "\" does not exit!");
				commenceVoting();
			}
		}
	}

	// =======================================================================
	public void manageVote() {
		boolean moveOn = false;
		
		// loop for each voter
		while (moveOn == false) {
			System.out.print("Please enter your staff ID :");

			try {
				theStaff = vc.getStaff(Integer.parseInt(getInput()));
				vc.checkDate();
				if (theStaff.hasVoted() == 1) {//check staff.txt for voted value is 1 and doesn't let them continue
					System.out.println("\nYou have voted and cannot vote again\nGood bye...!");
					moveOn = true;
				} else if (theStaff.hasVoted() == 0) {//check staff.txt for voted value is 0 and lets them continue
					String password = null;
					System.out.print("\nPlease enter password : ");
					password = getInput().trim();

					if ((theStaff.getPassword()).equals(password)) {//gets password for the Line of ID given and compares password
						getStaffVote();
						moveOn = true;
					} else {
						System.out.println("Incorrect password");//if incorrect
						++loginCount;//adds 1 to login count
						if (loginCount == 3) {//compares login count to 3
							moveOn = true;//ends method 
						}
					}
				}else if(theStaff.hasVoted() == 2){//check staff.txt for voted value is 2 and doesn't let them continue
					System.out.println("\nVoting has ended\nGood bye...!");
					moveOn = true;
				}
				else {
					System.out.println("There seems to be a problem.  Contact your administrator");
				}

			} catch (NumberFormatException e) {
				System.out.println("Invalid entry - you must enter a number\nPlease try again");
			} catch (NullPointerException e) {
				++loginCount;
				if (loginCount == 3) {
					moveOn = true;
				}
				System.out.println("Error! Staff ID not found.\nPress ENTER to try again or  \"q\" to QUIT :  ");
				if ("q".equalsIgnoreCase(getInput())) {
					System.out.println("Good bye!");
					moveOn = true;
				}
			}

		}
		System.out.print("going back to voting screen...");
	}
	// =======================================================================

	// =======================================================================
	public void displayVotingScreen() {

		System.out.println("\nWelcome " + theStaff.getName() + "!\n");
		setNumberOfCandidates(0);//0 is give so the numbers will start from 1

		ArrayList<?> candidates = vc.getCandidates();//uses the controller to get the data from the candidate.txt

		Iterator<?> it = candidates.iterator();//takes the information line by line
		System.out.println("\tCode\tCandidate Name");
		System.out.println("\t====\t==============\n");
		while (it.hasNext()) {//loop that builds the the list for staff to choose from 
			theCandidate = (Candidate) it.next();
			System.out.println("\t" + theCandidate.getCandidateCode() + "\t" + theCandidate.getName());
			setNumberOfCandidates(getNumberOfCandidates() + 1);
		}
	}
	// =======================================================================

	// =======================================================================
	private void getStaffVote() {
		int candidateCode;
		boolean retry = true;

		displayVotingScreen();

		while (retry) {
			System.out.print("\n\nEnter your candidate's code OR enter Q to quit voting : ");
			try {
				String input = getInput();

				if (input.equalsIgnoreCase("Q")) {
					retry = false;
				} else {
					candidateCode = Integer.parseInt(input);
					theCandidate = vc.getCandidate(candidateCode);
					System.out.print("\nYou have selected " + theCandidate.getName()//shows the user what they entered
							+ ". \n\nEnter  Y to confirm or any other key to Cancel, then press ENTER : ");

					if (getInput().equalsIgnoreCase("y")) {//confirms then starts record method in controller
						vc.recordVote();
						System.out.println("\n\nThanks for voting " + theStaff.getName() + ". Bye!!!");
						retry = false;
					}
				}
			} catch (NumberFormatException e) {
				System.out.println("That was not a number you entered\nPlease try again");
			} catch (NullPointerException e) {
				System.out.println("This candidate code does not exist\nPlease try again");
			} catch (Exception e) {
				System.out.println("We have a problem, please contact your administrator");
			}
		}
	}

	// =======================================================================

	// =======================================================================
	public void printVoteResults() {
		ArrayList<?> candidates = vc.getCandidates();
		int totalVoters = vc.getTotalVoters();
		double totalVoted = 0;
		int candidateVotes = 0;

		// formatting display
		DecimalFormat df = new DecimalFormat("###.##");

		Iterator<?> it = candidates.iterator();
		System.out.println("\n\t\t VOTING REPORT");
		System.out.println("\t\t===============\n");
		System.out.println("Code\tName\t\t\tVotes\t(Vote%)");
		System.out.println("____\t____\t\t\t_____\t______\n");

		// loop to calculate total voted
		while (it.hasNext()) {
			theCandidate = (Candidate) it.next();
			totalVoted += theCandidate.getVotes();// adds up total votes for
													// this candidate
		}

		it = candidates.iterator();
		while (it.hasNext()) {
			theCandidate = (Candidate) it.next();
			candidateVotes = theCandidate.getVotes();
			System.out.println(theCandidate.getCandidateCode() + "\t" + theCandidate.getName() + "\t\t" + candidateVotes
					+ "\t(" + df.format((candidateVotes / totalVoted) * 100) + "%)");
		}
		System.out.println("\nNumber of listed voters: " + totalVoters);
		System.out.println("Number that has voted: " + totalVoted + "(" + df.format((totalVoted / totalVoters) * 100) + "%)");
	}

	public void printStaffReport() {
		ArrayList<?> staffs = vc.getStaff();
		Iterator<?> it = staffs.iterator();

		System.out.println("\n\t\t Staff Voter Report");
		System.out.println("\t\t====================\n");
		System.out.println("Name     Status     Date");

		while (it.hasNext()) {
			theStaff = (Staff) it.next();
			if (theStaff.hasVoted() == 1) {
				System.out.println(theStaff.getName() + " , " + " Voted " + " , " + theStaff.getDate());
			} else if (theStaff.hasVoted() == 0) {
				System.out.println(theStaff.getName() + "     !*Not Voted*!");
			} else if (theStaff.hasVoted() == 2) {
				System.out.println(theStaff.getName() + "     !*Vote Expired*!");
			}
		}

	}

	public void updateCandidates() {
		boolean updateQuit = false;

		ArrayList<?> candidates = vc.getCandidates();

		Iterator<?> it = candidates.iterator();
		System.out.println("Code  Candidate Name  Votes");
		System.out.println("===========================");
		while (it.hasNext()) {// loop builds a list of all candidate data
			theCandidate = (Candidate) it.next();
			System.out.println(
					theCandidate.getCandidateCode() + " , " + theCandidate.getName() + " , " + theCandidate.getVotes());
		}
		// Candidate options
		while (updateQuit == false) {
			System.out.println("\n\t\t***===== Canadidate Opions=====***");
			System.out
					.println("\nTo Add Canadidates \"A\"" + "\nTo Delete Canadidates \"D\"" + "\nTo Exit \"Q\" : ");
			String input = getInput();
			// add Candidate
			if (input.equalsIgnoreCase("A")) {
				try {
					//selects where the writer will write and to add to .txt not write over with "true"
					BufferedWriter writer = new BufferedWriter(new FileWriter("candidates.txt", true));
					//string to hold input
					String code, name, votes;
					System.out.println("=====Add Canadidate=====");
					System.out.print("Enter Candidates Code: ");
					code = editInput.nextLine();
					System.out.print("Enter the Candidates Name: ");
					name = editInput.nextLine();
					votes = "0";

					writer.write(code + "," + name + "," + votes + "\n");//writes string to txt flie
					writer.close();
					vc.loadCandidateData();
					updateQuit = true;
				} catch (IOException e) {
					System.out.println(e);
				}
			}
			// delete Candidate
			else if (input.equalsIgnoreCase("D")) {
				try { // used to store data from admin input
					String code, name;

					File tempfile = new File("candidates_temp.txt");
					File file = new File("candidates.txt");
					//for reading the file to be changed
					BufferedReader reader = new BufferedReader(new FileReader(file));
					//for writing the temp file for changing
					BufferedWriter writer = new BufferedWriter(new FileWriter(tempfile));

					System.out.println("=====Delete Canadidate=====");
					System.out.println("Enter the Canadidate Code: ");
					code = editInput.nextLine();
					//loop that gets the entire line to be deleted
					while ((name = reader.readLine()) != null) {
						if (name.contains(code))
							continue;

						writer.write(name);
						writer.flush();
						writer.newLine();
					}
					reader.close();
					writer.close();
					file.delete();
					tempfile.renameTo(file);//changed temp file is made the new file
					vc.loadCandidateData();
					updateQuit = true;
				} catch (IOException e) {
					System.out.println(e);
				}
			} else if (input.equalsIgnoreCase("Q")) {
				updateQuit = true;
			} else {
				System.out.println("Cannot understand your input, please re-enter : \n\n");
			}
		}
	}

	public void updateAdmin() {
		boolean updateQuit = false;

		ArrayList<?> admins = vc.getAdmins();

		Iterator<?> it = admins.iterator();
		System.out.println("ID  Admin Name  Username  Password");
		System.out.println("==================================");
		while (it.hasNext()) {
			theAdmin = (admin) it.next();
			System.out.println(theAdmin.getId() + " , " + theAdmin.getName() + " , " + theAdmin.getUserName() + " , "
					+ theAdmin.getPassWord());
		}
		while (updateQuit == false) {
			System.out.println("\n\t\t***===== Admin Opions=====***");
			System.out.println("\nTo Add Admin \"A\"" + "\nTo Delete Admin \"D\"" + "\nTo Exit \"Q\" : ");
			String input = getInput();
			// add Admin
			if (input.equalsIgnoreCase("A")) {
				try {
					BufferedWriter writer = new BufferedWriter(new FileWriter("admin.txt", true));

					String ID, name, userName, password;
					
					System.out.println("=====Add Admin=====");
					System.out.print("Enter Admin ID: ");
					ID = editInput.nextLine();
					System.out.print("Enter the Admin name: ");
					name = editInput.nextLine();
					System.out.print("Enter the USERNAME: ");
					userName = editInput.nextLine();
					System.out.print("Enter the PASSWORD: ");
					password = editInput.nextLine();

					writer.write(ID + "," + name + "," + userName + "," + password + "\n");
					writer.close();
					vc.loadAdminData();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
			// delete admin
			else if (input.equalsIgnoreCase("D")) {
				try {
					String ID, name;

					File tempfile = new File("admin_temp.txt");
					File file = new File("admin.txt");

					BufferedReader reader = new BufferedReader(new FileReader(file));
					BufferedWriter writer = new BufferedWriter(new FileWriter(tempfile));

					System.out.println("=====Delete Admin=====");
					System.out.println("Enter the Canadidate Code: ");
					ID = editInput.nextLine();

					while ((name = reader.readLine()) != null) {
						if (name.contains(ID))
							continue;

						writer.write(name);
						writer.flush();
						writer.newLine();
					}
					reader.close();
					writer.close();
					file.delete();
					tempfile.renameTo(file);
					vc.loadAdminData();
				} catch (IOException e) {
					System.out.println(e);
				}
			} else if (input.equalsIgnoreCase("Q")) {
				updateQuit = true;
			} else {
				System.out.println("Cannot understand your input, please re-enter : \n\n");
			}
		}

	}

	public void updateStaff() {
		boolean updateQuit = false;

		ArrayList<?> staffs = vc.getStaff();

		Iterator<?> it = staffs.iterator();
		System.out.println("ID      Staff Name  Vote  Password  Timestamp");
		System.out.println("=============================================");
		while (it.hasNext()) {
			theStaff = (Staff) it.next();
			System.out.println(theStaff.getId() + " , " + theStaff.getName() + " , " + theStaff.hasVoted() + " , "
					+ theStaff.getPassword() + " , " + theStaff.getDate());
		}
		while (updateQuit == false) {
			System.out.println("\n\t\t***===== Edit Staff Opions=====***");
			System.out.println("\nTo Add Staff \"A\"" + "\nTo Delete Staff \"D\"" + "\nTo Exit \"Q\" : ");
			
			String input = getInput();//get input for options
			// add staff
			if (input.equalsIgnoreCase("A")) {
				try {
					BufferedWriter writer = new BufferedWriter(new FileWriter("staff.txt", true));

					String ID, name, voted, password, date;
					
					System.out.println("=====Add Staff=====");
					System.out.print("Enter Staff ID login: ");
					ID = editInput.nextLine();
					System.out.print("Enter the Staff Name: ");
					name = editInput.nextLine();
					System.out.print("Enter the Staff PASSWORD: ");
					password = editInput.nextLine();
					voted = "0";
					date= "yyyy.MM.dd.HH.mm.ss";					

					writer.write(ID + "," +name+ "," +voted+  "," +password+ "," +date+ "\n");
					writer.close();
					vc.loadStaffData();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
			// delete staff
			else if (input.equalsIgnoreCase("D")) {
				try { // used to store data from admin edit input
					String ID, name;

					File tempfile = new File("staff_temp.txt");
					File file = new File("staff.txt");

					BufferedReader reader = new BufferedReader(new FileReader(file));
					BufferedWriter writer = new BufferedWriter(new FileWriter(tempfile));

					System.out.println("=====Delete Staff=====");
					System.out.println("Enter the Staff ID: ");
					ID = editInput.nextLine();

					while ((name = reader.readLine()) != null) {
						if (name.contains(ID))
							continue;

						writer.write(name);
						writer.flush();
						writer.newLine();
					}
					reader.close();
					writer.close();
					file.delete();
					tempfile.renameTo(file);
					vc.loadStaffData();
				} catch (IOException e) {
					System.out.println(e);
				}
			} else if (input.equalsIgnoreCase("Q")) {
				updateQuit = true;
			} else {
				System.out.println("Cannot understand your input, please re-enter : \n\n");
			}
		}
	}
	public void updateTime(){
		boolean updateQuit = false;

		while (updateQuit == false) {
			System.out.println("===== Set Deadline Time =====");
			System.out.println("Year/Month/Day/Time");
			System.out.println(vc.deadLine);//prints hard coded deadline to admin to be viewed
			System.out.println("\nTo Change Deadline Enter \"C\"" + "\nTo Quit \"Q\" : ");
			String input = getInput();
			if (input.equalsIgnoreCase("C")) {
				
			}
			else if(input.equalsIgnoreCase("Q")) { 
				updateQuit = true;
			}
			else{
				System.out.println("Cannot understand your input, please re-enter : \n\n");
			}
		}
		
	}
}
