package labwork.lab_11;
import java.util.Scanner;
public class Matrixchain_multiplication {
    public static void main(String args[])
    {
    Scanner scn=new Scanner(System.in);
    System.out.println("enter the number of matrices");
    int n=scn.nextInt();
    System.out.println("enter thedimensions of matrix");
    int arr[]=new int[n+1];
    for(int i=0;i<=n;i++)
        {
            arr[i]=scn.nextInt();
        }
        int dp[][]=new int[n+1][n+1];
        for(int len=2;len<=n;len++)
        {
            for(int i=1;i<=n-len+1;i++)
            {
                int j=i+len-1;
                dp[i][j]=Integer.MAX_VALUE;
                for(int k=i;k<j;k++)
                {
                    int cost=dp[i][k]+dp[k+1][j]+arr[i-1]*arr[k]*arr[j];
                    if(cost<dp[i][j])
                    {
                        dp[i][j]=cost;
                    }
                }
            }
        }
        System.out.println("minimum number of multiplications is "+dp[1][n]);
    
    }
}