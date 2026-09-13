package labwork.lab_2;

import java.util.*;

public class k_small_1array {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int[] arr = new int[5];

        System.out.println("Enter the values of 5 elements in an array");

        for (int i = 0; i < 5; i++) {
            arr[i] = scn.nextInt();
        }

        Arrays.sort(arr);

        System.out.println("Enter the value of k to know the kth smallest element");
        int k = scn.nextInt();

        for (int i = 0; i < 5; i++) {

            if (i == k - 1) {
                System.out.println("The " + k + "th smallest element is: " + arr[i]);
            }
        }

        scn.close();
    }
}