package string.find_duplicate_characters;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;



// Find duplicate characters in a string
public class Main {
	static char[] getDuplicatedCharacters(String str) {
		char[] dupChars = new char[str.length()];

		if (str.length() < 2) {
			return dupChars;
		}
		
		HashMap<Character, Integer> container = new HashMap<>();
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if (container.containsKey(c)) {
				int value = container.get(c);
				container.put(c, value + 1);
			} else {
				container.put(c, 1);
			}
		}
		
		Set<Map.Entry<Character, Integer>> entrySet = container.entrySet();
		
		int index = 0;
		for (Map.Entry<Character, Integer> entry : entrySet) {
			if (entry.getValue() > 1) {
				dupChars[index++] = entry.getKey();
			}
		}
		
		return dupChars;
	}
	
	
	public static void main(String[] args) {
		String str = "hello Ajinomoto h";
		
		char[] dupChars = getDuplicatedCharacters(str);
		
		for(char c : dupChars) {
			System.out.print(c + "\t");
		}

	}

}
