// 1 0 2 0 3

class Solution {
    public void moveZeroes(int[] nums) {
        int zeroIndex = 0;

        for (int i = 0; i < nums.length; i++)
        {
          if (nums[i] != 0) {
            int tmp = nums[zeroIndex];
            nums[zeroIndex] = nums[i];
            nums[i] = tmp;

            zeroIndex++;
          }
        }
    }
}