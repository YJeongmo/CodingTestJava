package _05.hash;

import java.util.*;

public class Clothes {
    public int solution(String[][] clothes) {
        int answer = 1;

        Map <String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            String kind = clothe[1];
            map.put(kind, map.getOrDefault(kind, 0) + 1);
        }


        for (Map.Entry<String, Integer> entry : map.entrySet()){
            answer *= (entry.getValue() + 1);
        }


        return answer - 1;
    }
}
