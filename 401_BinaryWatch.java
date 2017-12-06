class Solution {
    public List<String> readBinaryWatch(int num) {
        int minHour = Math.max(0, num - 6);
		int maxHour = Math.min(4, num);

		List<String> result = new ArrayList<>();
		for (int i = minHour; i <= maxHour; i++)
		{
			List<Integer> hours = getPossibleValues(4, i);
			List<Integer> minutes = getPossibleValues(6, num - i);

			for (Integer hour: hours)
			{
				if (hour > 11) {
					continue;
				}
				for (Integer minute: minutes)
				{
					if (minute > 59) {
						continue;
					}
					String tmp = hour + ":";

					if (minute < 10) {
						tmp += "0" + minute;
					} else {
						tmp += minute;
					}

					result.add(tmp);
				}
			}
		}

		return result;
    }

	private List<Integer> getPossibleValues(int digit, int n) {
		List<Integer> values = new ArrayList<>();

		if (digit < n) {
			return values;
		}
		if (n == 0) {
			values.add(0);

			return values;
		}

		List<Integer> one = getPossibleValues(digit - 1, n - 1);
		List<Integer> zero = getPossibleValues(digit - 1, n);

		for (Integer num: zero) {
			values.add(num);
		}
		for (Integer num: one) {
			values.add((int)Math.pow(2, digit - 1) + num);
		}
		
		return values;
	}
}