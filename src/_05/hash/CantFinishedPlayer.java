package _05.hash;

import java.util.*;

public class CantFinishedPlayer {
    public String solution(String[] participant, String[] completion) {

        Map<String, Integer> par = new HashMap<>();
        for (String s : participant) {
            par.put(s , par.getOrDefault(s, 0) + 1);
        }

        Map<String, Integer> com = new HashMap<>();
        for (String s : completion) {
            com.put(s, com.getOrDefault(s, 0) + 1);
        }


        for (String s : participant) {
            int a = par.getOrDefault(s, 0);
            int b = com.getOrDefault(s, 0);

            if (a != b) {
                return s;
            }
        }

        return "";
    }
}
