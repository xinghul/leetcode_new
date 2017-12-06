class Solution {
    public String removeDuplicateLetters(String s) {
        // count letters, store in hashmap
		int[] count = new int[26];
		boolean[] visited = new boolean[26];

		for (int i = 0; i < s.length(); i++)
		{
			count[s.charAt(i) - 'a']++;
		}

		String result = "";

		for (int i = 0; i < s.length(); i++)
		{
			char ch = s.charAt(i);

			count[ch - 'a']--;

			if (!visited[ch - 'a']) {
				visited[ch - 'a'] = true;

				int tmp = 0;
				for (int j = result.length() - 1; j >= 0; j--)
				{
					if (ch < result.charAt(j) && count[result.charAt(j) - 'a'] > 0) {
						tmp++;

						visited[result.charAt(j) - 'a'] = false;
					} else {
						break;
					}
				}

				result = result.substring(0, result.length() - tmp);

				result += ch;
			}
		}
    }
}