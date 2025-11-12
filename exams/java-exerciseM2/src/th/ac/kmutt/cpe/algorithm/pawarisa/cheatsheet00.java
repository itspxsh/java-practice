package th.ac.kmutt.cpe.algorithm.pawarisa;
import java.util.*;

/**
 * Java Cheat Sheet for CPE231 Exam 2 (Algorithms 1/2025)
 * Contains 1 printed algorithm for each of the 4 strategies,
 * selected from pseudocode.pdf for maximum utility.
 */
public class cheatsheet00 {

    // =========================================================================
    // Strategy 1: Decrease-and-Conquer
    // Algorithm: LexicographicPermute (nextPermutation) 
    // Why: Very useful (Practice Q1), and complex to write from scratch.
    // =========================================================================
    /**
     * Finds the next lexicographically greater permutation of the array.
     * Based on Algorithm 3: LexicographicPermute [cite: 560-574].
     * Modifies the array in-place. Returns true if a next permutation exists, 
     * false if this is the last permutation.
     */
    public static <T extends Comparable<T>> boolean nextPermutation(T[] a) {
        // 1. Find the largest index i such that a[i] < a[i+1] [cite: 565]
        int i = a.length - 2;
        while (i >= 0 && a[i].compareTo(a[i + 1]) >= 0) {
            i--;
        }

        // If no such i exists, this is the last permutation
        if (i < 0) {
            return false;
        }

        // 2. Find the largest index j such that a[i] < a[j] [cite: 566]
        int j = a.length - 1;
        while (a[i].compareTo(a[j]) >= 0) {
            j--;
        }

        // 3. Swap a[i] and a[j] [cite: 567, 568]
        swap(a, i, j);

        // 4. Reverse the order from a[i+1] to a[n] [cite: 572]
        reverse(a, i + 1, a.length - 1);
        
        return true;
    }


    // =========================================================================
    // Strategy 2: Divide-and-Conquer
    // Algorithm: Quicksort (with HoarePartition) 
    // Why: A complex, core algorithm. Practice Q5 uses it directly.
    // Per instructions[cite: 527], printing this *includes* its partition helper.
    // =========================================================================
    /**
     * Sorts an array using Quicksort.
     * Based on Algorithm 9: Quicksort [cite: 637-643].
     */
    public static <T extends Comparable<T>> void quickSort(T[] a, int l, int r) {
        if (l < r) {
            int s = hoarePartition(a, l, r); // s is split position [cite: 640]
            quickSort(a, l, s - 1); // [cite: 641]
            quickSort(a, s + 1, r); // [cite: 642]
        }
    }

    /**
     * Partitions a subarray using Hoare's scheme.
     * Based on Algorithm 10: HoarePartitioning [cite: 648-650].
     */
    private static <T extends Comparable<T>> int hoarePartition(T[] a, int l, int r) {
        T p = a[l]; // [cite: 650]
        int i = l; // [cite: 650]
        int j = r + 1; // [cite: 650]

        do {
            do { i++; } while (i <= r && a[i].compareTo(p) < 0); // [cite: 650]
            do { j--; } while (a[j].compareTo(p) > 0); // [cite: 650]
            if (i < j) {
                swap(a, i, j); // [cite: 650]
            }
        } while (i < j);

        swap(a, i, j); // Undo last swap [cite: 650]
        swap(a, l, j); // [cite: 650]
        return j; // [cite: 650]
    }


    // =========================================================================
    // Strategy 3: Transform-and-Conquer
    // Algorithm: MaxHeapBottomUp (Heapify) 
    // Why: Core of HeapSort (Practice Q9). Q9 asks to *adapt* this to a MinHeap,
    // so having the MaxHeap code is the perfect template.
    // =========================================================================
    /**
     * Constructs a max-heap from an arbitrary array (1-indexed).
     * Based on Algorithm 14: HeapBottomUp.
     * Note: This pseudocode assumes 1-based indexing (H[1...n]).
     * We will adapt it for 0-based indexing.
     */
    public static <T extends Comparable<T>> void maxHeapBottomUp(T[] a) {
        int n = a.length;
        // Start from the last parent node
        for (int i = (n / 2) - 1; i >= 0; i--) { //  (for i <- n/2 down to 1)
            int k = i; // 
            T v = a[k]; // 
            boolean heap = false; // 

            // 2*k+1 is left child, 2*k+2 is right child (for 0-indexing)
            while (!heap && (2 * k + 1) < n) { //  (while not heap and 2k <= n)
                int j = 2 * k + 1; //  (j <- 2k)
                if (j < n - 1) { //  (if j < n, meaning two children)
                    if (a[j].compareTo(a[j + 1]) < 0) { //  (if H[j] < H[j+1])
                        j = j + 1; // 
                    }
                }
                if (v.compareTo(a[j]) >= 0) { //  (if v >= H[j])
                    heap = true; // 
                } else {
                    a[k] = a[j]; // 
                    k = j; // 
                }
            }
            a[k] = v; // 
        }
    }


    // =========================================================================
    // Strategy 4: Space-Time Tradeoffs
    // Algorithm: HorspoolMatching (with ShiftTable) 
    // Why: Complex string matching. Practice Q10 uses it directly.
    // =========================================================================
    /**
     * Creates the shift table for Horspool's algorithm.
     * Based on Algorithm 17: ShiftTable[cite: 697].
     * Assumes ASCII 256-char alphabet.
     */
    public static int[] shiftTable(char[] p) {
        int m = p.length;
        int[] table = new int[256]; // Assuming ASCII
        Arrays.fill(table, m); // [cite: 697]
        for (int j = 0; j < m - 1; j++) { // [cite: 697]
            table[p[j]] = m - 1 - j; // [cite: 697]
        }
        return table;
    }

    /**
     * Performs string matching using Horspool's algorithm.
     * Based on Algorithm 18: HorspoolMatching [cite: 698-701].
     * Returns the index of the first match, or -1.
     * (Modified to also count shifts for Practice Q10)
     */
    public static int horspoolMatching(char[] p, char[] t, int[] table) {
        int m = p.length;
        int n = t.length;
        int i = m - 1; // [cite: 701]
        // int numShifts = 0; // Uncomment to count shifts for Q10

        while (i <= n - 1) { // [cite: 701]
            int k = 0; // [cite: 701]
            while (k <= m - 1 && p[m - 1 - k] == t[i - k]) { // [cite: 701]
                k++;
            }
            if (k == m) {
                // System.out.println("Shifts: " + numShifts);
                return i - m + 1; // [cite: 701]
            } else {
                i = i + table[t[i]]; // [cite: 701]
                // numShifts++;
            }
        }
        // System.out.println("Shifts: " + numShifts);
        return -1; // [cite: 701]
    }


    // =========================================================================
    // Utility Helpers (Generic swap/reverse)
    // =========================================================================
    public static <T> void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public static <T> void reverse(T[] a, int start, int end) {
        while (start < end) {
            swap(a, start, end);
            start++;
            end--;
        }
    }
}