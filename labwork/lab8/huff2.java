package labwork.lab8;
import java.util.*;

public class huff2 {
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

        // Check whether the node is a leaf
        boolean isLeaf() {
            return left == null && right == null;
        }
    }

    // Generate Huffman codes
    static void printCodes(Node root, String code) {
        if (root == null) {
            return;
        }

        if (root.isLeaf()) {
            System.out.println(root.ch + " : " + code);
            return;
        }

        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    public static void main(String[] args) {

        char[] letters = {'a', 'c', 'd', 'e',
                          'o', 'm', 's', 't', 'u'};

        int[] frequencies = {20, 11, 2, 10,
                             15, 8, 10, 22, 2};

        // Min-priority queue
        PriorityQueue<Node> pq =
                new PriorityQueue<>(
                        Comparator.comparingInt(n -> n.freq));

        // Insert all characters into the queue
        for (int i = 0; i < letters.length; i++) {
            pq.add(new Node(letters[i], frequencies[i]));
        }

        // Construct the Huffman tree
        while (pq.size() > 1) {

            Node left = pq.poll();
            Node right = pq.poll();

            Node parent = new Node(left, right);

            pq.add(parent);
        }

        // Root of the Huffman tree
        Node root = pq.poll();

        System.out.println("Huffman Codes:");

        // Print codes for all characters
        printCodes(root, "");

        // Calculate total encoded bits
        int totalBits = 0;

        for (int i = 0; i < frequencies.length; i++) {
            totalBits += frequencies[i] * 100;
        }

        // Calculate the actual weighted code length
        totalBits = 0;

        Map<Character, String> codes = new HashMap<>();
        getCodes(root, "", codes);

        for (int i = 0; i < letters.length; i++) {
            totalBits += frequencies[i] * 100
                    * codes.get(letters[i]).length();
        }

        System.out.println("Total characters: 10000");
        System.out.println("Total bits: " + totalBits);
        System.out.println("Memory in bytes: " + totalBits / 8);
    }

    // Store Huffman codes in a map
    static void getCodes(Node root, String code,
                         Map<Character, String> codes) {

        if (root.isLeaf()) {
            codes.put(root.ch, code);
            return;
        }

        getCodes(root.left, code + "0", codes);
        getCodes(root.right, code + "1", codes);
    }
}
