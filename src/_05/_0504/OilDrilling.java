package _05._0504;

import java.util.*;

class OilDrilling {
    int[][] group;
    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        group = new int[n][m];

        Map<Integer, Integer> map = new HashMap<>();

        int k = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && group[i][j] == 0) {
                    int count = bfs(land, i, j, k);
                    map.put(k, count);
                    k++;

                }
            }
        }

        int maxCnt = 0;

        for (int j = 0; j < m; j++) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (group[i][j] != 0) {
                    set.add(group[i][j]);
                }
            }

            int total = 0;
            for (int s : set) {
                total += map.get(s);
            }

            maxCnt = Math.max(maxCnt, total);

        }

        return maxCnt;
    }

    public int bfs (int[][] land, int a, int b, int k) {
        int cnt = 1;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int n = land.length;
        int m = land[0].length;

        Deque<int[]> deq = new ArrayDeque<>();
        deq.offer(new int[]{a, b});
        group[a][b] = k;

        while (!deq.isEmpty()) {
            int[] now = deq.poll();
            int x = now[0];
            int y = now[1];

            for (int i = 0; i < 4; i ++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (land[nx][ny] == 1 && group[nx][ny] == 0) {
                        deq.offer(new int[]{nx, ny});
                        group[nx][ny] = k;
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }
}