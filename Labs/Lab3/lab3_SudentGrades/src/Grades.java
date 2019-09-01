/*
*Student: 21600252 Taylor Everett 
*Date: 1/9/2017
*Version: 0.0001
*/
public class Grades {
	
	public static void main(String[] args) {

		int letter=1;
		// not sure why switch was needed for a printout but thats what the lab said to do
		switch(letter)
		{
		case 1: 
			System.out.println("Student 1: A");
		case 2: 
			System.out.println("Student 2: C");
		case 3: 
			System.out.println("Student 3: B");
		case 4: 
			System.out.println("Student 4: A");
		case 5: 
			System.out.println("Student 5: B");
		default:
			System.out.println("Student Scores ");
			System.out.printf("A: 2 %nB: 2%nC: 1%nD: 0");
		}
	}
		
}
