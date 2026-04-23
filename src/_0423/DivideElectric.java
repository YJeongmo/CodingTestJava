package _0423;

class DivideElectric {
    public int solution(int n, int[][] wires) {
        int answer = n;

        for (int i = 0; i < wires.length; i++) {
            boolean[] visited = new boolean[n + 1];
            int cnt = dfs(wires, visited, i, 1);
            answer = Math.min(answer, Math.abs(n - 2 * cnt));
        }
        return answer;
    }

    public int dfs(int[][] wires, boolean[] visited, int skip, int now) {
        int count = 1;
        visited[now] = true;
        for (int i = 0; i < wires.length; i++) {
            if (i == skip) {
                continue;
            }

            int a = wires[i][0];
            int b = wires[i][1];

            if(a == now && !visited[b]) {
                count += dfs(wires, visited, skip, b);
            } else if (b == now && !visited[a]) {
                count += dfs(wires, visited, skip, a);
            }


        }

        return count;
    }
}