class Solution {
    // 1 2 3 4
    // #1: result: 24 12 4 1
    // #2: result: 24 12 8 6
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int product = 1;
        for (int i = nums.length - 1; i >= 0; i--)
        {
          result[i] = product;

          product *= nums[i];
        }

        product = 1;
        for (int i = 0; i < nums.length; i++)
        {
          result[i] = result[i] * product;

          product *= nums[i];
        }

        return result;
    }
}