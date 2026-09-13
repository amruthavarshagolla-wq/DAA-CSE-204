package labwork.lab_4;
    import java.util.Scanner;

public class LinearProbing {
    static int SIZE = 10;
    static int[] table = new int[SIZE];

    static void insert(int key) {
        int index = key % SIZE;

        for (int i = 0; i < SIZE; i++) {
            int newIndex = (index + i) % SIZE;

            if (table[newIndex] == -1) {
                table[newIndex] = key;
                return;
            }
        }

        System.out.println("Hash table is full!");
    }

    static void display() {
        System.out.println("Hash Table:");

        for (int i = 0; i < SIZE; i++) {
            System.out.println(i + " -> " + table[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initialize table with -1
        for (int i = 0; i < SIZE; i++) {
            table[i] = -1;
        }

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            int key = sc.nextInt();
            insert(key);
        }

        display();

        sc.close();
    }
}
    

