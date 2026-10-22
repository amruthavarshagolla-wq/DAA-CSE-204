package labwork.lab_9;
import java.util.Scanner;
public class Flyodwarshell
{
    public static void main(String[] args)
    {
    Scanner scn =new Scanner(System.in);
    System.out.println("Enter the number of vertices");
    int n=scn.nextInt();
    int[][] dist=new int[n][n];
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            System.out.println("enter the distance");
            dist[i][j]=scn.nextInt();
        }
    }
    for(int k=0;k<n;k++)
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(dist[i][k]!=999 && dist[k][j]!=999 && dist[i][j]>dist[i][k]+dist[k][j])
                {
                    dist[i][j]=dist[i][k]+dist[k][j];
                }
            }
        }
    }
    System.out.println("The shortest distance matrix is :");
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            if(dist[i][j]==999)
            {
                System.out.print("INF ");
            }
            else
            {
                System.out.print(dist[i][j]+" ");
            }
        }
        System.out.println();
    }
    scn.close();
}
}