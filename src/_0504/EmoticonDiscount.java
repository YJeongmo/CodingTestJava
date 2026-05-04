package _0504;

class EmoticonDiscount {
    public int[] solution(int[][] users, int[] emoticons) {

        int maxCount = 0;
        int maxSale = 0;

        int[][] allCase = madeAllCase(emoticons);

        for (int i = 0; i < allCase.length; i++) {

            int[] discountRate = allCase[i];
            int count = 0;
            int sale = 0;

            for (int j = 0; j < users.length; j++) {

                int buyRate = users[j][0];
                int maxPrice = users[j][1];
                int totalPrice = 0;

                for (int k = 0; k < emoticons.length; k++) {

                    if (discountRate[k] >= buyRate) {
                        totalPrice += emoticons[k] * (100 - discountRate[k]) / 100;
                    }
                }

                if (totalPrice >= maxPrice) {
                    count++;
                } else {
                    sale += totalPrice;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                maxSale = sale;
            } else if (count == maxCount) {
                maxSale = Math.max(maxSale, sale);
            }
        }
        return new int[]{maxCount, maxSale};
    }

    public int[][] madeAllCase(int[] emoticons) {

        int[] kind = new int[]{10, 20, 30, 40};
        int n = emoticons.length;
        int size = (int)Math.pow(4, n);

        int[][] result = new int[size][n];

        for (int i = 0; i < size; i++) {
            int temp = i;
            for (int j = n; j > 0; j--) {
                result[i][j] = kind[temp % 4];
                temp /= 4;
            }
        }
        return result;
    }
}