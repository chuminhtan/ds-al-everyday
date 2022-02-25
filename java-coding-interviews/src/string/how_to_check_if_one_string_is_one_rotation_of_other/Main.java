package string.how_to_check_if_one_string_is_one_rotation_of_other;

// Q: check whether str1 and str2 is rotation of one another or not.

public class Main {

	static boolean checkRotation(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		
		// Create str3 is double str1
		String str3 = str1 + str1;
		
		// If str3 contains str2, then str2 is a rotation of str1
		return str3.contains(str2);
	}
	
	
	public static void main(String[] args) {
		
		String str1 = "hello";
		String str2 = "llohe";
		String str3 = "lloeh";
		
		System.out.println("Test 1: " + checkRotation(str1, str2));
		System.out.println("Test 1: " + checkRotation(str1, str3));
	}
	
	

}
