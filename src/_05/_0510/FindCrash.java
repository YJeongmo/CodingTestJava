package _05._0510;

import java.util.*;

class FindCrash {

    int finish;
    int[][] robotNow;

    public int solution(int[][] points, int[][] routes) {

        finish = 0;

        int robotCount = routes.length;
        robotNow = new int[robotCount][2];

        int[] routeIndex = new int[robotCount];
        boolean[] end = new boolean[robotCount];

        // 시작 위치 세팅
        for (int i = 0; i < robotCount; i++) {

            int s = routes[i][0] - 1;
            robotNow[i] = points[s].clone();

            // 첫 번째 목적지
            routeIndex[i] = 1;
        }

        int answer = 0;

        while (true) {

            // 충돌 체크
            Map<String, Integer> map = new HashMap<>();

            for (int i = 0; i < robotCount; i++) {

                if (end[i]) {
                    continue;
                }

                String key = robotNow[i][0] + "," + robotNow[i][1];
                map.put(key, map.getOrDefault(key, 0) + 1);
            }

            for (int cnt : map.values()) {

                if (cnt >= 2) {
                    answer++;
                }
            }

            // 도착 완료 로봇 제거
            for (int i = 0; i < robotCount; i++) {

                if (!end[i] && routeIndex[i] == routes[i].length) {
                    end[i] = true;
                    finish++;
                }
            }

            // 모든 로봇 종료
            if (finish == robotCount) {
                break;
            }

            // 로봇 이동
            for (int i = 0; i < robotCount; i++) {

                if (end[i]) {
                    continue;
                }

                int target = routes[i][routeIndex[i]] - 1;
                robotNow[i] = nextPosition(robotNow[i], points[target]);

                if (robotNow[i][0] == points[target][0] && robotNow[i][1] == points[target][1]) {
                    routeIndex[i]++;
                }
            }
        }

        return answer;
    }

    int[] nextPosition(int[] start, int[] end) {

        if (start[0] != end[0]) {
            return new int[] {start[0] + (start[0] < end[0] ? 1 : -1), start[1]};
        }

        if (start[1] != end[1]) {
            return new int[] {start[0], start[1] + (start[1] < end[1] ? 1 : -1)};
        }

        return start;
    }
}