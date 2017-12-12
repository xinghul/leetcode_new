class Solution {
    public void sortColors(int[] nums) {
        int low = 0, high = nums.length - 1;
        int mid = 0;
        
        while (mid <= high)
        {
          if (nums[mid] == 0) {
            // swap low mid
            int tmp = nums[mid];
            nums[mid] = nums[low];
            nums[low] = tmp;

            low++;
            mid++;
          } else if (nums[mid] == 1) {
              mid++;
          } else {
            // swap high mid
            int tmp = nums[mid];
            nums[mid] = nums[high];
            nums[high] = tmp;

            high--;
          }
        }
    }
}