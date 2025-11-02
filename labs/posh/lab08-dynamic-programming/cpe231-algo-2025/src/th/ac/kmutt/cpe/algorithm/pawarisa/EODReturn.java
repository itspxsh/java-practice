package th.ac.kmutt.cpe.algorithm.pawarisa;

import java.util.Scanner;

public class EODReturn {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] power = new int[n];
        for (int i = 0; i < n; i++) {
            power[i] = sc.nextInt();
        }

        int[] dp = new int[n + 1]; // dp[i] = max cleared area starting from i

        for (int i = n - 1; i >= 0; i--) {
            int next = i + power[i] + 1;
            int take = (power[i] + 1) + (next < n ? dp[next] : 0);
            int skip = dp[i + 1];
            dp[i] = Math.max(take, skip);
        }

        System.out.println(dp[0]);
        sc.close();
    }
}
