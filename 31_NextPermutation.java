class Solution {
    public void nextPermutation(int[] nums) {
      // from tail to head, find the decreasing point
      // switch decreasing point with next larger number after
      // sort the sub array after decreasing point
      int i = nums.length - 1;
      while (i > 0 && nums[i] <= nums[i - 1])
      {
        i--;
      }

      if (i == 0) {
        Arrays.sort(nums);

        return;
      }
      
      int pos = i - 1;
      int j = nums.length - 1;
      while (nums[j] <= nums[pos])
      {
        j--;
      }
        
      int tmp = nums[pos];
      nums[pos] = nums[j];
      nums[j] = tmp;

      Arrays.sort(nums, i, nums.length);
    }
}