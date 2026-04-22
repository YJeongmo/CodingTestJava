package _0422;
import java.util.*;

class TriangleSnail {
    public Integer[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        int[][] arr = madeSnail(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                list.add(arr[i][j]);
            }
        }
        return list.toArray(new Integer[0]);
    }

    public int[][] madeSnail(int n) {
        int[][] arr = new int[n][n];

        int[] dx = new int[]{1, 0, -1};
        int[] dy = new int[]{0, 1, -1};

        int len = n;
        int fill = 1;

        int x = 0, y = 0, d = 0;

        while (len > 0) {
            for (int i = 0; i < len; i++) {
                arr[x][y] = fill;
                fill++;

                if (i < len - 1) {
                    x += dx[d];
                    y += dy[d];
                }

            }
            d = (d + 1) % 3;
            len--;

            x += dx[d];
            y += dy[d];
        }
        return arr;
    }
}