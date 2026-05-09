package _05._0509;

public class DeliverAndPickup_17timeout {

    int distD = 0;
    int distP = 0;

    int[] remainDeliver;
    int[] remainPickup;

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        distD = findDist(deliveries, n-1);
        distP = findDist(pickups, n-1);

        remainDeliver = deliveries.clone();
        remainPickup = pickups.clone();

        while (distD >= 0 || distP >= 0) {
            int far = Math.max(distD, distP);
            answer += (long)(far + 1) * 2;

            deliverAndPickup(far, cap);

        }

        return answer;
    }

    public int findDist (int[] arr, int k) {
        int dist = k;
        while (dist >= 0) {
            if (arr[dist] != 0) {
                break;
            }
            dist--;
        }

        return dist;
    }

    public void deliverAndPickup (int dist, int cap) {

        int remainD = cap;
        int remainP = cap;
        for (int i = dist; i >= 0; i--) {

            if (remainD == 0 && remainP == 0) {
                break;
            }

            // 배달 처리
            if (remainDeliver[i] != 0 && remainD != 0) {

                if (remainDeliver[i] > remainD) {
                    remainDeliver[i] -= remainD;
                    remainD = 0;
                } else if (remainDeliver[i] < remainD) {
                    remainD -= remainDeliver[i];
                    remainDeliver[i] = 0;
                } else {
                    remainDeliver[i] = 0;
                    remainD = 0;
                }

            }

            // 회수처리
            if (remainPickup[i] != 0 && remainP != 0) {

                if (remainPickup[i] > remainP) {
                    remainPickup[i] -= remainP;
                    remainP = 0;
                } else if (remainPickup[i] < remainP) {
                    remainP -= remainPickup[i];
                    remainPickup[i] = 0;
                } else {
                    remainPickup[i] = 0;
                    remainP = 0;
                }

            }
        }

        distD = findDist(remainDeliver, dist);
        distP = findDist(remainPickup, dist);

    }

}
