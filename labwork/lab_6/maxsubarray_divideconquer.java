package labwork.lab_6;
public class maxsubarray_divideconquer{
    static int findmaxsubarray(int arr[],int low,int high)
    {
        if(low==high)
        {
            return arr[low];
        }
        int mid=(low+high)/2;
        int leftmax=findmaxsubarray(arr,low,mid);//
        int rightmax=findmaxsubarray(arr,mid+1,high);
        int crossmax=findcrosssubarray(arr,low,mid,high);
        return Math.max(leftmax,Math.max(rightmax,crossmax));
    }
    static int findcrosssubarray(int arr[],int low,int mid,int high)
    {
        int leftsum=Integer.MIN_VALUE;
        int sum=0;
        for(int i=mid;i>=low;i--){
            sum=sum+arr[i];
            leftsum=Math.max(leftsum,sum);
        }
        int rightsum=Integer.MIN_VALUE;
        sum=0;
        for(int j=mid+1;j<=high;j++)
        {
            sum=sum+arr[j];
            rightsum=Math.max(rightsum,sum);
        }
        return leftsum+rightsum;
    }
    public static void main(String args[])
    {
        int arr[]={-2,1,-3,4,-1,2,1,-5,4};
        int n=arr.length;
        int maxsum=findmaxsubarray(arr,0,n-1);
        System.out.println("Maximum subarray sum is: "+maxsum);
    }
}
