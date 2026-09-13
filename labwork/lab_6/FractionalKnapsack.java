import java.util.*;

public class FractionalKnapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double capacity = sc.nextDouble();

        double[][] items = new double[n][3];

        for (int i = 0; i < n; i++) {
            double value = sc.nextDouble();
            double weight = sc.nextDouble();

            items[i][0] = value;
            items[i][1] = weight;
            items[i][2] = value / weight;
        }

        Arrays.sort(items, (a, b) -> Double.compare(b[2], a[2]));

        double profit = 0;

        for (int i = 0; i < n && capacity > 0; i++) {
            if (items[i][1] <= capacity) {
                profit += items[i][0];
                capacity -= items[i][1];
            } else {
                profit += items[i][2] * capacity;
                capacity = 0;
            }
        }

        System.out.printf("Maximum Profit = %.2f%n", profit);
    }
}