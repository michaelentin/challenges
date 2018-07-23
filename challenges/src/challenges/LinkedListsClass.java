package challenges;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListsClass {
	
	public LinkedListsClass()
	{
		
	}
	
	public int FindMiddleOfLinkedListOnePass(LinkedList<Integer> list)
	{
		int count = 0;
		ListIterator<Integer> fullIterator = list.listIterator();
		ListIterator<Integer> halfIterator = list.listIterator();
		int toReturn = 0;
		
		
		while (fullIterator.hasNext())
		{
			count++;
			
			if (count % 2 == 0)
			{
				toReturn = halfIterator.next();
			}
			
			fullIterator.next();
		}
		
		if (count % 2 == 1)
		{
			toReturn = halfIterator.next();
		}
		
		return toReturn;
	}

	
}
