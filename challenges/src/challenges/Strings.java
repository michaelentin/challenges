/**
 * @author michaelentin
 */

package challenges;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Strings {

	public Strings()
	{
		
	}
	
	
	/**
	 * @param word word to check
	 * @return whether or not the string is a palindrome
	 * @throws NullPointerException if word is null
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
	 * @throws NullPointerException if word is null
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
	 * @throws NullPointerException if word is null
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
	 * @throws NullPointerException if word is null
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
	 * @param word any string that is a word
	 * @return the first non repeating character in the word, space otherwise
	 * @throws NullPointerException if word is null
	 */
	public char FindFirstNonRepeatingCharacter(String word) throws NullPointerException
	{
		// use a set for the repeating (as order doesn't matter) and an array list for non repeating (first in the list is first non repeating)
		Set<Character> repeating = new HashSet<>();
		ArrayList<Character> nonRepeating = new ArrayList<>();
		
		for (int i = 0; i < word.length(); i++)
		{
			char at = word.charAt(i);
			
			// if it's already in the repeating category, there's no real need to keep check
			if (repeating.contains(at))
			{
				continue;
			}
			
			// if in non-repeating, take it out and put it in the repeating
			if (nonRepeating.contains(at))
			{
				// character cast so as to not confuse for index
				nonRepeating.remove((Character) at);
				repeating.add(at);
			}
			// else, just add to nonRepeating
			else
			{
				nonRepeating.add(at);
			}
		}

		// if no non repeating characters, return a space
		if (nonRepeating.size() > 0)
		{
			return nonRepeating.get(0);
		}
		else
		{
			return ' ';
		}
	}
	
	/**
	 * @param word a string in the form of a word
	 * @param character the character we will be counting the number of times it occurs in the word
	 * @return the number of times character appears in word
	 * @throws NullPointerException if word is null
	 */
	public int CountOccurencesOfCharacter(String word, char character) throws NullPointerException
	{
		int numOccurences = 0;
		
		word = word.toLowerCase();
		character = Character.toLowerCase(character);
		
		// simple loop is good enough
		for (int i = 0; i < word.length(); i++)
		{
			if (word.charAt(i) == character)
			{
				numOccurences++;
			}
		}
		
		return numOccurences;
	}
}
