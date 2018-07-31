import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        
        char[][] gameGrid = new char[N][N];
        int currentRow = 0;
        while (scan.hasNext())
        {
            char[] line = scan.next().toCharArray();
            for (int i = 0; i < line.length; i++)
            {
                gameGrid[currentRow][i] = line[i];
            }
            currentRow++;
        }
        
        displayPathtoPrincess(N, gameGrid);
    
    }
    
    public static void displayPathtoPrincess(int N, char[][] gameGrid)
    {
        int length = N - 1;
        char topLeft = gameGrid[0][0];
        char topRight = gameGrid[0][length];
        char bottomLeft = gameGrid[length][0];
        char bottomRight = gameGrid[length][length];
        
        int[] moveUp = new int[] {-1, 0};
        int[] moveDown = new int[] {1, 0};
        int[] moveLeft = new int[] {0, -1};
        int[] moveRight = new int[] {0, 1};
        
        int[] currentPosition = new int[] {N / 2, N / 2};
        int[] toCheck;
        
        if (topLeft == 'p')
        {
            toCheck = new int[] {0, 0};
            makeMoves(moveUp, moveLeft, currentPosition, toCheck, gameGrid);
        }
        else if (topRight == 'p')
        {
            toCheck = new int[] {0, length};
            makeMoves(moveUp, moveRight, currentPosition, toCheck, gameGrid);
        }
        else if (bottomLeft == 'p')
        {
            toCheck = new int[] {length, 0};
            makeMoves(moveDown, moveLeft, currentPosition, toCheck, gameGrid);
        }
        else
        {
            toCheck = new int[] {length, length};
            makeMoves(moveDown, moveRight, currentPosition, toCheck, gameGrid);
        }
    }
    
    public static void makeMoves(int[] currentMove, int[] nextMove, int[] currentPosition, int[] toCheck, char[][] gameGrid)
    {
        if (gameGrid[toCheck[0]][toCheck[1]] != 'm')
        {
            printMove(currentMove);
            gameGrid[currentPosition[0]][currentPosition[1]] = '-';
            currentPosition[0] += currentMove[0];
            currentPosition[1] += currentMove[1];
            gameGrid[currentPosition[0]][currentPosition[1]] = 'm';
            makeMoves(nextMove, currentMove, currentPosition, toCheck, gameGrid);
        }
    }
    
    public static void printMove(int[] currentMove)
    {
        switch(currentMove[0])
        {
            case -1:
                System.out.println("UP");
                break;
            case 1:
                System.out.println("DOWN");
                break;
            default:
                break;
        }
        
        switch (currentMove[1])
        {
            case -1:
                System.out.println("LEFT");
                break;
            case 1:
                System.out.println("RIGHT");
                break;
            default:
                break;
        }
    }
}