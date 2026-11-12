package labwork.lab_12;
import java.util.Scanner;
public class queen_backtracking
{
    static boolean issafe(int board[][],int row,int col)
    {
        for(int i=0;i<col;i++)
        {
            if(board[row][i]==1)
                return false;
        }
        for(int i=row,j=col;i>=0 && j>=0;i--,j--)
        {
            if(board[i][j]==1)
                return false;
        }
        for(int i=row,j=col;i<board.length && j>=0;i++,j--)
        {
            if(board[i][j]==1)
                return false;

        }
        return true;
    }
    static boolean solve(int board[][],int col)
    {
        if(col>=board.length)
            return true;
        for(int i=0;i<board.length;i++)
        {
            if(issafe(board,i,col))
            {
                board[i][col]=1;
                if(solve(board,col+1))
                    return true;
                board[i][col]=0;
            }
        }
        return false;
    }
    public static void main(String args[])
    {
        Scanner scn=new Scanner(System.in);
        System.out.println("Enter the dimensions of the board");
        int n=scn.nextInt();
        int board[][]=new int[n][n];
        if(solve(board,0))
        {
            System.out.println("The solution is:");
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("solution does not exist");
        }
    }
}