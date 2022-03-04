package string.find_sub_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		String str = "abcde";
		String str1 = "hello";
//		System.out.println(Arrays.toString(findSubString(str)));
//		System.out.println("length: " + lengthOfString(str));
//		System.out.println(unicodePoint(str,3));
//		compare2Strings(str, str1);
//		createStrFromcharacterArr();
//		endsWithContents();
//		convertStringToByteArray();
//		stringToChars();
//		getAllIndexAlphabet();
//		replaceCharacterWithAnother();
		
//		checkStarts();
		findLongestPalindromic();
	}
	
	// Find longest Palindromic : thequickbrownfoxxofnworbquickthe
	static void findLongestPalindromic() {
		String str = "forgeeksskeegforthequickbrownfoxxofnworbquickthe";
		
		TreeSet<String> listPalinds = new TreeSet<String>(new Comparator<String>() {
			public int compare(String str1, String str2) {
				int lengthOfStr1 = str1.length();
				int lengthOfStr2 = str2.length();
				
				if (lengthOfStr1 == lengthOfStr2) {
					return 0;
				} else if (lengthOfStr1 > lengthOfStr2) {
					return 1;
				} else {
					return -1;
				}
			}
		});
		
		for (int i = 0; i < str.length() - 1; i++) {
			
			// Get 2 characters to check
			String twoChars = str.substring(i, i + 2);
			
			// Reverse strChecking
			String strChecking = twoChars.substring(1, 2) + twoChars.substring(0, 1); 
			
			// Find the same characters in the rest of string
			int index = str.indexOf(strChecking);
				
			// Not found
			if (index == -1) {
				continue;
			}
			
			// Found
			String strCheckPalind = str.substring(i, index + 2);
			int checkLength = strCheckPalind.length();
			boolean isPalind = true;
			for (int j = 0; j < checkLength/2; j++) {
				char head = strCheckPalind.charAt(j);
				char tail = strCheckPalind.charAt(checkLength - j - 1);
				
				if (head != tail) {
					isPalind = false;
					break;
				}
			}
			
			if (isPalind == true) {
				listPalinds.add(strCheckPalind);
				str = str.substring(i + checkLength);
			}
		}
		
		Iterator<String> iterator = listPalinds.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	// Check string is start with another
	static void checkStarts() {
		String checking = "Red";
		String str = "Red color";
		String str2 = "Blue color";
		
		int firstStr = str.indexOf(checking);
		int firstStr2 = str2.indexOf(checking);
		System.out.println(firstStr);
		System.out.println(firstStr2);
	}
	
	// Replace a character with another character
	static void replaceCharacterWithAnother() {
		String str = "abcdaaa";
		
//		str = str.replace('a', 'f');
		str = str.replaceFirst("abc", "be oi ");
		System.out.println(str);
	}
	
	
	// Get index of all the characters of alphabet
	static void getAllIndexAlphabet() {
		
		for (int i = 'a'; i <= 'z'; i++) {
			System.out.print(i + " ");
		}
	}
	
	
	// Convert String to CharArray
	static void stringToChars() {
		String str = "abcd";
		char[] charArr = str.toCharArray();
		for (char c : charArr) {
			System.out.println(c);
		}
		str.toLowerCase();
		str.toUpperCase();
	}
	
	
	
	
	
	
	
	
	
	
	// Convert String to Byte Array
	static void convertStringToByteArray() {
		String str = "abcd";
		byte[] bArr = new byte[str.length()];
		
		for (int i = 0; i < str.length(); i++) {
			int cNum = str.charAt(i);
			bArr[i] = (byte)cNum;
		}
		
		for (byte b : bArr) {
			System.out.println(b);
		}
	}
	
	
	// Check whether a given string ends with the contents another string
	static boolean endsWithContents() {
		String check = "se";
		String str = "Excerse";
		
		int lastIndex = str.lastIndexOf(check);
		
		// 7 = 5 + 2 
		if (str.length() == check.length() + lastIndex) {
			System.out.println("True");
			return true;		
		}
		System.out.println("False");
		return false;
	}
	
	
	
	
	// Create String from character arrays
	static void createStrFromcharacterArr() {
		char[] charArr = new char[] { 'a', 'b', 'c' };

		String str = new String(charArr);
		System.out.println(str);
	}

	// Compare two string
	static void compare2Strings(String str1, String str2) {
		int equal = str1.compareTo(str2);

		if (equal > 0) {
			System.out.println(str1 + " is greater than " + str2);
		} else if (equal == 0) {
			System.out.println(str1 + " is equals with " + str2);
		} else {
			System.out.println(str1 + " is less than " + str2);
		}
	}

	// return character code
	static int unicodePoint(String str, int index) {
		int ch = str.charAt(index);

		return ch;
	}

	// abcd
	static String[] findSubString(String str) {
		if (str.length() == 0)
			return null;

		ArrayList<String> listSubs = new ArrayList<>();

		for (int i = 0; i < str.length(); i++) {
			String subStr = "";

			for (int j = i + 1; j <= str.length(); j++) {
				subStr = str.substring(i, j);
				listSubs.add(subStr);
			}
		}

		String[] subArr = listSubs.toArray(new String[0]);

		return subArr;
	}

	// return length of str without using methods inbuild
	static int lengthOfString(String str) {

		// convert to char array
		char[] chArr = str.toCharArray();

		// count characters
		int count = 0;
		for (char c : chArr) {
			count++;
		}

		return count;
	}

	static void printPermutn(String str, String ans) {

		// If string is empty
		if (str.length() == 0) {
			System.out.println(ans + " ");
			return;
		}

		for (int i = 0; i < str.length(); i++) {

			// ith character of str
			char ch = str.charAt(i);
			// Rest of the string after excluding
			// the ith character
			String ros = str.substring(0, i) + str.substring(i + 1);

			// Recurvise call
			printPermutn(ros, ans + ch);
		}
	}

}
