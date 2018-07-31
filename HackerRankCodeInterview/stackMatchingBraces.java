import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static boolean isBalanced(String expression)
    {
        LinkedList<Character> stack = new LinkedList<Character>();
        
        for (char letter: expression.toCharArray())
        {
            // push matching brace to stack if opening brace is found
            if (letter == '{') stack.push('}');
            else if (letter == '[') stack.push(']');
            else if (letter == '(') stack.push(')');
            else 
            {
                // else if closing brace found: 
                // if stack is empty or the top of the stack is not the same 
                // as this closing brace, return false
                if (stack.isEmpty() || stack.peekFirst() != letter) return false;
                stack.pop();
            }
        }
        
        // can only be certain of matching braces if the stack is empty
        return stack.isEmpty();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String expression = scanner.nextLine();
            
            boolean balanced = isBalanced(expression);
            
            String toPrint = balanced ? "YES" : "NO";
            System.out.println(toPrint);
        }

        scanner.close();
    }
}
