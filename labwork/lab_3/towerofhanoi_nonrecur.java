package labwork.lab_3;
import java.util.Scanner;
import java.util.Stack;

public class towerofhanoi_nonrecur {

    static class Move {
        int n;
        char source;
        char auxiliary;
        char destination;
        int step;

        Move(int n, char source, char auxiliary, char destination, int step) {
            this.n = n;
            this.source = source;
            this.auxiliary = auxiliary;
            this.destination = destination;
            this.step = step;
        }
    }

    public static void towerOfHanoi(int n, char source, char auxiliary, char destination) {

        Stack<Move> stack = new Stack<>();

        stack.push(new Move(n, source, auxiliary, destination, 0));

        while (!stack.isEmpty()) {

            Move current = stack.pop();

            // Base case
            if (current.n == 1) {
                System.out.println(
                    "Move disk 1 from " +
                    current.source + " to " +
                    current.destination
                );
                continue;
            }

            if (current.step == 0) {

                // Simulate:
                // towerOfHanoi(n-1, source, destination, auxiliary)

                stack.push(new Move(
                    current.n,
                    current.source,
                    current.auxiliary,
                    current.destination,
                    1
                ));

                stack.push(new Move(
                    current.n - 1,
                    current.source,
                    current.destination,
                    current.auxiliary,
                    0
                ));

            } else {

                // Move largest disk
                System.out.println(
                    "Move disk " + current.n +
                    " from " + current.source +
                    " to " + current.destination
                );

                // Simulate:
                // towerOfHanoi(n-1, auxiliary, source, destination)

                stack.push(new Move(
                    current.n - 1,
                    current.auxiliary,
                    current.source,
                    current.destination,
                    0
                ));
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of disks: ");
        int n = sc.nextInt();

        towerOfHanoi(n, 'A', 'B', 'C');

        sc.close();
    }
}