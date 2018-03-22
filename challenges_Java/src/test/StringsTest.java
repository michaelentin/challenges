/**
 * @author michaelentin
 */

package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import challenges.Strings;
import junit.framework.Assert;

public class StringsTest {

	Strings strings;
	
	@Before
	public void init()
	{
		strings = new Strings();
	}
	
	@Test
	public void CheckForPalindromeTwoDifferentSizeStrings() {
		String word = "word";
		
		boolean expected = false;
		boolean value = strings.CheckForPalindrome(word);
		
		assertEquals(expected, value);
	}
	
	@Test
	public void CheckForPalindromeCorrectInput() {
		String word = "racecar";
		
		boolean expected = true;
		boolean value = strings.CheckForPalindrome(word);
		
		assertEquals(expected, value);
	}
	
	@Test
	public void CheckForPalindromeEmptyString() {
		String word = "";
		
		boolean expected = false;
		boolean value = strings.CheckForPalindrome(word);
		
		assertEquals(expected, value);
	}
	
	@Test
	public void CheckForPalindromeWhiteSpace() {
		String word = "    	";
		
		boolean expected = false;
		boolean value = strings.CheckForPalindrome(word);
		
		assertEquals(expected, value);
	}
	
	@Test
	public void RemoveCharacterOneCharacter()
	{
		String word = "word";
		char character = 'o';
		
		String expected = "wrd";
		String value = strings.RemoveCharacter(word, character);
		
		assertEquals(expected, value);
	}
	
	@Test
	public void RemoveCharacterManyCharacters()
	{
		String word = "wood";
		char character = 'o';
		
		String expected = "wd";
		String value = strings.RemoveCharacter(word, character);
		
		assertEquals(expected, value);
	}
	
	@Test
	public void RemoveCharacterNoCharacters()
	{
		String word = "wood";
		char character = 'c';
		
		String expected = "wood";
		String value = strings.RemoveCharacter(word, character);
		
		assertEquals(expected, value);
	}
	
	@Test
	public void RemoveCharacterEmptyString()
	{
		String word = "";
		char character = 'c';
		
		String expected = "";
		String value = strings.RemoveCharacter(word, character);
		
		assertEquals(expected, value);
	}

	@Test
	public void SimplePermTest()
	{
		String word = "ABC";
		
		ArrayList<String> permutations = strings.GetPermutations(word);
		
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("ABC");
		expected.add("ACB");
		expected.add("BAC");
		expected.add("BCA");
		expected.add("CAB");
		expected.add("CBA");
		
		boolean foundAll = true;
	
		for (int i = 0; i < expected.size(); i++)
		{
			if (!permutations.contains(expected.get(i)))
			{
				foundAll = false;
				break;
			}
		}
		
		assertEquals(foundAll, true);
	}
}
