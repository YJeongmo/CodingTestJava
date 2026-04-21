import java.util.*;

public class MakeBothQueSame {
    public int solution(int[] queue1, int[] queue2) {
        int cnt = 0;

        Deque<Integer> que1 = new ArrayDeque<>();
        long sum1 = 0;
        for (int n : queue1) {
            que1.addLast(n);
            sum1 += n;
        }

        Deque<Integer> que2 = new ArrayDeque<>();
        long sum2 = 0;
        for (int n : queue2) {
            que2.addLast(n);
            sum2 += n;
        }

        if ((sum1 + sum2) % 2 != 0) {
            return -1;
        }

        int n = queue1.length * 3;
        int i = 0;
        while (i < n) {
            if (sum1 > sum2) {
                int k = que1.pollFirst();
                que2.offerLast(k);
                sum1 -= k;
                sum2 += k;
            } else if (sum1 < sum2) {
                int k = que2.pollFirst();
                que1.offerLast(k);
                sum2 -= k;
                sum1 += k;
            } else if (sum1 == sum2) {
                return cnt;
            }

            cnt++;
            i++;

        }
        return -1;
    }
}