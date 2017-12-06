class Solution {
    public int trap(int[] height) {
		if (height.length <= 2) {
			return 0;
		}

		int[] maxBefore = new int[height.length];
		int[] maxGlobal = new int[height.length];

		int max = 0;
		maxBefore[0] = 0;
		for (int i = 1; i < height.length; i++)
		{
			max = Math.max(height[i - 1], max);

			maxBefore[i] = max;
		}

		max = 0;
		maxGlobal[height.length - 1] = 0;
		for (int i = height.length - 2; i >= 0; i--)
		{
			max = Math.max(height[i + 1], max);

			maxGlobal[i] = Math.min(max, maxBefore[i]);
		}

		int sum = 0;
		for (int i = 0; i < height.length; i++)
		{
			if (height[i] < maxGlobal[i]) {
				sum += maxGlobal[i] - height[i];
			}
		}

		return sum;
    }
}