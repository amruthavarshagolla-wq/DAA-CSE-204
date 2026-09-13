package labwork.lab_2;

public class summation_of_2series {

    public static void main(String[] args) {

        int a = 2, n = 5;

        System.out.println("The sum of series with a=2 and n=5 is:");

        int sum = 0;
        int term = 1;

        for (int i = 0; i <= n; i++) {
            sum = sum + term;
            term = term * a;
        }

        System.out.println("The sum of the series is: " + sum);
    }
}