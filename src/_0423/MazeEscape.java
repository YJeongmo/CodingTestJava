package _0423;

import java.util.*;

class MazeEscape {
    public int solution(String[] maps) {
        int answer = 0;
        int[] start = findTarget(maps, 'S');
        int[] lever = findTarget(maps, 'L');
        int[] end = findTarget(maps, 'E');

        int sToL = bfs(maps, start, lever);
        int lToE = bfs(maps, lever, end);

        if (sToL == -1 || lToE == -1) {
            return -1;
        }

        return sToL + lToE;
    }

    public int bfs(String[] maps, int[] s, int[] e) {
        int n = maps.length;
        int m = maps[0].length();

        boolean[][] visited = new boolean[n][m];

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{s[0], s[1], 0});
        visited[s[0]][s[1]] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int dist = now[2];

            if (x == e[0] && y == e[1]) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (!visited[nx][ny] && maps[nx].charAt(ny) != 'X') {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny, dist + 1});
                    }
                }
            }
        }

        return -1;
    }

    public int[] findTarget(String[] maps, char target) {
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (maps[i].charAt(j) == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}