package stackQueue;


import java.util.*;

class Process {
    public int solution(int[] priorities, int location) {

        Deque<Integer> deq = new ArrayDeque<>();
        for (int p : priorities) {
            deq.offer(p);
        }

        int answer = 0;

        int[] check = priorities.clone();
        Arrays.sort(check);
        int idx = check.length - 1;

        while (true) {
            int now = deq.poll();

            if (check[idx] == now) {

                answer++;

                if (location == 0) {
                    break;
                }

                location--;
                idx--;
                continue;
            }

            if (location == 0) {
                location = deq.size();
                deq.offer(now);
            } else {
                location--;
                deq.offer(now);
            }
        }

        return answer;
    }
}