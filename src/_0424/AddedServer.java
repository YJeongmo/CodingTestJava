package _0424;

import java.util.*;

class AddedServer {
    public int solution(int[] players, int m, int k) {
        int cnt = 0;
        int nowServer = 0;

        Deque<Integer> deq = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            deq.offer(0);
        }

        for (int i = 0; i < players.length; i++) {
            int nowPlayer = players[i];

            nowServer -= deq.poll();

            int need = nowPlayer / m - nowServer;

            if (need > 0) {
                nowServer += need;
                cnt += need;
                deq.offer(need);
            } else {
                deq.offer(0);
            }
        }
        return cnt;
    }
}
