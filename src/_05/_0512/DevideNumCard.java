package _05._0512;

class DevideNumCard {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA = arrayGCD(arrayA);
        int gcdB = arrayGCD(arrayB);

        for (int b : arrayB) {
            if (b % gcdA == 0) {
                gcdA = 0;
                break;
            }
        }

        for (int a : arrayA) {
            if (a % gcdB == 0) {
                gcdB = 0;
                break;
            }
        }


        return Math.max(gcdA, gcdB);
    }

    int arrayGCD (int[] arr) {
        int gcd = arr[0];

        for (int i = 1; i < arr.length; i++) {
            gcd = GCD(gcd, arr[i]);
        }
        return gcd;
    }

    int GCD (int a, int b) {

        while (b != 0) {
            int temp = a % b;

            a = b;
            b = temp;

        }
        return a;
    }
}
