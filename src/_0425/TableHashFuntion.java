package _0425;

import java.util.*;

public class TableHashFuntion {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        Arrays.sort(data, (a, b) -> {
            if (a[col - 1] != b[col - 1]) {
                return a[col - 1] - b[col - 1];
            } else {
                return b[0] - a[0];
            }
        });

        for (int i = row_begin; i < row_end + 1; i++) {
            int S_I = 0;
            for (int k : data[i - 1]) {
                S_I += k % i;
            }
            answer ^= S_I;
        }
        
        return answer;
    }
}
