package _0425;

import java.util.*;

public class DefenseGame {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pQ =
                new PriorityQueue<>(Collections.reverseOrder());

        int cnt = 0;

        for (int i = 0; i < enemy.length; i++) {
            int now = enemy[i];
            pQ.add(now);
            n -= now;

            if (k > 0 && n < 0) {
                n += pQ.poll();
                k--;
            } else if (n < 0) {
                break;
            }

            cnt++;

        }
        return cnt;
    }
}
