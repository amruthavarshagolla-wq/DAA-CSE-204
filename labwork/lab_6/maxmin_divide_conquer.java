package labwork.lab_6;
 public class maxmin_divide_conquer{
    static int[] findmaxmin(int arr[],int low,int high)
    {
        if(low==high)
        {
            return new int[]{arr[low],arr[low]};
        }
        if(high==low+1)
        {
            if(arr[low]>arr[high])
            {
                return new int[]{arr[high],arr[low]};
            }
            else{
                return new int[]{arr[low],arr[high]};
            }
        }
        int mid=(low+high)/2;//takes less comparison than linear search
        int left[]=findmaxmin(arr,low,mid);
        int right[]=findmaxmin(arr,mid+1,high);
        int min=Math.min(left[0],right[0]);
        int max=Math.max(left[1],right[1]);
        return new int[]{min,max};
    }
    public static void main(String args[])
    {
      int arr[]={12,45,78,90,34};
      int n=arr.length;
      int result[]=findmaxmin(arr,0,n-1);
      System.out.println("Minimum element is"+result[0]);
      System.out.println("Maximum elemnt is "+result[1]);  
    }

}