package labwork.lab_5;
import java.util.*;
public class bucketsort {
    public static void main(String[] args){
    Scanner scn=new Scanner(System.in);
    System.out.println("enter no of elements:");
    int n=scn.nextInt();
    if(n<0)
    {
         System.out.println("Not valid");
         return;
    }   

    int a[]=new int[n];
    System.out.println("enter the "+n+" elements");
    for(int i=0;i<n;i++){
        a[i]=scn.nextInt();
    }
    int max=a[0];
    int min=a[0];
    for(int i=0;i<n;i++){
        if(a[i]>max)
            max=a[i];
        if(a[i]<min)
            min=a[i];
    }
    ArrayList<Integer> bucket[]=new ArrayList[n];
    for(int i=0;i<n;i++){
        bucket[i]=new ArrayList<>();
    }
    long range=(long)max-min+1;
    for(int i=0;i<n;i++){
        int num=a[i];
        int index=(int)((num-min)*n/range);
        bucket[index].add(num);
    }
    for(int i=0;i<n;i++){
        Collections.sort(bucket[i]);
    }
    int k=0;
    for(int i=0;i<n;i++){
        for(int j=0;j<bucket[i].size();j++){
            a[k++]=bucket[i].get(j);
        }
    }
    for(int i=0;i<n;i++){
        System.out.print(a[i]+" ");
    }
    scn.close();

    }
    
}
