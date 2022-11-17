import java.util.*;

class ReverseNumber {
  public static void main(String[] args) {
    try {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number:");
		int num = scanner.nextInt();
	    int result = 0;
	
	    for(;num != 0; num /= 10) {
	      int digit = num % 10;
	      result = result * 10 + digit;
	    }
	
	    System.out.println("Result is : " + result);
    } catch (Exception e) {
    	System.out.println("Exception occurred:"+e);
    }
  }
}
