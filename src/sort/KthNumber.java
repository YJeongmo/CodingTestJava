package sort;

import java.util.*;

class KthNumber {
    public int[] solution(int[] array, int[][] commands) {
        int n = commands.length;
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            int s = commands[i][0];
            int e = commands[i][1];
            int k = commands[i][2];

            int[] temp = new int[e - s + 1];
            for (int j = s - 1; j < e; j++) {
                temp[j - s + 1] = array[j];
            }

            Arrays.sort(temp);
            answer[i] = temp[k - 1];
        }

        return answer;
    }
}