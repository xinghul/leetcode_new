class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();

		for (char ch: s.toCharArray())
		{
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}

		boolean hasSingle = false;
		for (Integer value: map.values())
		{
			if (value % 2 == 1) {
				if (hasSingle) {
					return false;
				}

				hasSingle = true;
			}
		}

		return true;
    }
}