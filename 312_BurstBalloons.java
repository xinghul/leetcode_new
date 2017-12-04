class Solution {
    public int maxCoins(int[] nums) {
        int[] balloons = new int[nums.length + 2];

        int index = 1;
        for (int i = 0; i < nums.length; i++)
        {
          if (nums[i] > 0) {
            balloons[index++] = nums[i];
          }
        }

        balloons[0] = 1;
        balloons[index] = 1;

        int[][] coins = new int[index + 1][index + 1];

        burst(balloons, coins, 0, index);

        return coins[0][index];
    }

    private int burst(int[] nums, int[][] mem, int start, int end) {
      if (start + 1 >= end) {
        return 0;
      }

      if (mem[start][end] > 0) {
        return mem[start][end];
      }

      int max = 0;
      for (int i = start + 1; i < end; i++)
      {
        max = Math.max(max,
          nums[start] * nums[i] * nums[end]
          + burst(nums, mem, start, i) + burst(nums, mem, i, end));
      }

      mem[start][end] = max;
      return max;
    }
}