class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int left = 0;
		while (left < nums.length - 1 && nums[left] <= nums[left + 1])
		{
			left++;
		}

		int right = nums.length - 1;
		while (right > 0 && nums[right] >= nums[right - 1])
		{
			right--;
		}

		int min = Integer.MAX_VALUE;
		// nums[left] > nums[left + 1]
		for (int i = left + 1; i < nums.length; i++)
		{
			if (min > nums[i]) {
				min = nums[i];
			}
		}
		
		// nums[right] < nums[right - 1]
		int max = Integer.MIN_VALUE;
		for (int i = 0; i <= right - 1; i++)
		{
			if (max < nums[i]) {
				max = nums[i];
			}
		}

		// now we have min and max
		// adjust left and right
		while (left >= 0 && min < nums[left])
		{
			left--;
		}
		while (right < nums.length && max > nums[right])
		{
			right++;
		}

		// now nums[0...left] and nums[right...length - 1] are correct
		if (left >= right) {
			return 0;
		}

		return right - left - 1;
    }
}