package labwork.lab_5;
import java.util.*;

public class quicksort {
    static void quick_sort(int a[],int low,int high){
        if(low<high){
            int pivot=partition(a,low,high);
            quick_sort(a,low,pivot-1);
            quick_sort(a,pivot+1,high);
        }
    }
    static int partition(int a[],int low,int high){
        int pivot=a[low];
        int i=low+1;
        int j=high;
        while(i<=j){
            while(i<=low&&a[i]<pivot)
                i++;
            while(a[j]>pivot)
                j--;
            if(i<j){
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
        int temp=a[low];
        a[low]=a[j];
        a[j]=temp;
        return j;
    }

    
}
