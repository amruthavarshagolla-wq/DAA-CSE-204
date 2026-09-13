package labwork.lab_4;
    import java.util.HashSet;
import java.util.Scanner;

public class Twosum {

    static boolean findTwoSum(int[] arr, int T) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {

            int required = T - arr[i];

            if (set.contains(required)) {
                System.out.println("Pair found: "
                        + required + " + " + arr[i] + " = " + T);
                return true;
            }

            set.add(arr[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target T: ");
        int T = sc.nextInt();

        if (!findTwoSum(arr, T)) {
            System.out.println("No pair found.");
        }

        sc.close();
    }
}
