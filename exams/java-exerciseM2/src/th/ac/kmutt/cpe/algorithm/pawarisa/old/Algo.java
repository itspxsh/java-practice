package th.ac.kmutt.cpe.algorithm.pawarisa.old;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Algo {
    /* 1 */
    public int[] nextPermutation (int[] A, int n) {
        return null;
    }

    public int[] andriod (int[] A, int n) {
        return null;
    }

    /* 3 */
    // sort no return, already edited.
    public void pancakeSort(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            System.out.println("There's no number");
            return;
        }

        int count = numbers.size(); // number of pancake
        while (count != 1) {
            // 1
            // Collections.max(numbers);
            int highest = numbers.get(0); // Initialize with the first element
            int h = 0; // index of the highest number
            for (int i = 1; i < count; i++) {
                if (numbers.get(i) > highest) {
                    highest = numbers.get(i);
                    h = i;
                }
            }
            // 2
            flip(numbers, h);  
            // 3          
            flip(numbers, count-1);
            count--;
        }
    }

    public void flip (List<Integer> list, int h) {
        // 4
        int j = 0;
        int temp = 0;
        if (h != j /*list.get(h) != list.get(0)*/) {
            while (h > j) {
                temp = list.get(j); // value
                list.set(j, list.get(h)); // list.set(index u wanna change, to be value);
                list.set(h, temp);
                j++;
                h--;
            }
        }
    }

    /* 4 */
    public int quickSelect(List<Integer> A, int l, int r, int k) {
        System.out.println(A);
        int s = lomutoPartition(A, l, r);
        if (s == k-1) {
            System.out.println(A.get(s));
            return A.get(s);
        } else if (s > k - 1) {
            return quickSelect(A, l, s-1, k);
        } else {
            return quickSelect(A, s+1, r, k);
        }
    }

    public int lomutoPartition (List<Integer> A, int l, int r) {
        int p = A.get(l);
        int s = l;

        for (int i = l+1; i <= r; i++) {
            if (A.get(i).compareTo(p) < 0) {
                s = s + 1;
                swapArrayList(A, s, i);
            }
        }
        swapArrayList(A, l, s);
        return s;
    }

    public void swapArrayList (List<Integer> A, int index1, int index2) {
        int temp = A.get(index1);
        A.set(index1, A.get(index2));
        A.set(index2, temp);
    }
    
    /* 6 */
    public void quickSort (int[] A, int l, int r) {
        if (l<r) {
            int s = hoarepartition(A, l, r); // A = A[]
            // QuickSort(A[l...s-1])
            quickSort(A, l, s-1);
            // QuickSort(A[s+1...r])
            quickSort(A, s+1, r);
        } 
    }

    public int hoarepartition (int[] A, int l, int r) {
        // WRONG
        // int l = 0; l is pivot for each time, so it change every loop
        // int r = A.length-1; // last index

        int p = A[l];
        int i = l;
        int j = r + 1; // j = length

        while (i<j) {
            do {
                i = i + 1;
            } while (A[i] < p  && i<r);
            do {
                j = j - 1;
            } while (A[j] > p && j>l);

            swapArray(A, i, j);

        }

        swapArray(A, i, j);
        swapArray(A, l, j); // swap pivot and j

        return j;
    }

    public void swapArray(int[] A,int index1, int index2) {
        int temp = A[index1];
        A[index1] = A[index2];
        A[index2] = temp;
    }
}