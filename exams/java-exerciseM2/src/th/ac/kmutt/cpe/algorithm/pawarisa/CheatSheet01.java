package th.ac.kmutt.cpe.algorithm.pawarisa;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class CheatSheet01 {
    // Make a Wish
    // Turn it into Natural Language
    public int kadanne (int[] A) {
        int max_so_far = Integer.MIN_VALUE;
        int current_max = 0;
        int n = A.length;

        for (int i = 0; i <= n -1 ; i++) {
            current_max = current_max + A[i];
            if (max_so_far < current_max) {
                max_so_far = current_max;
            }
            if (current_max < 0) {
                current_max = 0;
            }
        }
        return max_so_far;
    }

    // Andriod
    public static <T extends Comparable<T>> boolean nextPermutation(T[] A) {
        int i = A.length - 2;
        // A[i] >= A[i+1]
        while (i >= 0 && A[i].compareTo(A[i+1]) >= 0) {
            i--;
        }

        // This is the last permutation
        if (i < 0) {
            return false;
        }

        int j = A.length - 1;
        // A[i] >= A[j]
        while (A[i].compareTo(A[j]) >= 0) {
            j--;
        }
        
        // Collections.swap(A, i, j);
        swap(A, i, j);
        reverse(A, i+1, A.length-1);
        // System.out.println(A);
        return true;
    }

    // heap
        public static <T> void heapSort(T[] H) {
        int n = H.length;
        // Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(H, n, i);
        }
        // Extract elements
        for (int i = n - 1; i > 0; i--) {
            swap(H, 0, i);
            heapify(H, i, 0);
        }
    }
    
    private static <T> void heapify(T[] H, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        if (left < n && H[left].compareTo(H[largest]) > 0) largest = left;
        if (right < n && H[right] > H[largest]) largest = right;
        
        if (largest != i) {
            swap(H, i, largest);
            heapify(H, n, largest);
        }
    }

    // helper
    public static <T> void swap(T[] A, int i, int j) {
        T temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static <T> void reverse(T[] A, int start, int end) {
        while (start < end) {
            swap(A, start, end);
            start++;
            endแ--;
        }
    }

    public int swap (int[] A, int i; int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    
}