package _0425;

import java.util.*;

class MenuRenewal {
    public String[] solution(String[] orders, int[] course) {

        Map<String, Integer> map = new HashMap<>();

        for (String order : orders) {
            char[] arr = order.toCharArray();
            Arrays.sort(arr);
            order = new String(arr);

            for (int len : course) {
                comb(order, 0, len, new StringBuilder(), map);
            }
        }

        Map<Integer, Integer> maxCnt = new HashMap<>();
        for (String key : map.keySet()) {
            int len = key.length();
            int cnt = map.get(key);
            if (cnt >= 2) {
                maxCnt.put(len, Math.max(maxCnt.getOrDefault(len, 0), cnt));
            }
        }

        List<String> result = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key) == maxCnt.get(key.length())) {
                result.add(key);
            }
        }

        Collections.sort(result);
        return result.toArray(new String[0]);
    }


    void comb(String order, int idx, int len,
              StringBuilder sb, Map<String, Integer> map) {

        if (sb.length() == len) {
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }

        for (int i = idx; i < order.length(); i++) {
            sb.append(order.charAt(i));
            comb(order, i + 1, len, sb, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}

