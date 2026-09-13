package labwork.lab_2;

public class summation_of_1series {

    public static void main(String[] args) {

        int a = 2;
        int n = 5;

        System.out.println("The summation of series with a=2 and n=5 is:");

        int r = (int) Math.pow(a, n - 1);

        int sum = (a * (r - 1)) / (a - 1);

        System.out.println("The summation of the series is: " + sum);
    }
}