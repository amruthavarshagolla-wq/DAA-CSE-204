package labwork.lab_5;
import java.util.*;
public class mergesort{
        static void merge_sort(int a[],int n,int low,int high){
            if(low<high){
                int mid=(low+high)/2;
                merge_sort(a, n, low, mid);
                merge_sort(a, n, mid+1, high);
                merge(a, n, low, mid, high);
            }
        }
        static void merge(int a[],int n,int low,int mid,int high){
            int i=low;
            int j=mid+1;
            int k=low;
            int b[]=new int[n];
            while(i<=mid&&j<=high){
                if(a[i]<a[j]){
                    b[k++]=a[i++];
                }
                else{
                    b[k++]=a[j++];
                }  
            }
            while(i<=mid)
                b[k++]=a[i++];
            while(j<=high)
                b[k++]=a[j++];
            for(int c=low;c<=high;c++)
            {
                a[c]=b[c];
            }
        }
public static void main(String[] args){
    Scanner scn=new Scanner(System.in);
    System.out.println("enter the no of elements");
    int n=scn.nextInt();
    System.out.println("enter the"+n+ "elements");
    int a[]=new int[n];
    for(int i=0;i<n;i++){
        a[i]=scn.nextInt();
    }
    merge_sort(a,n,0,n-1);
    System.out.println("sorted array is:");
    for(int i=0;i<n;i++){
        System.out.print(a[i]+" ");
    }
    scn.close();
}
}
