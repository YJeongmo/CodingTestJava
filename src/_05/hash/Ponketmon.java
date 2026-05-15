package _05.hash;

import java.util.*;

class Ponketmon {
    public int solution(int[] nums) {
        int maxN = nums.length / 2;

        Set<Integer> set = new HashSet<>();
        for (int k : nums) {
            set.add(k);
        }

        return set.size() > maxN ? maxN : set.size();
    }
}
