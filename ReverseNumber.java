package com.java.practice;
import java.util.*;

class ReverseNumber {
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);

            while(true) {
            	System.out.println("1. Reverse Number");
				System.out.println("0. Exit");
				System.out.println("Enter your choice:");			//Take choice of user
				String choice = scanner.nextLine();
				if("0".equals(choice)) {
					System.out.println("Ending the program");		//Stop the execution
					break;
				} else if("1".equals(choice)) {
		            // Declare variable and initialize
		            System.out.println("Enter the number:");
		            int num = scanner.nextInt();    // Read input from the user
		            int result = 0;
		
		            for(;num != 0; num /= 10) {			//Prepare the result
		                int digit = num % 10;
		                result = result * 10 + digit;
		            }
		            System.out.println("Result is : " + result);
				}
            }
        } catch (Exception e) {
            System.out.println("Exception occurred:"+e);
        } finally {
            if(scanner != null)
                scanner.close(); // close the scanner object
        }
    }
}
