package labwork.lab_4;
    import java.util.HashMap;
import java.util.Scanner;

public class FrequencyUsingHashing {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> frequency = new HashMap<>();

        // Count frequency of each element
        for (int i = 0; i < n; i++) {
            frequency.put(
                arr[i],
                frequency.getOrDefault(arr[i], 0) + 1
            );
        }

        // Display frequencies
        System.out.println("Frequency of elements:");

        for (Integer key : frequency.keySet()) {
            System.out.println(key + " -> " + frequency.get(key));
        }

        sc.close();
    }
}
