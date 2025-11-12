package th.ac.kmutt.cpe.algorithm.pawarisa.old;

import java.util.ArrayList;

public class Algorithms<T extends Comparable<T>>{
    public int maxSubarraySum (ArrayList<T> A) {
        int res = (int) A.get(0);
        for (int i = 0; i < A.size(); i++) {
            int currSum = 0;
            for (int j = i; j < A.size(); j++) {
                currSum = currSum + (Integer)A.get(j);
                // currSum = currSum + ((Integer) A.get(j)).intValue();
                res = Math.max(res, currSum);
            }
        }
        return res;        
    }
}
