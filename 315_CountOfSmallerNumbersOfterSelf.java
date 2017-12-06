class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();
		List<Integer> count = new ArrayList<>();

		// O(n ^ 2), O(n)
		for (int i = nums.length - 1; i >= 0; i--)
		{
			int index = getIndex(list, nums[i]);

			// list.get(index) >= nums[i]
			count.add(0, index);

			list.add(index, nums[i]);
		}

		return count;
    }

	private int getIndex(List<Integer> list, int num) {
		int low = 0;
		int high = list.size() - 1;

		if (list.size() == 0 || list.get(low) >= num) {
			return 0;
		}
		if (list.get(high) < num) {
			return high + 1;
		}

		int index = high + 1;
		while (low <= high)
		{
			int mid = low + (high - low) / 2;

			if (list.get(mid) >= num) {
				index = mid;

				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return index;
	}
}