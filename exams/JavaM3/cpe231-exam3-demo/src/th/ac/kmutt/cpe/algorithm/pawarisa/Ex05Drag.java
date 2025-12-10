package th.ac.kmutt.cpe.algorithm.pawarisa;
import java.util.Scanner;

public class Ex05Drag {
    public static void drag(String queen) {
        int[] counts = new int[26];
        for (char c : queen.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                counts[c - 'a']++; // 'a' - 'a' means index 0
            }
        }
        
        StringBuffer newQueen = new StringBuffer();
        int l = queen.length();
        int previousMaxc = -1;
        for (int i = 0; i < l; i++) {
            int max = -1;
            int maxc = -1;
            for (int j = 0; j < 26; j++) {
                if ((max < counts[j]) && (previousMaxc != j) && (counts[j] != 0)) {
                    max = counts[j];
                    maxc = j;
                }
            }
            if (maxc == -1) {
                System.out.println("IMPOSSIBLE");
                return;
            }
            previousMaxc = maxc;
            char temp = (char) (maxc  + 'a');
            newQueen.append(temp);
            counts[maxc] = counts[maxc] - 1;
        }

        System.out.println(newQueen.toString());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String queen = new String();
        queen = sc.next();
        drag(queen);
        sc.close();
    }
}
