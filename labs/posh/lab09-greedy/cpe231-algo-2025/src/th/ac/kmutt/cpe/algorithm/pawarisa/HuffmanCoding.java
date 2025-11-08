package th.ac.kmutt.cpe.algorithm.pawarisa;

import java.util.Scanner;

public class HuffmanCoding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter text to encode:");
        String text = sc.nextLine();

        Algo huffman = new Algo();
        
        huffman.buildTree(text);
        
        String encoded = huffman.encode(text);
        System.out.println("Encoded: " + encoded);

        String decoded = huffman.decode(encoded);
        System.out.println("Decoded: " + decoded);

        sc.close();
    }
}