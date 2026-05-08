package _05._0508;

public class ArcheryCompetition {
    int[] best = new int[11];
    boolean win = false;
    int maxDiff = 0;
    public int[] solution(int n, int[] info) {

        dfs(info, n, 0, 0, 0, new int[11]);

        if (!win) {
            return new int[]{-1};
        }

        return best;
    }

    public void dfs (int[] info, int remain, int idx, int Apeach, int Rion, int[] arrow) {

        if (idx == 11) {

            if (remain > 0) {
                arrow[10] += remain;
            }

            int diff = Rion - Apeach;

            if (diff > 0) {
                if (diff > maxDiff) {

                    maxDiff = diff;
                    best = arrow.clone();
                    win = true;

                } else if (diff == maxDiff) {

                    if (better(arrow, best)) {
                        best = arrow.clone();
                    }
                }
            }

            if (remain > 0) {
                arrow[10] -= remain;
            }

            return;
        }

        int point = 10 - idx;

        int need = info[idx] + 1;

        // 점수 획득
        if (remain >= need) {
            arrow[idx] = need;
            dfs(info, remain - need, idx + 1, Apeach, Rion + point, arrow);

            arrow[idx] = 0;
        }

        // 점수 포기
        dfs(info, remain, idx + 1, Apeach + (info[idx] > 0 ? point : 0), Rion, arrow);

    }

    boolean better(int[] now, int[] best) {

        for (int i = 10; i >= 0; i--) {

            if (now[i] > best[i]) {
                return true;
            }

            if (now[i] < best[i]) {
                return false;
            }
        }

        return false;
    }
}