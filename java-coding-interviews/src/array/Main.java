package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) {
		int[] nums = new int[]{20, 40, 50, 40, 50, 20, 30, 30, 50, 20, 40, 40, 20, 20};
		int[] nums2 = new int[] {1, 60, -10, 70, -80, 85};
		int[] nums3 =  new int[]{ -40, -5, 1, 3, 6, 7, 8, 20 };
		int[] zerosAndOnes = new int[] {0,1,0,0,1,1,1,0,1};
		int[] oddEvenArr = new int[] {12, 17, 70, 15, 22, 65, 21, 90};
		int[] zerosOnesTwos = new int[] {1, 2, 2, 0, 0, 1, 2, 2, 1};
		// findNumberOcurrOdd(nums);
		
//		minimumNumberOfPlatformForTheRailway();
		
//		findPairSumClosestZero(nums2);
//		findPairSumClossestX(nums2, 50);
//		findAllPairSumEqualX(nums3, 15);
		
//		separateZerosAndOnes(zerosAndOnes);
//		separateOddEven(oddEvenArr);
//		sortGivenArray(zerosOnesTwos);
		String s1 = "abc";
		String s2 = "abc";
		System.out.println(s1 == s2);
	}
	
	// 
	
	// ARRAY 0, 1, 2 -< O(N)
	static void sortGivenArray(int[] nums) {
		TreeMap<Integer, Integer> numsCount = new TreeMap<>();
		
		// count number of element
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			
			if (numsCount.containsKey(num)) {
				int quantity = numsCount.get(num);
				numsCount.put(num, quantity + 1);
			} else {
				numsCount.put(num, 1);
			}
		}
		
		// assign to a new array with ascending order

		ArrayList<Integer> sortedList = new ArrayList<>();
		Set<Map.Entry<Integer, Integer>> numsCountEntry = numsCount.entrySet();
		
		int index = 0;
		for (Map.Entry<Integer, Integer> element : numsCountEntry ) {
			int length = element.getValue();
			
			for (int i = 0; i < length; i++) {
				sortedList.add(element.getKey());
			}
		}
		
		Integer[] sortedArr = sortedList.toArray(new Integer[0]);
		for (int num : sortedArr) {
			System.out.println(num);
		}
	}
	
	
	
	
	
	
	// SEPARATE ODD AND EVEN NUMBERS IN AN ARRAY
	static void separateOddEven(int[] nums) {
		if (nums.length == 0) {
			return;
		}
		
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				
				if ((nums[i] % 2 != 0) && (nums[j] % 2 == 0)) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
		}
		
		for (int num : nums) {
			System.out.print(num + " ");
		}
	}
	
	
	
	
	
	// SEPARATE 0 AND 1 in a array
	static void separateZerosAndOnes(int[] nums) {
		
		// Solution 1
//		 Arrays.sort(nums);
		
		for (int i = 0; i < nums.length; i++) {
			
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] > nums[j]) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
		}
		
		for (int num : nums) {
			System.out.println(num);
		}
	}
	
	// FIND ALL PAIRS of elements from an array whose sum is equal to given number
	static void findAllPairSumEqualX(int[] nums, int x) {
		
		ArrayList<ArrayList<Integer>> listResults = new ArrayList<>();
		
		for (int i = 0; i < nums.length; i++) {
			ArrayList<Integer> result = new ArrayList<Integer>();
			
			for (int j = i + 1; j < nums.length; j++) {
				int sum = nums[i] + nums[j];
				
				if (sum == x) {
					result.add(nums[i]);
					result.add(nums[j]);
					listResults.add(result);
				}
			}
		}
		
		for (List<Integer> result : listResults) {
			for (int num : result) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
	
	
	
	
	// FIND PAIR IN ARRAY SUM IS CLOSSEST TO X
	static void findPairSumClossestX(int[] nums, int x) {
		
		int minDistance = Integer.MAX_VALUE;
		int firstIndex = 0;
		int secondIndex = 0;
		
		Loop1: for (int i = 0; i < nums.length; i++) {
			for (int j = i +1; j < nums.length; j++) {
				int distance = Math.abs(x -  nums[i] + nums[j]); 
				
				if (distance == 0) {
					minDistance = distance;
					firstIndex = i;
					secondIndex = j;
					break Loop1;
				}
				
				if (minDistance > distance) {
					minDistance = distance;
					firstIndex = i;
					secondIndex = j;
				}
			}
		}
		System.out.println(nums[firstIndex] + " - " + nums[secondIndex]);
	}
	
	// FIND A PAIR WHOSE SUM IS CLOSEST TO ZERO IN ARRAY
	
	static void findPairSumClosestZero(int[] nums) {
		ArrayList<Integer> listNegative = new ArrayList<>();
		ArrayList<Integer> listPositive = new ArrayList<>();
		
		for (int i =0; i < nums.length ; i++) {
			int num = nums[i];
			
			if (num < 0) {
				listNegative.add(num);		
			} else {
				listPositive.add(num);
			}
		}
		
		// Create result
		int[] result = new int[3]; // 0: min-distance, 1: f num, 2: s num
		result[0] = Integer.MAX_VALUE;
		
		// Calculate distance of each pair value
		NEGALOOP: for (int neNum : listNegative) {
			
			for (int poNum : listPositive) {
				int distance = Math.abs((Math.abs(neNum) - poNum));
				
				// if poNum == |neNum|
				if (distance == 0) {
					result[0] = 0;
					result[1] = poNum;
					result[2] = neNum;
					break NEGALOOP;
				}
				
				if (distance < result[0]) {
					result[0] = distance;
					result[1] = poNum;
					result[2] = neNum;
				}
			}
		}
		
		System.out.println(result[0] + " - " + result[1] + " - " + result[2]);
	}
	
	
	
	
	
	
	
	
	
	
	
	// MINIMUM NUMBER OF PLATFORMS REQUIRE FOR THE RAILWAY STATION SO THAT NO TRAIN WAITS
	static void minimumNumberOfPlatformForTheRailway() {
		String[] arrivals = new String[]{"9:00", "9:40", "9:50", "11:00", "11:20", "18:00"};
		String[] deps = new String[]{"9:10", "12:00", "11:20", "11:30", "19:00", "20:00"};
		
		
		int aIndex = 0; 
		int dIndex = 0;
		int plat = 0;
		int minimum = 0;
		
		while(aIndex < arrivals.length && dIndex < deps.length) {
			
			 String[] depTimeStr = deps[dIndex].split(":");
			 int[] depTime = new int[2];
			 
			 // Set dep Hour 
			 depTime[0] = Integer.parseInt(depTimeStr[0]);
			
			 // Set dep minutes
			 depTime[1] = Integer.parseInt(depTimeStr[1]);
			 

			 String[] arrTimeStr = arrivals[aIndex].split(":");
			 int[] arrTime = new int[2];	
			 
			 // set arrival HOUR
			 arrTime[0] = Integer.parseInt(arrTimeStr[0]);	 
			 
			 // set arrival MINUTES
			 arrTime[1] = Integer.parseInt(arrTimeStr[1]);
			 
			 if (depTime[0] == arrTime[0]) {
				 
				 if (arrTime[1] <= depTime[1]) {
					 plat++;
					 aIndex++;
				 } else {
					 dIndex++;
					 plat = 0;
				 }
				 
			 } else if (depTime[0] > arrTime[0]) {
				 aIndex++;
				 plat++;
			 } else {
				 dIndex++;
				 plat = 0;
			 } 
			 
			 if (plat > minimum) {
				 minimum = plat;
			 }
		}
		System.out.println(minimum);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	// FIND NUMBER OCCURR ODD TIME
	static void findNumberOcurrOdd(int[] nums) {
		HashMap<Integer, Integer> numsCount = new HashMap<>();
		
		// Count each number
		for ( int i = 0; i < nums.length; i++) {
			int key = nums[i];
			
			if (numsCount.containsKey(key)) {
				numsCount.put(key, numsCount.get(key) + 1);
			} else {
				numsCount.put(key, 1);
			}
		}
		
		// Check odd number of times
		Set<Map.Entry<Integer, Integer>> numsCountEntry = numsCount.entrySet();
		for (Map.Entry<Integer, Integer> el : numsCountEntry) {
			if (el.getValue() % 2 != 0) {
				System.out.println(el.getKey());
			}
		}
	}
}
