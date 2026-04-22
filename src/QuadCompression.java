public class QuadCompression {

    int cnt_0 = 0;
    int cnt_1 = 0;

    public int[] solution(int[][] arr) {
        quad(arr, 0, 0, arr.length);

        return new int[]{cnt_0, cnt_1};
    }

    public void quad(int[][] arr, int a, int b, int k) {
        int first = arr[a][b];

        for (int i = a; i < a + k; i++) {
            for (int j = b; j < b + k; j++) {
                if (arr[i][j] != first) {
                    int half = k / 2;
                    quad(arr, a, b, half);
                    quad(arr, a, b + half, half);
                    quad(arr, a + half, b, half);
                    quad(arr, a + half, b + half, half);
                    return;
                }
            }
        }

        if (first == 0) {
            cnt_0++;
        } else {
            cnt_1++;
        }
    }

}
