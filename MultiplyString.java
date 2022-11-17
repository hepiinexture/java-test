import java.util.*;

class MultiplyString {
	static String multiply(String value1, String value2) {
		int len1 = value1.length();
		int len2 = value2.length();
		if (len1 == 0 || len2 == 0)
			return "0";


		int result[] = new int[len1 + len2];

		int in1 = 0;
		int in2 = 0;
		
		for (int i = len1 - 1; i >= 0; i--) {
			int carry = 0;
			int n1 = value1.charAt(i) - '0';
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
		
		int i = result.length - 1;
		while (i >= 0 && result[i] == 0)
		i--;

		if (i == -1)
		return "0";

		String s = "";
		
		while (i >= 0)
			s += (result[i--]);

		return s;
	}

	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter first number:");
			String str1 = scanner.nextLine();
			System.out.println("Enter second number:");
			String str2 = scanner.nextLine();
	
			if ((str1.charAt(0) == '-' || str2.charAt(0) == '-') &&
				(str1.charAt(0) != '-' || str2.charAt(0) != '-'))
				System.out.print("-");
	
			if (str1.charAt(0) == '-')
				str1 = str1.substring(1);
	
			if (str2.charAt(0) == '-')
				str2 = str2.substring(1);
	
			System.out.println("Multiplication of "+str1+" and "+ str2+ " is : "+multiply(str1, str2));
		} catch (Exception e) {
			System.out.println("Exception occurred:"+e);
		}
	}
}
