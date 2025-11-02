package th.ac.kmutt.cpe.algorithm.pawarisa;

import java.util.ArrayList;
import java.util.Scanner;

public class Jaothi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // number of brands
        int T = sc.nextInt(); // total time available

        ArrayList<Brand> brands = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int time = sc.nextInt();
            int value = sc.nextInt();
            brands.add(new Brand(time, value));
        }

        // dp[i][t] = max value using first i brands within time t
        int[][] dp = new int[n + 1][T + 1];

        for (int i = 1; i <= n; i++) {
            Brand b = brands.get(i - 1);
            for (int t = 0; t <= T; t++) {
                dp[i][t] = dp[i - 1][t]; // skip brand
                if (t >= b.t) {
                    dp[i][t] = Math.max(dp[i][t], dp[i - 1][t - b.t] + b.v);
                }
            }
        }

        System.out.println(dp[n][T]);
        sc.close();
    }
}
