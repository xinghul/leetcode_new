class Solution {
    public void wiggleSort(int[] nums) {
        boolean increasing = true;

        for (int i = 0; i < nums.length - 1; i++)
        {
            if (increasing) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            } else {
                if (nums[i] < nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            }

            increasing = !increasing;
        }
    }

    private void swap(int[] nums, int i, int j) {
      int tmp = nums[i];
      nums[i] = nums[j];
      nums[j] = tmp;
    }
}