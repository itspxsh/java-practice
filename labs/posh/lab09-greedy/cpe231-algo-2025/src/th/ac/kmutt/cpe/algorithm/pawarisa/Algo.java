package th.ac.kmutt.cpe.algorithm.pawarisa;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Algo {
    public static void toEgyptian (int nr, int dr) {
        if (dr == 0 || nr == 0) {
            return;
        }

        if (dr % nr == 0) {
            System.out.print("1/" + dr / nr);
            return;
        }

        if (dr % nr == 0) {
            System.out.print("1/" + dr / nr);
            return;
        }

        if (nr % dr == 0) {
            System.out.print(nr / dr);
            return;
        }

        if (nr > dr) {
            System.out.print(nr / dr + " + ");
            toEgyptian(nr % dr, dr);
            return;
        }

        int n = dr / nr + 1;
        System.out.print("1/" + n + " + ");

        toEgyptian(nr * n - dr, dr * n);
    }

    private class Node implements Comparable<Node> {
        int freq;
        char ch; 
        Node lNode; 
        Node rNode;

        public Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }

        public Node(int freq, Node left, Node right) {
            this.freq = freq;
            this.lNode = left;
            this.rNode = right;
        }

        @Override
        public int compareTo(Node other) {
            return this.freq - other.freq;
        }

        public boolean isLeaf() {
            return this.lNode == null && this.rNode == null;
        }
    }

    private Node root;
    private Map<Character, String> charToCodeMap;

    public void buildTree(String text) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            queue.add(new Node(entry.getKey(), entry.getValue()));
        }

        while (queue.size() > 1) {
            Node left = queue.poll();
            Node right = queue.poll();
            
            int sumFreq = left.freq + right.freq;
            Node parent = new Node(sumFreq, left, right);
            queue.add(parent);
        }
        
        this.root = queue.poll(); 
        
        this.charToCodeMap = new HashMap<>();
        if (this.root.isLeaf()) {
            this.charToCodeMap.put(this.root.ch, "0");
        } else {
            generateCodes(this.root, "");
        }
    }

    private void generateCodes(Node node, String currentCode) {
        if (node.isLeaf()) {
            this.charToCodeMap.put(node.ch, currentCode);
            return;
        }
        generateCodes(node.lNode, currentCode + "0");
        generateCodes(node.rNode, currentCode + "1");
    }

    public String encode(String text) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            result.append(this.charToCodeMap.get(c));
        }
        return result.toString();
    }

    public String decode(String encodedText) {
        StringBuilder result = new StringBuilder();
        Node walker = this.root; 
        
        if(walker.isLeaf()) {
            for(int i=0; i < encodedText.length(); i++) {
                result.append(walker.ch);
            }
            return result.toString();
        }

        for (char bit : encodedText.toCharArray()) {
            walker = (bit == '0') ? walker.lNode : walker.rNode;

            if (walker.isLeaf()) {
                result.append(walker.ch);
                walker = this.root; 
            }
        }
        return result.toString();
    }
}