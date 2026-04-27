package _0427;

import java.util.*;

class TowerOfHanoi {

    List<int[]> list = new ArrayList<>();

    public int[][] solution(int n) {
        move(n, 1, 2, 3);
        return list.toArray(new int[0][]);
    }

    public void move (int n, int start, int mid, int end) {

        if (n == 1) {
            list.add(new int[]{start, end});
            return;
        }

        move(n - 1, start, end, mid);
        list.add(new int[]{start, end});
        move(n - 1, mid, start, end);
    }
}
