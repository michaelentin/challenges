/**
 * @author michaelentin
 */

package challenges;

import java.util.ArrayList;

/**
 * @author michaelentin
 *
 */
public class Strings {

	public Strings()
	{
		
	}
	
	
	/**
	 * @param word word to check
	 * @return whether or not the string is a palindrome
	 */
	public boolean CheckForPalindrome(String word)
	{
		// get rid of any whitespace
		word.trim();
		
		// if not a real word, get outta here 
		if (word.length() == 0)
		{
			return false;
		}
		
		// utilize string buffer's powers
		StringBuffer wordy = new StringBuffer(word);
		
		// check for not a palindrome
		if (!wordy.reverse().toString().equals(word))
		{
			return false;
		}
		
		return true;
	}
	
	
	/**
	 * @param word any word
	 * @param character the character to be removed from the word
	 * @return the word without any of the characters in it
	 */
	public String RemoveCharacter(String word, char character)
	{
		String newString = "";
		
		newString = word.replaceAll(String.valueOf(character), "");
		
		return newString;
		
	}
	
	public ArrayList<String> GetPermutations(String word)
	{
		ArrayList<String> perms = new ArrayList<String>();
		
		int length = word.length() - 1;
		
		permute(word, 0, length, perms);
		
		return perms;
	}
	
	private void permute(String word, int startIndex, int endIndex, ArrayList<String> perms)
	{
		if (startIndex == endIndex)
		{
			perms.add(word);
		}
		else
		{
			// go from the start of the word to the end of it
			for (int i = startIndex; i <= endIndex; i++)
			{
				// swap beginning and i
				word = swap(word, startIndex, i);
			
				// go to the next level of recursion
				permute(word, startIndex + 1, endIndex, perms);
				
				// reorder for going back up
				word = swap(word, startIndex, i);
			}
		}
		
		return;
	}


	private String swap(String word, int startIndex, int thisIndex) {
		char temp; 
		char[] charArray = word.toCharArray();
		
		temp = charArray[startIndex];
		charArray[startIndex] = charArray[thisIndex];
		charArray[thisIndex] = temp;
		
		return String.valueOf(charArray);
	}

}
