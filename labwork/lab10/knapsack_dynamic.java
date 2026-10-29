package labwork.lab10;

import java.util.*;

public class knapsack_dynamic
{
    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter the number of elements");
        int n = scn.nextInt();

        int wt[] = new int[n];
        int val[] = new int[n];

        System.out.println("Enter the weights");
        for (int k = 0; k < n; k++)
        {
            wt[k] = scn.nextInt();
        }

        System.out.println("Enter the profit values");
        for (int l = 0; l < n; l++)
        {
            val[l] = scn.nextInt();
        }

        System.out.println("Enter the capacity of knapsack");
        int W = scn.nextInt();

        int dp[][] = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= W; j++)
            {
                if (wt[i - 1] <= j)
                {
                    dp[i][j] = Math.max(
                        dp[i - 1][j],
                        val[i - 1] + dp[i - 1][j - wt[i - 1]]
                    );
                }
                else
                {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println("Maximum profit: " + dp[n][W]);

        scn.close();
    }
}
