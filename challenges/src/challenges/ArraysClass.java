package challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;

public class ArraysClass {
	
	public ArraysClass()
	{
		
	}
	
	public ArrayList<Integer> GetMissingNumbers(int[] numbers, int count) 
	{ 
		
		ArrayList<Integer> missingNumbers = new ArrayList<Integer>();
		
		if (numbers == null) return missingNumbers;
		
		int missingCount = count - numbers.length; 
		BitSet bitSet = new BitSet(count);
		for (int number : numbers) 
		{ 
			bitSet.set(number - 1); 
		} 
		
		//System.out.printf("Missing numbers in integer array %s, with total number %d is %n", Arrays.toString(numbers), count); 
		
		int lastMissingIndex = 0; 
		for (int i = 0; i < missingCount; i++) 
		{ 
			lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
			missingNumbers.add(++lastMissingIndex); 
			//System.out.println(lastMissingIndex);
		}
		
		return missingNumbers;
	}
	
	public int FindDuplicateNumber(int[] numbers)
	{
		if (numbers == null) return -1;
		
		Arrays.sort(numbers);
		
		for (int i = 1; i < numbers.length; i++)
		{
			if (numbers[i] == numbers[i-1]) return numbers[i];
		}
		
		return -1;
	}
	
	public HashSet<Integer> FindAllDuplicates(int[] numbers)
	{
		HashSet<Integer> dupes = new HashSet<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		if (numbers == null) return dupes;
		
		for (int num: numbers)
		{
			if (map.containsKey(num))
			{
				dupes.add(num);
			}
			else
			{
				map.put(num, 1);
			}
		}
		
		return dupes;
	}
	
	public ArrayList<Integer> FindNumberNotInSecondArray(int[] num1, int[] num2)
	{
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		ArrayList<Integer> notInSecond = new ArrayList<Integer>();
		
		if (num1 == null || num2 == null) return notInSecond;
		
		for (int num: num2)
		{
			map.put(num, 0);
		}
		
		for (int num: num1)
		{
			if (!map.containsKey(num)) notInSecond.add(num);
		}
		
		return notInSecond;
	}
	
	public int FindSecondHighestNumber(int[] arree)
	{
		if (arree == null || arree.length == 0) return -1;
		
		int highestNumber = arree[0];
		int nextHighest = arree[0];
		
		for (int num: arree)
		{
			if (num > highestNumber)
			{
				nextHighest = highestNumber;
				highestNumber = num;
			}
			else if (num > nextHighest)
			{
				nextHighest = num;
			}
		}	
		
		return nextHighest;
	}
	
	public void PrintAllPairsThatEqualSum(int[] nums, int toFind)
	{
		// sort the array
		Arrays.sort(nums);
		
		int leftIndex = 0;
		int rightIndex = nums.length - 1;
		
		while (leftIndex < rightIndex)
		{
			int sum = nums[leftIndex] + nums[rightIndex];
			
			if (sum == toFind)
			{
				// found, save nums then move pointers
				System.out.println(nums[leftIndex] + ", " + nums[rightIndex]);
				leftIndex += 1;
				rightIndex -= 1;
			}
			else if (sum < toFind)
			{
				// sum is less than toFind, increase left side
				leftIndex += 1;
			}
			else
			{
				// sum is greater than toFind, decrease right side
				rightIndex -= 1;
			}
		}
	}
	
	public int[] RemoveAllDuplicatesFromArray(int[] nums)
	{
		Arrays.sort(nums);
		
		int[] newArray = new int[nums.length];
		int count = 0;
		int previous = nums[0];
		
		for (int i = 1; i < nums.length; i++)
		{
			int num = nums[i];
			
			if (num != previous)
			{
				newArray[count++] = num;
			}
			
			previous = num;
		}
		
		return newArray;
	}
	
	public void PrintLargestAndSmallestNumbers(int[] nums)
	{
		int smallestNum = Integer.MAX_VALUE;
		int largestNum = Integer.MIN_VALUE;
		
		for (int num: nums)
		{
			if (num > largestNum)
			{
				largestNum = num;
			}
			
			if (num < smallestNum)
			{
				smallestNum = num;
			}
		}
		
		System.out.println(smallestNum);
		System.out.println(largestNum);
	}
	
}

	
