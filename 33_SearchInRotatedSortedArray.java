class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high)
        {
          int mid = low + (high - low) / 2;

          if (nums[mid] == target) {
            return mid;
          }

          // no pivot in [low...mid]
          if (nums[low] <= nums[mid]) {
            if (nums[low] <= target && target < nums[mid]) {
              high = mid - 1;
            } else {
              low = mid + 1;
            }
          } else {
            // nums[low] > nums[mid], pivot in [low...mid]
            if (nums[mid] < target && target <= nums[high]) {
              low = mid + 1;
            } else {
              high = mid - 1;
            }
          }

        }

        return -1;
    }
}