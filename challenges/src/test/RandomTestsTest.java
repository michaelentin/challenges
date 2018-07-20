package test;

import org.junit.Test;

public class RandomTestsTest {

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
	
}
