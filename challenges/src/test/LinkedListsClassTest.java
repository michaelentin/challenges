package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import org.junit.*;

import challenges.LinkedListsClass;

public class LinkedListsClassTest {

	LinkedListsClass lists;
	
	@Before
	public void Setup()
	{
		lists = new LinkedListsClass();
	}
	
	@Test
	public void TestFindMiddleInOnePassOddNumOfElements()
	{
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		Integer[] arrayBoi = new Integer[] {4, 1, 6, 8, 1, 11, 0, 9, 1};
		list.addAll(Arrays.asList(arrayBoi));
		
		int expected = 1;
		int value = lists.FindMiddleOfLinkedListOnePass(list);
		
		assertEquals(expected, value);
	}
	
	@Test
	public void TestFindMiddleInOnePassEvenNumOfElements()
	{
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		Integer[] arrayBoi = new Integer[] {4, 1, 6, 8, 1, 0, 9, 1};
		list.addAll(Arrays.asList(arrayBoi));
		
		int expected = 8;
		int value = lists.FindMiddleOfLinkedListOnePass(list);
		
		assertEquals(expected, value);
	}
	
	
}
