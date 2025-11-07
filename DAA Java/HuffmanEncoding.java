import java.util.*;

public class HuffmanEncoding {

    static class Node implements Comparable<Node> {
        char ch;
        int freq;
        Node left, right;

        Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
            this.left = this.right = null;
        }

        Node(int freq, Node left, Node right) {
            this.ch = '\0';
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Node other) {
            return this.freq - other.freq;
        }
    }

    public static void generateCodes(Node root, String code, Map<Character, String> codes) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            codes.put(root.ch, code);
            return;
        }
        generateCodes(root.left, code + "0", codes);
        generateCodes(root.right, code + "1", codes);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string to encode: ");
        String data = sc.nextLine();

        if (data.isEmpty()) {
            System.out.println("Empty input. Exiting.");
            sc.close();
            return;
        }

        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : data.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node merged = new Node(left.freq + right.freq, left, right);
            pq.add(merged);
        }

        Node root = pq.peek();
        Map<Character, String> codes = new HashMap<>();
        generateCodes(root, "", codes);

        System.out.println("Huffman Codes:");
        for (Map.Entry<Character, String> entry : codes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        StringBuilder encoded = new StringBuilder();
        for (char ch : data.toCharArray()) {
            encoded.append(codes.get(ch));
        }

        System.out.println("Encoded string: " + encoded.toString());
        sc.close();
    }
}
