// naive approach
class Solution {

    Map<Integer, Integer> map = new HashMap<>();
    public int maxProfit(int[] prices) {
        // getProfit(prices, int start) returns the max profit starting from day start.
        // at a given day i, try each following day, where j > i and profit = prices[j] - prices[i] > 0

        return getProfit(prices, 0);
    }

    private int getProfit(int[] prices, int start) {
        if (start >= prices.length - 1) {
            return 0;
        }
        if (map.containsKey(start)) {
            return map.get(start);
        }

        int max = 0;
        for (int j = start + 1; j < prices.length; j++)
        {
            int maxProfit = 0;
            if (prices[start] < prices[j]) {
                int profit = prices[j] - prices[start];

                maxProfit = Math.max(profit + getProfit(prices, j + 2), getProfit(prices, j));
                
            } else {
                maxProfit = getProfit(prices, j);
            }

            max = Math.max(maxProfit, max);
        }

        map.put(start, max);

        return max;
    }
}

// dp
class Solution {
    public int maxProfit(int[] prices) {
        // maintain two array, buy[i] and sell[i], where buy[i] stores the max profit if we buy at i, sell[i] stores the max profit if we sell at i
        // buy[i] = max(buy[i - 1], sell[i - 2] - prices[i])
        // sell[i] = max(sell[i - 1], buy[i - 1] + prices[i])
        // in the end, return sell[n - 1]

        if (prices.length < 2) {
            return 0;
        }

        int b0 = -prices[0], b1 = b0;
        int s2 = 0, s1 = 0, s0 = 0;

        for (int i = 1; i < prices.length; i++)
        {
            b0 = Math.max(b1, s2 - prices[i]);
            s0 = Math.max(s1, b1 + prices[i]);
            b1 = b0;
            s2 = s1;
            s1 = s0;
        }

        return s0;
    }

    
}