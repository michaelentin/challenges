import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class TrieNode
{
    public HashMap<Character, TrieNode> children;
    public int size = 0;

    TrieNode()
    {
        children = new HashMap<Character, TrieNode>();
    }
}

public class Solution {
    
    private static void printTrie(TrieNode root)
    {
        for (Character child: root.children.keySet())
        {
            System.out.println(child);
            printTrie(root.children.get(child));
        }
    }
    
    private static boolean NodeContainsLetter(char letter, TrieNode currentNode)
    {
        if (!currentNode.children.containsKey(letter)) return false;
        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        TrieNode root = new TrieNode();

        for (int nItr = 0; nItr < n; nItr++) {
            int foundPartials = 0;
            
            String[] opContact = scanner.nextLine().split(" ");

            String op = opContact[0];

            String contact = opContact[1];
            
            char[] letters = contact.toCharArray();
            
            if (op.equals("add"))
            {
                TrieNode currentNode = root;
                for (int i = 0; i < letters.length; i++)
                {
                    if (!currentNode.children.containsKey(letters[i]))
                    {
                        currentNode.children.put(letters[i], new TrieNode());
                        
                    }
                    currentNode = currentNode.children.get(letters[i]);
                    currentNode.size++;
                }
            }
            else
            {
                TrieNode currentNode = root;
                boolean foundEnd = true;
                for (char letter: letters)
                {
                    if (!NodeContainsLetter(letter, currentNode)) 
                    {
                        foundEnd = false;
                        break;
                    }
                    currentNode = currentNode.children.get(letter);
                }
                
                int toPrint = foundEnd ? currentNode.size : 0;
                
                System.out.println(toPrint);
            }
        }
        
        //printTrie(root);

        scanner.close();
    }
}
