package _0421;

public class TwoxNTiling {
    class Solution {
        private static final int DEFINE = 1_000_000_007;

        public int solution(int n) {

            int answer = 0;
            int dp[] = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2;

            for (int i = 3; i < n + 1; i++) {
                dp[i] = (dp[i-2] + dp[i-1]) % DEFINE;
            }

            return dp[n];
        }
    }
}
