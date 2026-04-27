package _0427;

import java.util.*;

class DesertIslandTrip {

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};


    public int[] solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        boolean[][] visited = new boolean[n][m];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    int sum = dfs(maps, visited, i, j);
                    list.add(sum);
                }

            }
        }

        if (list.isEmpty()) {
            return new int[]{-1};
        } else {
            Collections.sort(list);
            return list.stream().mapToInt(i -> i).toArray();
        }

    }

    int dfs (String[] maps, boolean[][] visited, int x, int y) {
        int n = maps.length;
        int m = maps[0].length();

        int total = maps[x].charAt(y) - '0';
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                if (!visited[nx][ny] && maps[nx].charAt(ny) != 'X') {
                    total += dfs(maps, visited, nx, ny);
                }
            }
        }
        return total;
    }
}