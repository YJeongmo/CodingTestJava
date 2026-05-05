package _0505;

import java.util.*;

class CandidateKey {
    public int solution(String[][] relation) {
        int n = relation.length;
        int m = relation[0].length;

        List<Integer> candidates = new ArrayList<>();

        for (int bit = 1; bit < (1 << m); bit++) {

            // 최소성 확인
            boolean minimality = true;
            for (int key : candidates) {
                if ((key & bit) == key) {
                    minimality = false;
                    break;
                }
            }

            if (!minimality) {
                continue;
            }


            // 유일성 확인
            Set<String> set = new HashSet<>();

            for (int i = 0; i < n; i++) {
                String now = "";
                for (int j = 0; j < m; j++) {
                    if ((bit & (1 << j)) != 0) {
                        now += relation[i][j];
                    }
                }
                set.add(now);
            }

            if (set.size() == n) {
                candidates.add(bit);
            }

        }
        return candidates.size();
    }
}
