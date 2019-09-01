/*
*Student: 21600252 Taylor Everett 
*Date: 22/9/2017
*Version: 1
*/
import java.util.Scanner;

public class Unique
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);

      int[] numbers = new int[5]; // array that has 5 integers
      int count = 0; // numbers given are stored for use
      
      while(count < numbers.length)//loop that starts at 0 and stops at 5
      {
         System.out.print("Enter number: ");//asks for a number
         int number = input.nextInt();//takes number into int number
         
         // checks the input to be between 10 and 100
         if (10 <= number && number <= 100)
         {
            // checks to see if number already exists false is allowed
            boolean containsNumber = false;
            
            // compares input number to the numbers that have been put in the array
            for (int i = 0; i < count; i++)
               // if new number is already in the array it sets to true 
               if (number == numbers[i])
                  containsNumber = true;
            
            // adds the number only if it is not already in the array
            if (!containsNumber)
            {
               numbers[count] = number;
               count++;
            } 
            else 
               System.out.printf("%d has already been entered\n",
                  number);
         } 
         else
            System.out.println("number must be between 10 and 100");
         
         // prints the list of number successfully inputed
         for (int i = 0; i < count; i++)
            System.out.printf("%d ", numbers[i]);
         	System.out.println();
      } 
      input.close();// closes the input 
   } 
}