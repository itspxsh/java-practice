import java.util.Arrays;
public class CheatSheetFinal {
    // ===== 1. Decrease-and-Conquer: LexicographicPermute (Q1 Android) =====
    /**
     * หา Permutation ลำดับถัดไป (สำหรับ Char)
     * ใช้แก้ Q1 Android
     * ดัดแปลง: ถ้าจะใช้กับ Integer[] ก็แค่เปลี่ยน char[] เป็น int[]
     */
    public static boolean nextPermutation(char[] a) {
        // 1. หา i ที่มากสุด ที่ a[i] < a[i+1]
        int i = a.length - 2;
        while (i >= 0 && a[i] >= a[i + 1]) { // ใช้ >= ได้เลย (เทียบ char)
            i--;
        }
        if (i < 0) return false; // เป็นลำดับสุดท้ายแล้ว
        // 2. หา j ที่มากสุด ที่ a[i] < a[j]
        int j = a.length - 1;
        while (a[i] >= a[j]) { // ใช้ >=
            j--;
        }
        // 3. สลับ i กับ j
        swap(a, i, j);
        // 4. กลับด้าน (reverse) ตั้งแต่ i+1 ถึงสุด Array
        reverse(a, i + 1, a.length - 1);
        return true;
    }

    // ===== 2. Divide-and-Conquer: Quicksort (Hoare) (Q5) [cite: 105, 116] =====
    /**
     * Quicksort (สำหรับ int) [cite: 105]
     * คำเตือน: นี่คือ Hoare's Partition [cite: 116]
     * การพิมพ์นี้ = 1 algorithm (รวม Partition แล้ว) [cite: 943]
     */
    public static void quickSort(int[] A, int l, int r) {
        int s = hoarePartition(A, l, r);
        quickSort(A, l, s - 1);
        quickSort(A, s + 1, r); 
    }

    // HoarePartition (สำหรับ int) - เป็นส่วนหนึ่งของ Quicksort
    private static int hoarePartition(int[] A, int l, int r) {
        int p = A[l]; // pivot
        int i = l;
        int j = r + 1;
        do {
            do { i++; } while (i <= r && A[i] < p); // หาตัว > pivot
            do { j--; } while (A[j] > p); // หาตัว < pivot
            if (i < j) swap(A, i, j);
        } while (i < j);
        
        swap(A, i, j); // Undo last swap
        swap(A, l, j); // เอา pivot ไปไว้ตรงกลาง
        return j; // คืนจุดแบ่ง
    }

    // ===== 3. Transform-and-Conquer: HeapBottomUp (Q9 Heap Sort) =====
    /**
     * สร้าง Max Heap (สำหรับ int)
     * คำเตือน: pseudocode ใช้ 1-based index (H[1...n])
     * โค้ดนี้ "แปลง" เป็น 0-based index (A[0...n-1]) แล้ว */
    public static void maxHeapBottomUp(int[] H) {
        int n = H.length;
        for (int i = (n / 2) - 1; i >= 0; i--) { // (i = n/2 down to 1)
            int k = i;
            int v = H[k];
            boolean heap = false;
            // (while not heap AND 2k <= n) 
            // แปลง 2k <= n (1-based) เป็น (2k+1 < n) (0-based)
            while (!heap && (2 * k + 1) < n) {
                int j = 2 * k + 1; // (j = 2k) (ลูกซ้าย)
                // (if j < n) -> (j < n-1) (เช็คว่ามีลูกขวาไหม)
                if (j < n - 1) { 
                    // (if H[j] < H[j+1])
                    if (H[j] < H[j + 1]) j = j + 1; // j ชี้ไปที่ลูกที่ค่ามากกว่า
                }
                // (if v >= H[j])
                if (v >= H[j]) {
                    heap = true;
                } else {
                    H[k] = H[j]; // (H[k] = H[j]) (ดึงลูกขึ้น)
                    k = j; // (k = j) (ลงไปเช็คชั้นถัดไป)
                }
            }
            H[k] = v; // (H[k] = v) (วาง v ลงตำแหน่ง)
        }
    }
    // ดัดแปลง: ถ้าจะทำ Min Heap (Q9) 
    // 1. เปลี่ยน if (H[j] < H[j + 1])  เป็น  if (H[j] > H[j + 1])
    // 2. เปลี่ยน if (v >= H[j])         เป็น  if (v <= H[j])

    // ===== 4. Space-Time Tradeoffs: HorspoolMatching (Q10 หวย)=====
    /**
     * Horspool (สำหรับ char) (Q10 หวย)
     * ใช้ ShiftTable (ต้องพิมพ์ไปด้วย) 
     */
    public static int horspoolMatching(char[] P, char[] T) {
        int[] table = shiftTable(P); // สร้างตาราง shift
        int m = P.length; // (m = pattern length)
        int n = T.length; // (n = text length)
        int i = m - 1; // (i = m-1)  (เริ่มเทียบจากขวาสุด P)
        // int numShifts = 0; // (สำหรับ Q10: ใช้นับ shift)
        
        while (i <= n - 1) {
            int k = 0; // (นับตัวที่ตรงกัน)
            while (k <= m - 1 && P[m - 1 - k] == T[i - k]) {
                k++;
            }

            if (k == m) { // (ถ้า k = m แปลว่าตรงหมด)
                // System.out.println("YES " + numShifts); // (สำหรับ Q10)
                return i - m + 1; // คืนค่า index เริ่มต้น 
            } else {
                i = i + table[T[i]]; // shift
                // numShifts++; // (สำหรับ Q10: นับ shift)
            }
        }
        // System.out.println("NO " + numShifts); // (สำหรับ Q10)
        return -1; // ไม่เจอ 
    }

    // ShiftTable (สำหรับ Horspool) - เป็นส่วนหนึ่งของ Algo [cite: 164]
    private static int[] shiftTable(char[] P) {
        int m = P.length;
        int[] table = new int[256]; // (size = 256 สำหรับ ASCII)
        Arrays.fill(table, m); // (table[i] = m) [cite: 164]
        for (int j = 0; j < m - 1; j++) { // (j = 0 to m-2) [cite: 164]
            // (Table[P[j]] = m-1-j) [cite: 164]
            table[P[j]] = m - 1 - j;
        }
        return table; // [cite: 164]
    }

    // ===== Helpers (สำหรับใช้ในนี้) =====
    private static void swap(int[] A, int i, int j) {
        int temp = A[i]; A[i] = A[j]; A[j] = temp;
    }
    private static void swap(char[] A, int i, int j) {
        char temp = A[i]; A[i] = A[j]; A[j] = temp;
    }
    private static void reverse(char[] A, int start, int end) {
        while (start < end) {
            swap(A, start, end);
            start++;
            end--;
        }
    }
}