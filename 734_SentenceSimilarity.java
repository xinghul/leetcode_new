class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
		if (words1.length != words2.length) {
			return false;
		}

        Map<String, List<String>> map = new HashMap<>();

		for (String[] pair: pairs)
		{
			if (map.containsKey(pair[0])) {
				List<String> similar = map.get(pair[0]);
				similar.add(pair[1]);

				map.put(pair[0], similar);
			} else {
				List<String> similar = new ArrayList<>();
				similar.add(pair[1]);

				map.put(pair[0], similar);
			}

			if (map.containsKey(pair[1])) {
				List<String> similar = map.get(pair[1]);
				similar.add(pair[0]);

				map.put(pair[1], similar);
			} else {
				List<String> similar = new ArrayList<>();
				similar.add(pair[0]);

				map.put(pair[1], similar);
			}
		}

		for (int i = 0; i < words1.length; i++)
		{
			String word1 = words1[i];
			String word2 = words2[i];

			if (word1.equals(word2)) {
				continue;
			}

			if (map.containsKey(word1) && map.get(word1).contains(word2)) {
				continue;
			}

			return false;
		}

		return true;
    }
}