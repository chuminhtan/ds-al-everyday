package string.how_to_check_if_2_string_are_anagrams;

public class Main {

	public static void main(String[] args) {
		
		String word = "hello";
		String anagram = "olleh";
		String anagram2 = "abcd";
		
		System.out.println("test 1: " + isAnagramUsingStringMethods(word, anagram));
		System.out.println("test 2: " + isAnagramUsingStringMethods(word, anagram2));
	}
	
	// using string method
	static boolean isAnagramUsingStringMethods(String word, String anagram) {
		
		if (word.length() != anagram.length()) {
			return false;
		}
		
		for (int i = 0 ; i < word.length(); i++) {
			char c = word.charAt(i);
			
			int index = anagram.indexOf(c);
			
			// if index = -1 => anagram doesn't contain c => false
			// if index != -1 => anagram contains c => remove c in anagram
			if (index == -1) {
				return false;
			} else {
				anagram = anagram.substring(0,index) + anagram.substring(index + 1, anagram.length());
			}
		}
		
		return anagram.isEmpty();
	}

}
