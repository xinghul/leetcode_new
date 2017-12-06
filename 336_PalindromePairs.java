class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
		// instead of looping twice
		// loop once, for each word, close examine it

		Map<String, Integer> map = new HashMap<>();
		List<List<Integer>> result = new ArrayList<>();

		for (int i = 0; i < words.length; i++)
		{
			map.put(words[i], i);
		}

		for (int i = 0; i < words.length; i++)
		{
			String word = words[i];

			for (int j = 0; j <= word.length(); j++)
			{
				String str1 = word.substring(0, j);
				String str2 = word.substring(j);

				if (isPalindrome(str1)) {
					String str2rev = new StringBuilder(str2).reverse().toString();

					if (map.containsKey(str2rev) && map.get(str2rev) != i) {
						List<Integer> tmp = new ArrayList<>();
						tmp.add(map.get(str2rev));
						tmp.add(i);

						result.add(tmp);
					}
				}

				if (isPalindrome(str2)) {
					String str1rev = new StringBuilder(str1).reverse().toString();

					if (map.containsKey(str1rev) && map.get(str1rev) != i && str2.length() > 0) {
						List<Integer> tmp = new ArrayList<>();
						tmp.add(i);
						tmp.add(map.get(str1rev));

						result.add(tmp);
					}
				}
			}
		}

		return result;
    }

	private boolean isPalindrome(String s) {
		int i = 0;
		int j = s.length() - 1;

		while (i < j)
		{
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}

			i++;
			j--;
		}

		return true;
	}
}