package _05._0507;

import java.util.*;

class InterceptionSystem {
    public int solution(int[][] targets) {
        int cnt = 0;

        Arrays.sort(targets, (a, b) -> b[0] - a[0]);
        double k = targets[0][1] + 1;

        for (int[] target : targets) {
            double start = target[0];
            double end = target[1];

            if (start < k && k < end) {
                continue;
            }

            k = start + 0.1;
            cnt++;

        }

        return cnt;
    }
}
