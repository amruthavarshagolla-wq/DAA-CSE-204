package labwork.lab8;
import java.util.*;

public class huffman {

    // Node of the Huffman tree
    static class Node {
        char ch;
        int freq;
        Node left, right;

        Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }

        Node(Node left, Node right) {
            this.ch = '-';
            this.freq = left.freq + right.freq;
            this.left = left;
            this.right = right;
        }
    }

    // Generate Huffman codes
    static void printCodes(Node root, String code) {

        if (root == null)
            return;

        // Leaf node contains a character
        if (root.left == null && root.right == null) {
            System.out.println(root.ch + " : " + code);
            return;
        }

        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();

        char[] ch = new char[n];
        int[] freq = new int[n];

        System.out.println("Enter characters and frequencies:");

        for (int i = 0; i < n; i++) {
            ch[i] = sc.next().charAt(0);
            freq[i] = sc.nextInt();
        }

        // Sort nodes by frequency
        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.freq, b.freq)
        );

        // Create a node for each character
        for (int i = 0; i < n; i++) {
            pq.add(new Node(ch[i], freq[i]));
        }

        // Build the Huffman tree
        while (pq.size() > 1) {

            Node left = pq.poll();
            Node right = pq.poll();

            Node parent = new Node(left, right);

            pq.add(parent);
        }

        // Print Huffman codes
        Node root = pq.poll();

        System.out.println("\nHuffman Codes:");
        printCodes(root, "");
        
        sc.close();
    }
}