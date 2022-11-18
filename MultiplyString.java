import java.util.*;

class MultiplyString {
	private static String multiply(String value1, String value2) {
		int len1 = value1.length();
		int len2 = value2.length();
		if (len1 == 0 || len2 == 0)						// If any single value is '0', then result would be '0'
			return "0";
		
		//Evaluate the result based on the given input
		int result[] = evaluateResult(value1, value2, len1, len2);
		
		int i = result.length - 1;
		while (i >= 0 && result[i] == 0)
			i--;

		if (i == -1)
		return "0";

		String output = "";
		
		while (i >= 0)									// Generate the final output
			output += (result[i--]);

		return output;
	}

	private static int[] evaluateResult(String value1, String value2, int len1, int len2) {
		int in1 = 0;
		int in2 = 0;
		int result[] = new int[len1 + len2];
		for (int i = len1 - 1; i >= 0; i--) {
			int carry = 0;
			int n1 = value1.charAt(i) - '0';		//Fetch the exact value based on the ascii value
			in2 = 0;
			
			for (int j = len2 - 1; j >= 0; j--) {
				int n2 = value2.charAt(j) - '0';
				int sum = n1 * n2 + result[in1 + in2] + carry;
				carry = sum / 10;
				result[in1 + in2] = sum % 10;
				in2++;
			}

			if (carry > 0)
				result[in1 + in2] += carry;

			in1++;
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			while(true) {
				System.out.println("1. Multiply String");
				System.out.println("0. Exit");
				System.out.println("Enter your choice:");				// Take choice from user
				String choice = scanner.nextLine();
				if("0".equals(choice)) {
					System.out.println("Ending the program");			// Stop execution
					break;
				} else if("1".equals(choice)) {
						System.out.println("Enter first number:");		// Fetch number value from user
						String str1 = scanner.nextLine();
						System.out.println("Enter second number:");
						String str2 = scanner.nextLine();
						String sign = "";
				
						if ((str1.charAt(0) == '-' || str2.charAt(0) == '-') &&
							(str1.charAt(0) != '-' || str2.charAt(0) != '-'))
							sign = "-";
				
						if (str1.charAt(0) == '-')
							str1 = str1.substring(1);
				
						if (str2.charAt(0) == '-')
							str2 = str2.substring(1);
				
						System.out.println("Multiplication is : "+sign+multiply(str1, str2)+"\n");					
				} else {
					System.out.println("Invalid Input");
				}
			}
		} catch (Exception e) {
			System.out.println("Exception occurred:"+e);
		} finally {
			if(scanner != null)
				scanner.close();
		}
	}
}