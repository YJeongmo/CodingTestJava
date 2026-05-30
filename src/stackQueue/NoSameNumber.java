package stackQueue;

import java.util.*;

public class NoSameNumber {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();

        int before = -1;
        for (int k : arr) {
            if (k == before) {
                continue;
            }

            before = k;
            list.add(k);
        }


        return list.stream().mapToInt(i -> i).toArray();
    }
}