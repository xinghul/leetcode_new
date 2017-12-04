class Solution {
    public int findPeakElement(int[] nums) {
        // since nums[-1] = INTEGER.MIN_VALUE
        // it's increasing from beginning, find the decreasing point.
        if (nums.length == 0) {
          return -1;
        }
        if (nums.length == 1) {
          return 0;
        }

        int index = 0;
        while (index < nums.length - 1 && nums[index] < nums[index + 1]) {
          index ++;
        }

        return index;
    }
}