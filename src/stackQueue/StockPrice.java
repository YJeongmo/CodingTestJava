package stackQueue;

import java.util.*;

class StockPrice {
    public int[] solution(int[] prices) {

        int[] answer = new int[prices.length];
        int n = prices.length;

        Stack <int[]> stack = new Stack<>();


        for (int i = 0; i < prices.length; i++) {
            int now = prices[i];

            while (!stack.isEmpty() && stack.peek()[0] > now) {
                int[] del = stack.pop();
                answer[del[1]] = i - del[1];
            }

            stack.push(new int[]{now, i});
        }

        while (!stack.isEmpty()) {
            int[] del = stack.pop();
            answer[del[1]] = n - del[1] - 1;
        }


        return answer;
    }
}