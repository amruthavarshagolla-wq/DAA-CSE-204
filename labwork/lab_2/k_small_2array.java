package labwork.lab_2;
import java.util.Scanner;
public class k_small_2array {
    public static void main(String[] args) {
	    Scanner scn=new Scanner(System.in);
	    int[] arr = new int[5];
	    System.out.println("enter the values of  5 elements in an array");
	    for(int i=0;i<5;i++)
	    {
	        arr[i]=scn.nextInt();
	    }
	    System.out.println("enter the value of k to find the kth smallest element");
	    int k=scn.nextInt();
	    for(int i=0;i<k-1;i++)//8,5,4,9
	    {
	        int min=arr[i];//min=8
	        for(int j=i+1;j<5;j++)//
	        {
	            if(arr[j]<min)//8>5yes//5>4yes//4>9no if stops loop closes
	            {
	                min=arr[j];//min=4
	            }
	        }
	        int temp=arr[i];
	        arr[i]=min;
	        min=temp;
	    }
	    System.out.println(arr[k-1]);
		scn.close();
	}

    
}
