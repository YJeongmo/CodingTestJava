package _05._0504;

import java.util.*;

class OilDrilling_fail {
    public int solution(int[][] land) {
        int maxCnt = 0;
        int n = land.length;
        int m = land[0].length;

        for (int j = 0; j < land[0].length; j++) {
            boolean[][] visited = new boolean[n][m];
            int totalCnt = 0;

            for(int i = 0; i < land.length; i++) {

                if (land[i][j] == 1 && !visited[i][j]) {
                    int cnt = bfs(land, i, j, visited);
                    totalCnt += cnt;
                }
            }

            maxCnt = Math.max(maxCnt, totalCnt);

        }
        return maxCnt;
    }

    public int bfs(int[][] land, int a, int b, boolean[][] visited) {
        int n = land.length;
        int m = land[0].length;
        int cnt = 1;

        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};

        Deque<int[]> deq = new ArrayDeque<>();
        deq.offer(new int[]{a, b});
        visited[a][b] = true;
        while (!deq.isEmpty()) {
            int[] now = deq.poll();
            int x = now[0];
            int y = now[1];


            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {

                    if (land[nx][ny] == 1 && !visited[nx][ny]) {
                        cnt++;
                        visited[nx][ny] = true;
                        deq.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        return cnt;
    }
}
