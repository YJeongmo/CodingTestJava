package sort;

import java.util.*;

class HIndex {
    public int solution(int[] citations) {

        int n = citations.length;
        Arrays.sort(citations);

        for (int i = 0; i < n; i++) {
            int k = n - i;
            if (citations[i] >= k) {
                return k;
            }
        }

        return 0;
    }
}
