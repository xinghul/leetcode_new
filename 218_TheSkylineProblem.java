class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> points = new ArrayList<>();

		for (int[] building: buildings)
		{
			points.add(new int[] { building[0], building[2] });
			points.add(new int[] { building[1], -building[2] });
		}

		Collections.sort(points, new Comparator<int[]>() {
			public int compare(int[] value1, int[] value2) {
				if (value1[0] != value2[0]) {
					return value1[0] - value2[0];
				}

				return value2[1] - value1[1];
			}
		});

		Queue<Integer> heights = new PriorityQueue<>((a, b) -> b - a);
		heights.add(0);

		List<int[]> result = new ArrayList<>();

		int prevHeight = 0;
		for (int[] point: points)
		{
			if (point[1] > 0) {
				heights.add(point[1]);
			} else {
				heights.remove(-point[1]);
			}

			int currentHeight = heights.peek();

			if (currentHeight != prevHeight) {
				result.add(new int[] { point[0], currentHeight });

				prevHeight = currentHeight;
			}
		}

		return result;
    }
}