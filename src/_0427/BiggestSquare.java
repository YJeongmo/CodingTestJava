package _0427;

class BiggestSquare {
    public int solution(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] dp = new int[n][m];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                        answer = Math.max(answer, 1);
                    } else {
                        int temp = 0;
                        temp = Math.min(dp[i-1][j],
                                Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                        dp[i][j] = temp;
                        answer = Math.max(answer, temp);
                    }
                }
            }
        }

        return answer*answer;
    }
}