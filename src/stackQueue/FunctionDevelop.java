package stackQueue;

import java.util.*;

class FunctionDevelop {
    public int[] solution(int[] progresses, int[] speeds) {

        Deque <int[]> deq = new ArrayDeque<>();
        for (int i = 0; i < progresses.length; i++) {
            deq.offer(new int[]{progresses[i], speeds[i]});
        }

        List <Integer> list = new ArrayList<>();

        int cnt = 0;
        while (!deq.isEmpty()) {

            while (!deq.isEmpty() && deq.peek()[0] >= 100) {
                deq.poll();
                cnt++;
            }

            if (cnt > 0) {
                list.add(cnt);
                cnt = 0;
            }

            int size = deq.size();
            for (int i = 0; i < size; i++) {
                int[] now = deq.poll();
                deq.offer(new int[]{now[0] + now[1], now[1]});
            }


        }


        return list.stream().mapToInt(i -> i).toArray();
    }
}