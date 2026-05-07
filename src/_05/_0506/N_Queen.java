package _05._0506;

class N_Queen {

    int[] queen;
    int count = 0;

    public int solution(int n) {
        queen = new int[n];
        dfs(n, 0);
        return count;
    }


    public void dfs (int n, int x) {

        if (x == n) {
            count++;
            return;
        }

        for (int y = 0; y < n; y++) {
            if (isPossible(x, y)) {
                queen[x] = y;
                dfs(n, x + 1);
            }
        }
    }

    public boolean isPossible(int x, int y) {
        boolean possible = true;

        for (int i = 0; i < x; i++) {

            if (queen[i] == y) {
                possible = false;
            }

            if (Math.abs(x - i) == Math.abs(y - queen[i])) {
                possible = false;
            }
        }
        return possible;
    }

}
