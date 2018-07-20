package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import challenges.ArraysClass;
import challenges.Strings;

public class ArraysClassTest {
	
	ArraysClass arrayz = new ArraysClass();
	
	@Before
	public void init()
	{
		arrayz = new ArraysClass();
	}
	
	@Test
	public void FirstTest()
	{
		int[] nums = new int[]{1, 2, 3, 4, 9, 8};
		int count = 10;
		
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(5);
		expected.add(6);
		expected.add(7);
		expected.add(10);
		
		ArrayList<Integer> value = arrayz.GetMissingNumbers(nums, count);
		
		assertEquals(expected, value);
	}
	
	@Test
	public void FindDuplicateInArray()
	{
		int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7, 4};
		
		int expected = 4;
		int value = arrayz.FindDuplicateNumber(nums);
		
		assertEquals(expected, value);
	}
	
	@Test
	public void NoDuplicateInArray()
	{
		int[] nums = new int[] {1, 2, 3, 4, 5, 6};
		
		int expected = -1;
		int value = arrayz.FindDuplicateNumber(nums);
		
		assertEquals(expected, value);
	}
	
	@Test
	public void ArrayOfSizeZeroDuplicates()
	{
		int[] nums = new int[] {};
		
		int expected = -1;
		int value = arrayz.FindDuplicateNumber(nums);
		
		assertEquals(expected, value);
	}
	
	@Test
	public void FindAllDupesTest()
	{
		int[] nums = new int[] {1, 2, 2, 4, 5, 7, 6, 5, 3, 0};
		
		HashSet<Integer> expected = new HashSet<Integer>();
		expected.add(2);
		expected.add(5);
		
		HashSet<Integer> value = arrayz.FindAllDuplicates(nums);
		
		assertEquals(expected, value);
	}
	
	@Test
	public void FindAllDupesWithNoDupes()
	{
		int[] nums = new int[] {1, 2, 3, 4, 5};
		
		HashSet<Integer> expected = new HashSet<Integer>();
		HashSet<Integer> value = arrayz.FindAllDuplicates(nums);
		
		assertEquals(expected, value);
	}
	
	@Test
	public void FindSecondHighestNumber()
	{
		int[] nums = new int[] {2, 4, 7, 4, 8, 9, 0, 22, 44, 5, 3, 64, 27, 39};
		
		int expected = 44;
		int value = arrayz.FindSecondHighestNumber(nums);
		
		assertEquals(expected, value);
	}
	
	@Test
	public void FindSecondHighestNumberArraySizeOne()
	{
		int[] nums = new int[] {2};
		
		int expected = 2;
		int value = arrayz.FindSecondHighestNumber(nums);
		
		assertEquals(expected, value);
	}
	
	@Test
	public void FindSecondHighestNumberArraySizeTwoDifferentNums()
	{
		int[] nums = new int[] {2, 4};
		
		int expected = 2;
		int value = arrayz.FindSecondHighestNumber(nums);
		
		assertEquals(expected, value);
	}
	
	@Test
	public void FindSecondHighestNumberArraySizeTwoSameNums()
	{
		int[] nums = new int[] {2, 2};
		
		int expected = 2;
		int value = arrayz.FindSecondHighestNumber(nums);
		
		assertEquals(expected, value);
	}
	
	@Test
	public void FindSecondHighestNumberEmptyArray()
	{
		int[] nums = new int[] {};
		
		int expected = -1;
		int value = arrayz.FindDuplicateNumber(nums);
		
		assertEquals(expected, value);
	}
	
}
