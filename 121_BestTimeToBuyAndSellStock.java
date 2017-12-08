// => 0
// 1 => 0
// 2 1 => 0
// 3 2 1 2 3 => 2

class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++)
        {
          if (min > prices[i]) {
            min = prices[i];
          }

          if (prices[i] - min > maxProfit) {
            maxProfit = prices[i] - min;
          }
        }

        return maxProfit;
    }
}