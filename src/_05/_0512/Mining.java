package _05._0512;

import java.util.*;

class Mining {
    public int solution(int[] picks, String[] minerals) {

        int maxMinerals = (picks[0] + picks[1] + picks[2]) * 5;

        List<int[]> list = new ArrayList<>();

        int cnt = 0;
        int sum = 0;
        int start = 0;
        for (int i = 0; i < minerals.length && i < maxMinerals; i++) {
            String mineral = minerals[i];

            if (mineral.equals("diamond")) {
                sum += 25;
            }
            else if (mineral.equals("iron")) {
                sum += 5;
            }
            else {
                sum += 1;
            }
            cnt++;

            if (cnt == 1) {
               start = i;
            }

            if (cnt == 5 || i == minerals.length - 1) {
                list.add(new int[]{sum, start});
                cnt = 0;
                sum = 0;
            }

        }

        list.sort((a, b) -> b[0] - a[0]);

        int answer = 0;
        for (int[] now : list) {
            int idx = now[1];

            int pick = -1;
            for (int i = 0; i < 3; i++) {

                if (picks[i] > 0) {

                    pick = i;
                    picks[i]--;
                    break;
                }
            }

            if (pick == -1) {
                break;
            }


            for (int i = idx; i < idx + 5 && i < minerals.length; i++) {
                int k = 0;
                if (minerals[i].equals("diamond")) {
                    k = 25;
                } else if (minerals[i].equals("iron")) {
                    k = 5;
                } else {
                    k = 1;
                }

                int pickValue = 0;

                if (pick == 0) {
                    pickValue = 25;
                }
                else if (pick == 1) {
                    pickValue = 5;
                }
                else {
                    pickValue = 1;
                }

                answer += Math.max(1, k / pickValue);
            }
        }

        return answer;
    }
}
