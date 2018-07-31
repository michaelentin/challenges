import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n,r,c;
        n = in.nextInt();
        r = in.nextInt();
        c = in.nextInt();
        in.useDelimiter("\n");
        String grid[] = new String[n];


        for(int i = 0; i < n; i++) {
            grid[i] = in.next();
        }


        nextMove(n,r,c,grid);

    }
    
    public static void nextMove(int n, int r, int c, String[] grid)
    {
        int[] pp = new int[2];
        int[] mp = new int[] {r, c};
        int[] lastPosition = new int[2];
        boolean found = false;
        
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[i].length(); j++)
            {
                if (grid[i].charAt(j) == 'p')
                {
                    pp = new int[] {i, j};
                    break;
                }
            }
            if (found) break;
        }
        
        lastPosition = makeNextMove(grid, pp, mp);   

        // git rid of old mario
        char[] lastRow = grid[lastPosition[0]].toCharArray();
        lastRow[lastPosition[1]] = '-';
        grid[lastPosition[0]] = new String(lastRow);

        // place new mario
        char[] newRow = grid[mp[0]].toCharArray();
        newRow[mp[1]] = 'm';
        grid[mp[0]] = new String(newRow);

    }
    
    public static int[] makeNextMove(String[] grid, int[] pp, int[] mp)
    {   
        int rowDiff = pp[0] - mp[0];
        int colDiff = pp[1] - mp[1];
        int[] lastPosition = new int[] {mp[0], mp[1]};
        
        if (rowDiff != 0)  // if they're not in the same row, move up or down
        {
            if (rowDiff < 0) // if diff < 0, move up
            {
                System.out.print("UP");
                mp[0] -= 1;
            }
            else // if diff > 0, move down
            {
                System.out.print("DOWN");
                mp[0] += 1;
            }
            
            return lastPosition;
        }
        
        if (colDiff != 0) // if they're not in the same col, move left or right
        {
            if (colDiff < 0) // if diff < 0, move left
            {
                System.out.print("LEFT");
                mp[1] -= 1;
            }
            else // if diff > 0, move right
            {
                System.out.print("RIGHT");
                mp[1] += 1;
            }
            
            return lastPosition;
        }
        
        return lastPosition;
        
    }
    
    
}