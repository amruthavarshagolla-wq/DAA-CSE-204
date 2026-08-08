import java.util.*;
public class Binarysearch{
    public static void main(String args[]){
        Scanner scn=new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n=scn.nextInt();
        int arr[]=new int[n];
        System.out.print("Enter the elements of the array: ");
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1])
                {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;      
                }
            }
        }
        System.out.print("Enter the target element: ");
        int target=scn.nextInt();
        int left=0,right=n-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(arr[mid]==target){
            System.out.print("element found at index "+mid);
            return;
            }
            if(arr[mid]>target){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        System.out.print("element not found");
    }
}


