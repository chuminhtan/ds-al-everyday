package string.how_to_reverse_a_string_in_java;

public class Main {

	public static void main(String[] args) {	
		String str = "hello guy";
		System.out.println("Str original: " + str);
		StringBuilder strBuilder = new StringBuilder(str);
		strBuilder.reverse();
		
		String strReversed = strBuilder.toString();
		System.out.println("Str reversed: " + strReversed);
	}
}
