package _05._0508;

public class Joystick {
    public int solution(String name) {
        char[] charName = name.toCharArray();
        int n = charName.length;
        int move = n - 1;

        int answer = 0;

        for (int i = 0; i < n; i++) {
            char now = charName[i];
            int change = Math.min(now - 'A', 'Z' - now + 1);
            answer += change;

            int nextIdx = i + 1;
            while (nextIdx < n && charName[nextIdx] == 'A') {
                nextIdx++;
            }

            // 뒤쪽 먼저 탐색
            move = Math.min(move, (n - nextIdx) * 2 + i);
            // 앞쪽 먼저 탐색
            move = Math.min(move, 2 * i + n - nextIdx);

        }
        return answer + move;
    }
}