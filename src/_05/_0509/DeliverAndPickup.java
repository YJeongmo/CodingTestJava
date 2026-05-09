package _05._0509;

public class DeliverAndPickup {

    int distD;
    int distP;

    int[] remainDeliver;
    int[] remainPickup;

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {

        remainDeliver = deliveries.clone();
        remainPickup = pickups.clone();

        distD = findDist(remainDeliver, n - 1);
        distP = findDist(remainPickup, n - 1);

        long answer = 0;

        while (distD >= 0 || distP >= 0) {

            int far = Math.max(distD, distP);

            answer += (long)(far + 1) * 2;

            deliverAndPickup(far, cap);
        }

        return answer;
    }

    public int findDist(int[] arr, int k) {

        while (k >= 0 && arr[k] == 0) {
            k--;
        }

        return k;
    }

    public void deliverAndPickup(int far, int cap) {

        int remainD = cap;
        int remainP = cap;

        for (int i = far; i >= 0; i--) {

            if (remainD == 0 && remainP == 0) {
                break;
            }

            // 배달 처리
            if (remainD > 0 && remainDeliver[i] > 0) {

                int deliver = Math.min(remainDeliver[i], remainD);

                remainDeliver[i] -= deliver;
                remainD -= deliver;
            }

            // 수거
            if (remainP > 0 && remainPickup[i] > 0) {

                int pickup = Math.min(remainPickup[i], remainP);

                remainPickup[i] -= pickup;
                remainP -= pickup;
            }

        }

        // 다음 배달 위치
        while (distD >= 0 && remainDeliver[distD] == 0) {
            distD--;
        }

        // 다음 수거 위치
        while (distP >= 0 && remainPickup[distP] == 0) {
            distP--;
        }
    }


}