/**
 * @author michaelentin
 */

package challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

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
	public boolean CheckForPalindrome(String word) throws NullPointerException
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
	public String RemoveCharacter(String word, char character) throws NullPointerException
	{
		String newString = "";
		
		newString = word.replaceAll(String.valueOf(character), "");
		
		return newString;
		
	}
	
	/**
	 * @param word any word
	 * @return an array list of all the possible permutations of that word (string)
	 */
	public ArrayList<String> GetPermutations(String word) throws NullPointerException
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
	
	/**
	 * @param word any word
	 * @return the longest palindrome inside the word, empty string otherwise
	 */
	public String LongestPalindrome(String word) throws NullPointerException
	{
		// set string to return
		String longestPalindrome = "";
		
		// we'll want to start at the whole word
		int checkLength = word.length();
		
		// go through each length of possible substrings
		for (int i = checkLength; i >= 3; i--)
		{
			// in each of those lengths, we'll need to iterate through each possible substring of that size
			for (int j = 0; j <= checkLength - i; j++)
			{
				// so to get the next substring, we take where we are at in the string & go to the # of lengths away
				String sub = word.substring(j, j + i);
				
				// use our other function to check for palindrome
				boolean isPalindrome = CheckForPalindrome(sub);
				
				// if it's a palindrome & it's bigger, add it
				if (isPalindrome && longestPalindrome.length() < sub.length())
				{
					longestPalindrome = sub;
				}
			}
		}
		
		return longestPalindrome;
	}
	
	/**
	 * @param word any word
	 * @return the first non repeated character, or space otherwise
	 */
	public char FindFirstNonRepeatedChar(String word)
	{
		word = word.toLowerCase();
		char[] letters = word.toCharArray();
		for (int i = 0; i < letters.length; i++)
		{
			char currentChar = letters[i];
			int indexOfFirst = word.indexOf(currentChar);
			int indexOfLast = word.lastIndexOf(currentChar);
			System.out.println(currentChar + ": " + indexOfFirst + ", " + indexOfLast);
			if (indexOfLast == indexOfFirst)
			{
				return letters[i];
			}
		}
		return ' ';
	}
	
	/**
	 * @param haystack any word or sentence
	 * @param needle the character to count
	 * @return the first non repeated character, or space otherwise
	 */
	public int CountOccurenceOfCharInString(String haystack, char needle)
	{
		char[] letters = haystack.toCharArray();
		int count = 0;
		for (char letter: letters)
		{
			if (letter == needle) count++;
		}
		
		return count;
	}
	
	public boolean CheckForAnagram(String word1, String word2)
	{
		char[] array1 = word1.toCharArray();
		char[] array2 = word2.toCharArray();
		
		Arrays.sort(array1);
		Arrays.sort(array2);
		
		if (Arrays.equals(array1, array2)) return true;
		return false;
	}
	
	public int ConvertStringToInt(String number)
	{
		return Integer.parseInt(number);
	}
	
	public String ReverseStringRecursively(String toReverse)
	{
		if (toReverse == null || toReverse.length() <= 1) return toReverse;
		return ReverseStringRecursively(toReverse.substring(1)) + toReverse.charAt(0);
	}
	
	public boolean DoesStringContainOnlyDigits(String str)
	{
		if (str == null || str == "") return false;
		Pattern pattern = Pattern.compile(".*[^0-9].*");
		
		return !pattern.matcher(str).matches();
	}

}
