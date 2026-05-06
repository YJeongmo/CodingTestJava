package _0506;

class SoloTictactoe {

    public int solution(String[] board) {

        int k = 3; // 보트를 k칸으로 일반화
        int n = board.length;

        int o = 0, x = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i].charAt(j);
                if (c == 'O') o++;
                else if (c == 'X') x++;
            }
        }

        if (o < x || o > x + 1) return 0;

        boolean oWin = hasWin(board, 'O', k);
        boolean xWin = hasWin(board, 'X', k);

        if (oWin && xWin) {
            return 0;
        } else if (oWin && o == x) {
            return 0;
        } else if (xWin && o > x) {
            return 0;
        }

        return 1;
    }

    public boolean hasWin(String[] board, char target, int k) {

        int n = board.length;

        int[] dx = {0, 1, 1, 1};
        int[] dy = {1, 0, 1, -1};

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {

                if (board[x].charAt(y) != target) continue;

                for (int d = 0; d < 4; d++) {

                    int prevX = x - dx[d];
                    int prevY = y - dy[d];

                    if (inRange(prevX, prevY, n)
                            && board[prevX].charAt(prevY) == target) {
                        continue;
                    }

                    int cnt = 0;
                    int nx = x;
                    int ny = y;

                    while (inRange(nx, ny, n)
                            && board[nx].charAt(ny) == target) {

                        cnt++;
                        nx += dx[d];
                        ny += dy[d];
                    }

                    if (cnt >= k) return true;
                }
            }
        }

        return false;
    }

    private boolean inRange(int x, int y, int n) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}
