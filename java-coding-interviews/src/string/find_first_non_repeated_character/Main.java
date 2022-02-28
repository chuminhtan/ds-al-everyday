package string.find_first_non_repeated_character;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

// Find first non repeated character in a String

public class Main {

	public static void main(String[] args) {
		String str1 = "abcdeab";
		String str2 = "aabbccdd";
		System.out.println("Test 1: " + findFirstNonRepeatedCharacter(str1));
		System.out.println("Test 2: " + findFirstNonRepeatedCharacter(str2));

	}

	static Character findFirstNonRepeatedCharacter(String str) {
		if (str.length() < 1) {
			return null;
		}
		
		LinkedHashMap<Character, Integer> countCharacters = new LinkedHashMap<>();
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if (countCharacters.containsKey(c)) {
				int value = countCharacters.get(c);
				countCharacters.put(c, value + 1);
			} else {
				countCharacters.put(c,1);
			}
		}
		
		Set<Entry<Character, Integer>> entrySet =  countCharacters.entrySet();
		for (Entry<Character, Integer> entry : entrySet) {
			if (entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		
		return null;
	}
 }
