package stackQueue;

import java.util.*;

class TruckCrossingBridge {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Deque <Integer> deq = new ArrayDeque<>();
        for (int i = 0; i < bridge_length; i++) {
            deq.offer(0);
        }

        int answer = 0;

        int nowWeight = 0;
        int idx = 0;
        while (idx < truck_weights.length) {
            nowWeight -= deq.poll();

            if (nowWeight + truck_weights[idx] <= weight) {
                deq.offer(truck_weights[idx]);
                nowWeight += truck_weights[idx];
                idx++;
            } else {
                deq.offer(0);
            }

            answer++;

        }

        return answer + bridge_length;
    }
}
