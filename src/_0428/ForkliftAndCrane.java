package _0428;

import java.util.*;

class ForkliftAndCrane {

    char[][] board;

    public int solution(String[] storage, String[] requests) {
        board = makeMap(storage);
        int cnt = 0;

        for (String s : requests) {
            if (s.length() == 1) {
                bfs(s.charAt(0));
            } else {
                remove(s.charAt(0));
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '0') {
                    cnt++;
                }
            }
        }

        return cnt;
    }


    public void bfs (char target) {
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};

        int n = board.length;
        int m = board[0].length;

        boolean visited[][] = new boolean[board.length][board[0].length];

        Deque<int[]> deq = new ArrayDeque<>();
        List<int[]> removeList = new ArrayList<>();
        deq.offer(new int[]{0, 0});

        while(!deq.isEmpty()) {
            int[] xy = deq.poll();
            int x = xy[0];
            int y = xy[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m && !visited[nx][ny]) {
                    visited[nx][ny] = true;

                    if (board[nx][ny] == target) {
                        removeList.add(new int[]{nx, ny});
                    } else if (board[nx][ny] == '0') {
                        visited[nx][ny] = true;
                        deq.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        for (int[] p : removeList) {
            board[p[0]][p[1]] = '0';
        }
    }

    public void remove (char target) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == target) {
                    board[i][j] = '0';
                }
            }
        }
    }


    public char[][] makeMap(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();

        char[][] newBoard = new char[n + 2][m + 2];

        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(newBoard[i], '0');
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                newBoard[i + 1][j + 1] = maps[i].charAt(j);
            }
        }

        return newBoard;
    }
}
