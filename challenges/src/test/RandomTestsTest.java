package test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import challenges.SortingAlgos;

public class RandomTestsTest {
	
	SortingAlgos sorters;
	
	@Before
	public void Setup()
	{
		sorters = new SortingAlgos();
	}

	@Test
	public void IncrementerTest()
	{
		int[] array = new int[50];
		int i = 4;
		int a = i++;
		i = 4;
		int b = ++i;
		
		i = 5;
		
		array[i++] = ++i + i++;
		
		// after this, i = 8 & array[5] = 14
		
		
		System.out.println("i: " + i);
		System.out.println("at 5: " + array[5]);
		
	}
	
	@Test
	public void QuickSortTest()
	{
		int[] nums = new int[] {4, 7, 1, 9, 2, 3, 0, 1, 1, 8, 3, 6};
		sorters.SetArray(nums);
		
		sorters.RunQuickSort();
		
		assertTrue(isSorted(sorters.GetArray()));
	}
	
	@Test
	public void MergeSortTest()
	{
		int[] nums = new int[] {4, 7, 1, 9, 2, 3, 0, 1, 1, 8, 3, 6};
		sorters.SetArray(nums);
		
		sorters.RunMergeSort();
		sorters.PrintArray();
		
		assertTrue(isSorted(sorters.GetArray()));
	}
	
	@Test(expected = NullPointerException.class)
	public void QuickSortEmptyArray()
	{
		sorters.RunQuickSort();
	}
	
	private boolean isSorted(int[] nums)
	{
		if (nums.length <= 1) return true;
		
		for (int i = 1; i < nums.length; i++)
		{
			if (nums[i] < nums[i-1]) return false;
		}
		
		return true;
	}
	
}
