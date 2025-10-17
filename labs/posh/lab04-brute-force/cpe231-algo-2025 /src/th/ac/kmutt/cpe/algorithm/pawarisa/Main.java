package th.ac.kmutt.cpe.algorithm.pawarisa;

import th.ac.kmutt.cpe.algorithm.pawarisa.searching.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String beadSequence = input.nextLine().trim();

        String[] targetChars = input.nextLine().trim().split(" ");
        char firstChar = targetChars[0].charAt(0);
        char secondChar = targetChars[1].charAt(0);

        int minLength = Integer.parseInt(input.nextLine().trim());

        SearchContext<String> searchContext = new SearchContext<>(new StringPatternFinder());
        int answer = searchContext.executeBeadsSearch(beadSequence, firstChar, secondChar, minLength);
        System.out.println(answer);
        input.close();
    }
}